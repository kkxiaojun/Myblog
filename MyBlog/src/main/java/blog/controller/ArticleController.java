package blog.controller;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Article;
import blog.entity.ArticleType;
import blog.entity.PageBean;
import blog.entity.Reply;
import blog.service.ArticleService;
import blog.service.ArticleTypeService;
import blog.service.ReplyService;

@Controller
public class ArticleController {
	@Resource
	private ArticleService articleService;
	@Resource
	private ArticleTypeService articleTypeService;
	@Resource
	private ReplyService replyService;
	
	/**
	 * 分页查询所有文章
	 * @param currPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin/doMarticle")
	public String findAllArticle(@RequestParam int currPage,Model model){ //
		if(currPage<1){
		   	currPage = 1;
		}
		// 查询当前展示页所有信息
		PageBean<Article> listArticle = articleService.findAll(currPage);
		// 查询所有分类
		List<ArticleType> typeList = articleTypeService.findAllType();
		// 值存储，绑定到request上
		model.addAttribute("listArticle",listArticle);
		model.addAttribute("typeList", typeList);
		// System.out.println(listArticle.getCurrPage()+":"+listArticle.getTotalCount()+":"+listArticle.getList().get(0).getContent());
		return "admin/mArticle";
	}
	/**
	 * 跳转到编辑文章页面
	 * @param article_id url后面的参数
	 * @return
	 */
	@RequestMapping(value = "/doPublish")
	public String editArticle(@RequestParam int article_id,ModelMap map){
		// 根据文章id查询
		Article article = articleService.findById(article_id);
		map.put("article",article);
		map.put("articletype", article.getArticleType());
		System.out.println("文章类别id:"+article.getArticleType().getId());
		// 查询所有文章分类
		List<ArticleType> typeList = articleTypeService.findAllType();
		map.put("typeList",typeList);
		return "admin/updateArticle";
	}
	
	/**
	 * modelAttribute方法会在springmvc controller执行之前执行
	 * @param id
	 * @param map
	 */
	@ModelAttribute  
	public void getArticle(@RequestParam(value="id",required=false) Integer id,   
	        Map<String, Object> map){  
	    System.out.println("modelAttribute method");  
	    if(id != null){  
	        //模拟从数据库中获取对象  
	        Article article = articleService.findById(id); 
	        System.out.println("从数据库中获取一个对象: " + article);  
	          
	        map.put("article", article); 
	    }  
	}
	/**
	 * 更新文章
	 * @param article
	 * @param articletype
	 * @return
	 */
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String updateArticle(Article article,@RequestParam int articletype){
		// 获取更新后的select值articletype
		System.out.println("typeId:"+articletype);
		// 更新select值
		article.getArticleType().setId(articletype);
		System.out.println("title:"+article.getTitle());
		// 更新article
		articleService.update(article);
		return "redirect:admin/doMarticle?currPage=1";
	}
	/**
	 * 删除文章
	 * @param article_id
	 * @return
	 */
    @RequestMapping(value = "/doDelete")
    public String delete(@RequestParam int article_id){
    	Article article = articleService.findById(article_id);
    	articleService.delete(article);
    	System.out.println("删除成功");
    	return "redirect:admin/doMarticle?currPage=1";
    }
    
    /**
     * 添加文章
     * @param article
     * @param articletype
     * @return
     */
    @RequestMapping(value = "/doSave", method = RequestMethod.POST)
    public String save(Article article,@RequestParam int articletype){
    	// 获取当前时间
    	java.util.Date nDate = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(nDate);
        java.sql.Date now = java.sql.Date.valueOf(sDate);
        
        ArticleType at = articleTypeService.findById(articletype);
    	article.setPubDate(now);
    	article.setArticleType(at);
    	articleService.save(article);
    	return "redirect:admin/doMarticle?currPage=1";
    }
    
    /**
     * 異步請求article
     * @return
     */
    @RequestMapping(value = "blog/article")
	@ResponseBody
	public Map<String,Object> listArticle(@RequestParam int currPage){
    	System.out.println("進入json");
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<Article> listArticle = articleService.findAll(currPage);
		// 值存储，绑定到request上
		map.put("listArticle", listArticle);
		System.out.println("json請求成功");
		return map;
	}
    /**
     * 异步请求articleShow
     */
    @RequestMapping(value = "/blog/articleShow/{id}")
  	public String article(@PathVariable int id,ModelMap map){
  		Article article = articleService.findById(id);
  		List<Reply> listReply = replyService.findReply(id);
  		System.out .println(article);
  		System.out.println(listReply);
  		// 值存储，绑定到request上
  		map.put("article", article);
  		map.put("listReply", listReply);
  		System.out.println("articles請求成功");
  		return "blog/articleShow";
  	}

}

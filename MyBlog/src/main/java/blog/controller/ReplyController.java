package blog.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import blog.entity.Article;
import blog.entity.PageBean;
import blog.entity.Reply;
import blog.service.ArticleService;
import blog.service.ReplyService;

@Controller
public class ReplyController {
	@Resource
	private ReplyService replyService;
	@Resource
	private ArticleService articleService;
	/**
	 * 分页查询reply页面
	 * @return
	 */
    @RequestMapping(value="admin/doReply")
    public String reply(@RequestParam int currPage,Model model){
    	PageBean<Reply> listReply = replyService.findAllReply(currPage);
    	// 值存储，绑定到request上
    	model.addAttribute("listReply",listReply);
    	return "admin/reply";
    }
    @RequestMapping(value="/deleteReply")
    public String delete(@RequestParam int id){
    	replyService.delete(id);
    	System.out.println("删除成功");
    	return "redirect:admin/doReply?currPage=1";
    }
   //用json显示 
    @RequestMapping(value = "blog/articleShow/reply", method = RequestMethod.GET)  
    @ResponseBody  
    public Map<String, Object> saveReply(@RequestParam String content,@RequestParam int article_id) {  
    	Map<String,Object> map=new HashMap<String,Object>(); 
    	System.out.println("进入getReply");
    	// 创建reply对象
    	Reply reply = new Reply();
    	// 获取当前时间
    	java.util.Date nDate = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(nDate);
        java.sql.Date now = java.sql.Date.valueOf(sDate);
        reply.setContent(content);
        reply.setTime(now);
        // 获取所评论文章
        Article article = articleService.findById(article_id);
        reply.setArticle(article);
    	replyService.save(reply);
    	System.out.print("saveReply()执行成功");
    	map.put("reply", reply);
      return map;  
    }
    
}

package blog.controller;

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
import blog.service.ReplyService;

@Controller
public class ReplyController {
	@Resource
	private ReplyService replyService;
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
/*   //用json显示 
 *   @RequestMapping(value = "/getReply", method = RequestMethod.GET)  
    @ResponseBody  
    public Map<String, Object> getUserList() {  
    	Map<String,Object> map=new HashMap<String,Object>(); 
    	System.out.println("进入getReply");
    	List<Reply> listReply = replyService.findAllReply();
    	System.out.print("getReply()执行成功");
    	map.put("listReply", listReply);
        map.put("success", "true");  
      return map;  
    }*/
    
}

package blog.controller;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import blog.entity.Demo;
import blog.entity.PageBean;
import blog.service.FileUpLoadService;

@Controller
public class FileUpLoadController {
	@Resource
	private FileUpLoadService demoService;

	/**
	 * 分页查询所有Demo
	 * @param currPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doDemo/{role}/{currPage}")
	public String demo(@PathVariable int currPage,@PathVariable String role, Model model) {
		if (currPage < 1) {
			currPage = 1;
		}
		// 查询当前展示页所有信息
		PageBean<Demo> listDemo = demoService.findAll(currPage);
		// 值存储，绑定到request上
		model.addAttribute("listDemo", listDemo);
		return role+"/demo";
	}
	/**
	 * 上传图片
	 * @param demo
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	private String fildUpload(Demo demo, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) throws Exception {
		// 获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path = "";
		if (!file.isEmpty()) {
			String imageName = file.getOriginalFilename();
			path = "/style/img/"+ imageName;
			System.out.println("imaageName:"+path);
			file.transferTo(new File(pathRoot + path));
		}
		// 将path保存到数据库
		demo.setUrl(path);
		demoService.save(demo);
		request.setAttribute("imagesPath", path);
		return "admin/demoPublish";
	}
	
	@RequestMapping(value = "admin/doDemoPublish")
	public String godemoPublish() {
		return "admin/demoPublish";
	}
	
	/**
	 * 删除demo及static中的img
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteFile")
	public String deleteById(@RequestParam int file_id,HttpServletRequest request ) {
		Demo demo = demoService.findById(file_id);	
		// 获得物理路径webapp所在路径
	    String pathRoot = request.getSession().getServletContext().getRealPath("");
	    File file = new File(pathRoot+demo.getUrl());
	    if(file.isFile() && file.exists()){
	    	file.delete();//"删除单个文件"
	    	System.out.println("图片删除成功");
	    }
        demoService.delete(demo);
		return "admin/doDemo?currPage=1";
	}
	
	/*前台*/
	/**
	 * 查询所有demo
	 */
	@RequestMapping(value="/doDemo")
	public String listdemo(ModelMap map){
		List<Demo> list = demoService.findAllDemo();
		map.put("list", list);
		return "blog/demo";
	}
	/**
	 * 显示当前demo
	 */
	@RequestMapping(value="/demo/show")
	public String showDemo(ModelMap map,@RequestParam int id){
		Demo demo = demoService.findById(id);
		map.put("demo", demo);
		return "blog/demoShow";
	}
	
}

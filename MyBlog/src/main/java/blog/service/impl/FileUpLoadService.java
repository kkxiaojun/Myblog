package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.dao.FileUpLoadDao;
import blog.entity.Article;
import blog.entity.ArticleType;
import blog.entity.Demo;
import blog.entity.PageBean;

@Transactional // 开启事务注解
@Service 
public class FileUpLoadService implements blog.service.FileUpLoadService {
	@Resource
	private FileUpLoadDao fileUpLoadDao;

	@Override
	public PageBean<Demo> findAll(int currPage) {
		PageBean<Demo> pageBean = new PageBean<Demo>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = fileUpLoadDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin = (currPage - 1) * pageSize;
		List<Demo> list = fileUpLoadDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Demo demo) {
		fileUpLoadDao.save(demo);
	}

	@Override
	public Demo findById(int id) {
		return fileUpLoadDao.findById(id);
	}

	@Override
	public void delete(Demo demo) {
		fileUpLoadDao.delete(demo);
		
	}

	@Override
	public List<Demo> findAllDemo() {
		return fileUpLoadDao.findAllDemo();
	}
	
}

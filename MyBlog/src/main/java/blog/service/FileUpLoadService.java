package blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import blog.entity.Demo;
import blog.entity.PageBean;

public interface FileUpLoadService {

	PageBean<Demo> findAll(int currPage);

	void save(Demo demo);

	Demo findById(int id);

	void delete(Demo demo);

	List<Demo> findAllDemo();

}

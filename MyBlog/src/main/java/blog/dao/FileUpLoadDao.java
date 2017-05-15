package blog.dao;

import java.util.List;

import blog.entity.Demo;
import blog.entity.PageBean;

public interface FileUpLoadDao {

	int findCount();

	List<Demo> findAll(int begin, int pageSize);

	void save(Demo demo);

	Demo findById(int id);

	void delete(Demo demo);

	List<Demo> findAllDemo();


}

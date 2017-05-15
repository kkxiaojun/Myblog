package blog.dao;

import java.util.List;

import blog.entity.ArticleType;

public interface ArticleTypeDao {

	List<ArticleType> findAll();

	int findCount();

	List<ArticleType> findAll(int begin, int pageSize);

	ArticleType findById(Integer id);

	void update(ArticleType articletype);

	void save(ArticleType at);

	void delete(ArticleType at);

}

package blog.dao;

import java.util.List;

import blog.entity.Article;

public interface ArticleDao {

	int findCount();

	List<Article> findAll(int begin, int pageSize);

	Article findById(int article_id);

	void update(Article article);

	void delete(Article article);

	void save(Article article);


}

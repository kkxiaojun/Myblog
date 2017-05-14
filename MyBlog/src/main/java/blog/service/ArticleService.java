package blog.service;

import blog.entity.Article;
import blog.entity.PageBean;
import blog.entity.Reply;

public interface ArticleService {

	PageBean<Article> findAll(Integer currPage);

	Article findById(int article_id);

	void update(Article article);

	void delete(Article article);

	void save(Article article);

}

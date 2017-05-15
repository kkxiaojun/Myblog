package blog.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import blog.dao.ArticleDao;
import blog.entity.Article;
import blog.entity.PageBean;

@Transactional // 开启事务注解
@Service 
public class ArticleService implements blog.service.ArticleService {
	@Resource
	private ArticleDao articleDao;
//    private ArticleTypeDao articletypeDao;
	/**
	 * 分页查询article,service实现
	 */
	@Override
	public PageBean<Article> findAll(Integer currPage) {
		PageBean<Article> pageBean = new PageBean<Article>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = articleDao.findCount();
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
		List<Article> list = articleDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
    /**
     * 根据id查询article，service实现
     */
	@Override
	public Article findById(int article_id) {
		Article a = articleDao.findById(article_id);
		return a;
	}
	/**
	 * 更新文章
	 */
	@Override
	public void update(Article article) {
		articleDao.update(article);
		
	}
	/**
	 * 删除文章
	 */
	@Override
	public void delete(Article article) {
		articleDao.delete(article);
		
	}
	/**
	 * 添加文章
	 */
	@Override
	public void save(Article article) {
		articleDao.save(article);
	}
}

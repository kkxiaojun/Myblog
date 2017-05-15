package blog.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import blog.entity.Article;

@Repository
public class ArticleDao extends HibernateDaoSupport implements blog.dao.ArticleDao {
    
	/**
	 * 查询article总数，dao实现
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Article";
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		System.out.println("articleDao.findCount()");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
    
	/**
	 * 根据begin,pageSize查询数据，dao实现
	 */
	@Override
	public List<Article> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		// 查询分页数据
		@SuppressWarnings("unchecked")
		List<Article> list = (List<Article>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		System.out.println("articleDao.findAll()");
		return list;
	}
	/**
	 * 根据id查询article，Dao实现
	 */
	@Override
	public Article findById(int article_id) {
		Article a = this.getHibernateTemplate().get(Article.class, article_id);
		return a;
	}
	/**
	 * 更新文章
	 */
	@Override
	public void update(Article article) {
		this.getHibernateTemplate().update(article);		
	}
	/**
	 * 删除文章
	 */
	@Override
	public void delete(Article article) {
		this.getHibernateTemplate().delete(article);
		
	}
	/**
	 * 添加文章
	 */
	@Override
	public void save(Article article) {
		this.getHibernateTemplate().save(article);
	}


}

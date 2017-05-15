package blog.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import blog.entity.ArticleType;

@Repository
public class ArticleTypeDao extends HibernateDaoSupport implements blog.dao.ArticleTypeDao{
    
	/**
	 * 查询所有articleType
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleType> findAll() {
		String hql="from ArticleType";
		return (List<ArticleType>) this.getHibernateTemplate().find(hql);
	}
    /**
     * 查询articleType总数
     */
	@Override
	public int findCount() {
		// 注意articletype的大小写要与entity对应
		String hql = "select count(*) from ArticleType";
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		System.out.println("articletypeDao.findCount()");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
    /**
     * 分页查询articleType
     */
	@Override
	public List<ArticleType> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ArticleType.class);
		// 查询分页数据
		@SuppressWarnings("unchecked")
		List<ArticleType> list = (List<ArticleType>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		System.out.println("articleTypeDao.findAll()");
		return list;
	}
	/**
	 * 根据id查询ArticleType
	 */
	@Override
	public ArticleType findById(Integer id) {		
		return this.getHibernateTemplate().get(ArticleType.class, id);
	}
	/**
	 * 更新文章类别
	 */
	@Override
	public void update(ArticleType articletype) {
		this.getHibernateTemplate().update(articletype);
	}
	/**
	 * 添加文章类别
	 */
	@Override
	public void save(ArticleType at) {
		this.getHibernateTemplate().save(at);
	}
	/**
	 * 删除文章类别
	 */
	@Override
	public void delete(ArticleType at) {
		this.getHibernateTemplate().delete(at);
	}

}

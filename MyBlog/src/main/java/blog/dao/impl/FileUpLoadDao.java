package blog.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import blog.entity.Demo;

@Repository
public class FileUpLoadDao extends HibernateDaoSupport implements blog.dao.FileUpLoadDao{
	/**
	 * 查询所有demo
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Demo";
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		System.out.println("articleDao.findCount()");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public List<Demo> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Demo.class);
		// 查询分页数据
		@SuppressWarnings("unchecked")
		List<Demo> list = (List<Demo>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		System.out.println("articleDao.findAll()");
		return list;
	}
	
	/**
	 * 保存图片信息
	 */
	@Override
	public void save(Demo demo) {
		this.getHibernateTemplate().save(demo);
	}
	/**
	 * 根据id查询demo
	 */
	@Override
	public Demo findById(int id) {
		return this.getHibernateTemplate().get(Demo.class, id);
	}
	/**
	 * 删除demo
	 */
	@Override
	public void delete(Demo demo) {
		this.getHibernateTemplate().delete(demo);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demo> findAllDemo() {
		// TODO Auto-generated method stub
		return (List<Demo>) this.getHibernateTemplate().find("from Demo");
	}

}

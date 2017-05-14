package blog.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import blog.entity.Article;
import blog.entity.Reply;

@Repository
public class ReplyDao extends HibernateDaoSupport implements blog.dao.ReplyDao{

	@Override
	public int findCount() {
		String hql = "select count(*) from Reply";
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		System.out.println("articleDao.findCount()");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Reply> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reply.class);
		// 查询分页数据
		@SuppressWarnings("unchecked")
		List<Reply> list = (List<Reply>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		System.out.println("ReplyDao.findAll()");
		return list;
	}

	@Override
	public void delete(int id) {
		Reply a = this.getHibernateTemplate().get(Reply.class, id);
		this.getHibernateTemplate().delete(a);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> findReply(int id) {
		return (List<Reply>) this.getHibernateTemplate().get(Reply.class, id);
	}

}

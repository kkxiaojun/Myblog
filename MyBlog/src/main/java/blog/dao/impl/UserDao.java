package blog.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import blog.entity.User;

@Repository
public class UserDao extends HibernateDaoSupport implements blog.dao.UserDao {

	@Override
	public User login(User user) {
		String hql = "from User where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<User> userList =  (List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
		if(userList.size()>0){
			// 查到数据返回第一个
			System.out.println(userList.get(0).getUsername()+"查找成功");
			return userList.get(0);
		}
		return null;
	}

	@Override
	public User findUser(int i) {
		return this.getHibernateTemplate().get(User.class, i);
	}
   /**
    * 更新基本资料
    */
	@Override
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);		
	}

    /**
     * 更新密码，账号
     */
	@Override
	public void updateUserPassword(User user) {
		User u = this.getHibernateTemplate().get(User.class, user.getId());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		this.getHibernateTemplate().update(u);
		
	}

	
}

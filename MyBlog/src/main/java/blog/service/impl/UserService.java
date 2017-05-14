package blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import blog.dao.UserDao;
import blog.entity.User;

@Transactional
@Service
public class UserService implements blog.service.UserService{
	
	@Resource
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public User findUser(int i) {
		return userDao.findUser(i);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void updateUserPassword(User user) {
		userDao.updateUserPassword(user);
	}

}


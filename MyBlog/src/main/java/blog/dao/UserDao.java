package blog.dao;

import blog.entity.User;

public interface UserDao {

	User login(User user);
	User findUser(int i);
	void updateUser(User user);
	void updateUserPassword(User user);

}

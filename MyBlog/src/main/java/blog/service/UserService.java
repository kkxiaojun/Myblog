package blog.service;

import blog.entity.User;

public interface UserService {

	User login(User user);

	User findUser(int i);

	void updateUser(User user);

	void updateUserPassword(User user);

}

package blog.dao;

import java.util.List;
import blog.entity.Reply;

public interface ReplyDao {

	int findCount();

	List<Reply> findAll(int begin, int pageSize);

	void delete(int id);

	List<Reply> findReply(int id);

	void save(Reply reply);

}

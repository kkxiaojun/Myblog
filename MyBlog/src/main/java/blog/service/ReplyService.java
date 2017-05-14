package blog.service;

import java.util.List;

import blog.entity.PageBean;
import blog.entity.Reply;

public interface ReplyService {

	PageBean<Reply> findAllReply(int currPage);

	void delete(int id);

	List<Reply> findReply(int id);


}

package blog.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import blog.dao.ReplyDao;
import blog.entity.PageBean;
import blog.entity.Reply;

@Transactional
@Service
public class ReplyService implements blog.service.ReplyService{
	
	@Resource
	private ReplyDao replyDao;

	@Override
	public PageBean<Reply> findAllReply(int currPage) {
		PageBean<Reply> pageBean = new PageBean<Reply>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = replyDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin = (currPage - 1) * pageSize;
		List<Reply> list = replyDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void delete(int id) {
		replyDao.delete(id);
	}

	@Override
	public List<Reply> findReply(int id) {
		return replyDao.findReply(id);
	}



}

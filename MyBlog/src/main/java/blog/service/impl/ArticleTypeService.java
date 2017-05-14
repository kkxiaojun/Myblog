package blog.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import blog.dao.ArticleTypeDao;
import blog.entity.ArticleType;
import blog.entity.PageBean;

@Transactional
@Service
public class ArticleTypeService implements blog.service.ArticleTypeService {
	@Resource
	private ArticleTypeDao articleTypeDao;
    /**
     * 查找所有文章类型
     */
	@Override
	public List<ArticleType> findAllType() {
		return articleTypeDao.findAll();
	}
	
    /**
     * 分页查询文章类型
     */
	@Override
	public PageBean<ArticleType> findAll(int currPage) {
		PageBean<ArticleType> pageBean = new PageBean<ArticleType>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = articleTypeDao.findCount();
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
		List<ArticleType> list = articleTypeDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
    /**
     * 根据id查询articletype
     */
	@Override
	public ArticleType findById(Integer id) {
		return articleTypeDao.findById(id);
	}
	/**
	 * 更新文章类型
	 */
	@Override
	public void update(ArticleType articletype) {
		articleTypeDao.update(articletype);
		
	}
    /**
     * 增加文章分类
     */
	@Override
	public void save(ArticleType at) {
		articleTypeDao.save(at);
	}
    /**
     * 删除文章分类
     */
	@Override
	public void delete(ArticleType at) {
		articleTypeDao.delete(at);
	}
}

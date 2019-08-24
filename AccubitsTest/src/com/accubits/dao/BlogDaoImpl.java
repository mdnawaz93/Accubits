package com.accubits.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accubits.constant.MessageConstant;
import com.accubits.model.BlogForm;

@Repository
@Transactional
public class BlogDaoImpl extends AbstractDao implements BlogDao {

	@Override
	public List<BlogForm> getBlogList(int userId) {
		List<BlogForm> blogList = null;
		try {
			blogList = getSession().createCriteria(BlogForm.class).add(Restrictions.eq("user.id", userId)).list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return blogList;
	}

	@Override
	public String saveBlog(BlogForm blog) {
		try {
			getSession().saveOrUpdate(blog);
			return MessageConstant.success;
		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
			return MessageConstant.fail;
		}
	}

}

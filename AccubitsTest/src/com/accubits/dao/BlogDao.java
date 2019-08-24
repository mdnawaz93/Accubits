package com.accubits.dao;

import java.util.List;

import com.accubits.model.BlogForm;

public interface BlogDao {
	
	public List<BlogForm> getBlogList(int userId);
	public String saveBlog(BlogForm blog);

}

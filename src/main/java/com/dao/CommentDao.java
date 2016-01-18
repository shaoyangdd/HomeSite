package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Comment;
/**
 * 
 * <p>Description: 评论DAO</p>
 * @author kangshaofei
 * @date  2016-01-17
 */
public interface CommentDao {
	/**
	 * 保存评论
	 * @param comment
	 */
	void saveComment(Comment comment);
	/**
	 * 查询评论
	 * @param comment
	 * @return list
	 */
	List<Map<String,Object>> queryComments(Comment comment);
}

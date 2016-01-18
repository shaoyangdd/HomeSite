package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Comment;

/**
 * <p>Description: 服务类接口</p>
 * @author kangshaofei
 * @date 2016年1月17日
 */
public interface CommentService {
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

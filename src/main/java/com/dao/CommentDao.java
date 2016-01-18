package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Comment;
/**
 * 
 * <p>Description: ����DAO</p>
 * @author kangshaofei
 * @date  2016-01-17
 */
public interface CommentDao {
	/**
	 * ��������
	 * @param comment
	 */
	void saveComment(Comment comment);
	/**
	 * ��ѯ����
	 * @param comment
	 * @return list
	 */
	List<Map<String,Object>> queryComments(Comment comment);
}

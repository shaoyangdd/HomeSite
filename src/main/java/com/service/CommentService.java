package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Comment;

/**
 * <p>Description: ������ӿ�</p>
 * @author kangshaofei
 * @date 2016��1��17��
 */
public interface CommentService {
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

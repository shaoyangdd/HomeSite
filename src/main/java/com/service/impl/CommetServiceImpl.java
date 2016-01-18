package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommentDao;
import com.entity.Comment;
import com.service.CommentService;

/**
 * <p>Description: ���۷���ʵ����</p>
 * @author kangshaofei
 * @date 2016��1��17��
 */
@Service("commetServiceImpl")
public class CommetServiceImpl implements CommentService{
	@Autowired
	private CommentDao comentDao;

	public void saveComment(Comment comment) {
	   comentDao.saveComment(comment);
	}

	public List<Map<String, Object>> queryComments(Comment comment) {
		return comentDao.queryComments(comment);
	}
	
}

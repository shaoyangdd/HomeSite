package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommentDao;
import com.entity.Comment;
import com.service.CommentService;

/**
 * <p>Description: 评论服务实现类</p>
 * @author kangshaofei
 * @date 2016年1月17日
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

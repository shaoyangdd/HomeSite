package com.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Comment;
import com.service.CommentService;

/**
 * <p>Description: ���ۿ�����</p>
 * @author kangshaofei
 * @date 2016��1��17��
 */
@Controller
@RequestMapping("/comment")
public class CommetnAction {
	
	private static final Logger logger = LoggerFactory.getLogger(CommetnAction.class);
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * �������
	 * ajax POST ������Ӧ����json��
	 * @param comment
	 * @return comment
	 */
	@RequestMapping(value="/saveComments.ajax", method = RequestMethod.POST)
     public @ResponseBody Comment saveComments(@RequestBody Comment comment){
        logger.info("Ҫ���������Ϊ��"+comment.toString());
        commentService.saveComment(comment);
        logger.info("�������۳ɹ���");
        return comment;
	}
	
	/**
	 * ��ѯ����
	 * ajax POST ������Ӧ����json��
	 * @param comment
	 * @return list
	 */
	@RequestMapping(value="/queryComments.ajax", method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> queryComments(@RequestParam("count") String count){
        logger.info("��ѯ����"+count+"������");
        Comment comment = new Comment();
        comment.setExtFld(count);
        List<Map<String,Object>> resultList = commentService.queryComments(comment);
        logger.info("��ѯ����"+count+"�����۳ɹ���");
        return resultList;
	}
	
}

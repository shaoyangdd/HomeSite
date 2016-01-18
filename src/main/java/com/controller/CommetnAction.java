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
 * <p>Description: 评论控制器</p>
 * @author kangshaofei
 * @date 2016年1月17日
 */
@Controller
@RequestMapping("/comment")
public class CommetnAction {
	
	private static final Logger logger = LoggerFactory.getLogger(CommetnAction.class);
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 添加评论
	 * ajax POST 请求响应都是json串
	 * @param comment
	 * @return comment
	 */
	@RequestMapping(value="/saveComments.ajax", method = RequestMethod.POST)
     public @ResponseBody Comment saveComments(@RequestBody Comment comment){
        logger.info("要保存的评论为："+comment.toString());
        commentService.saveComment(comment);
        logger.info("保存评论成功！");
        return comment;
	}
	
	/**
	 * 查询评论
	 * ajax POST 请求响应都是json串
	 * @param comment
	 * @return list
	 */
	@RequestMapping(value="/queryComments.ajax", method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> queryComments(@RequestParam("count") String count){
        logger.info("查询最新"+count+"条评论");
        Comment comment = new Comment();
        comment.setExtFld(count);
        List<Map<String,Object>> resultList = commentService.queryComments(comment);
        logger.info("查询最新"+count+"条评论成功！");
        return resultList;
	}
	
}

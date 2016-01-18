package com.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.CommentDao;
import com.entity.Comment;

import util.StringUtil;
/**
 * <p>Description: 评论Dao实现类</p>
 * @author kangshaofei
 * @date 2016年1月17日
 */
@Repository
public class CommentDaoImpl implements CommentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveComment(Comment comment) {
		String sql = "insert into homesite.COMMENTS(user_id,comments,ext_fld) values (?,?,?)";
		jdbcTemplate.update(sql, new Object[]{comment.getUserId(),comment.getComments(),comment.getExtFld()});
	}

	public List<Map<String, Object>> queryComments(Comment comment) {
		StringBuilder sql = new StringBuilder("select COMMENTS,EXT_FLD,date_format(crt_time,'%Y-%c-%d %h:%i:%s') as crt_time from homesite.COMMENTS where 1=1 ");
		if(comment.getId()!=0)
			sql.append("and id=? ");
		if(comment.getUserId()!=0)
			sql.append("and user_id=?");
		if(StringUtil.isNotEmpty(comment.getExtFld()))
			sql.append("order by id desc limit "+ Integer.parseInt(comment.getExtFld()));
		List<Map<String,Object>> result = jdbcTemplate.queryForList(sql.toString());
		return result;
	}

}

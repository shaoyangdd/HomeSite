package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.AccountAndPasswordDao;
import com.entity.AccountAndPassword;

import util.StringUtil;

@Repository
public class AccountAndPasswordDaoImpl implements AccountAndPasswordDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> query(AccountAndPassword nameAndPassword) {
		StringBuilder sql = new StringBuilder("select * from homesite.AC_PWD where 1=1 ");
		if(nameAndPassword.getId()!=0){
			sql.append("and ID="+nameAndPassword.getId()+" ");
		}
		if(StringUtil.isNotEmpty(nameAndPassword.getName())){
			sql.append("and NAME like '%"+nameAndPassword.getName()+"%'");
		}
		List<Map<String,Object>> result = jdbcTemplate.queryForList(sql.toString());
		return result;
	}

}

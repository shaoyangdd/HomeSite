package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountAndPasswordDao;
import com.entity.AccountAndPassword;
import com.service.NameAndPasswordService;

@Service("nameAndPasswordServiceImpl")
public class NameAndPasswordServiceImpl implements NameAndPasswordService {

	@Autowired
	private AccountAndPasswordDao nameAndPasswordDao;
	
	public List<Map<String, Object>> query(AccountAndPassword nameAndPassword) {
		return nameAndPasswordDao.query(nameAndPassword);
	}

	public void setNameAndPasswordDao(AccountAndPasswordDao nameAndPasswordDao) {
		this.nameAndPasswordDao = nameAndPasswordDao;
	}
}

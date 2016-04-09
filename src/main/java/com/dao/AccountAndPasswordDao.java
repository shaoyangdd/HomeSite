package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.AccountAndPassword;

public interface AccountAndPasswordDao {
	List<Map<String,Object>> query(AccountAndPassword nameAndPassword);
}

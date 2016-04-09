package com.service;

import java.util.List;
import java.util.Map;

import com.entity.AccountAndPassword;

public interface NameAndPasswordService {
	List<Map<String,Object>> query(AccountAndPassword nameAndPassword);
}

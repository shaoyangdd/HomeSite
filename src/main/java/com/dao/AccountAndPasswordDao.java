package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.AccountAndPassword;

/**
 *
 * <p>Description: ’À∫≈√‹¬ÎDAO</p>
 * @author kangshaofei
 * @date  2016-04-13
 */
public interface AccountAndPasswordDao {
	List<Map<String,Object>> query(AccountAndPassword nameAndPassword);
}

package com.service;

import java.util.List;
import java.util.Map;

import com.entity.AccountAndPassword;
/**
 * <p>Description: 账号密码服务类接口</p>
 * @author kangshaofei
 * @date 2016年04月13日
 */
public interface NameAndPasswordService {
	List<Map<String,Object>> query(AccountAndPassword nameAndPassword);
}

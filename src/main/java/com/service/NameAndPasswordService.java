package com.service;

import java.util.List;
import java.util.Map;

import com.entity.AccountAndPassword;
/**
 * <p>Description: �˺����������ӿ�</p>
 * @author kangshaofei
 * @date 2016��04��13��
 */
public interface NameAndPasswordService {
	List<Map<String,Object>> query(AccountAndPassword nameAndPassword);
}

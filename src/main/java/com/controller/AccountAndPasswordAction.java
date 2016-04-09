package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.AccountAndPassword;
import com.service.NameAndPasswordService;

@Controller
@RequestMapping("/accountandpassword")
public class AccountAndPasswordAction {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountAndPasswordAction.class);
	
	@Autowired
	private NameAndPasswordService accountAndPasswordService;
	
	@RequestMapping(value="/query.ajax", method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> query(@RequestParam("count") String count,@RequestParam("name") String name) throws UnsupportedEncodingException{
        logger.info("查询最新"+count+"条");
        AccountAndPassword nap = new AccountAndPassword();
        nap.setExtFld(count);
        nap.setName(new String(name.getBytes(),"GBK"));
        nap.setName(new String(name.getBytes(),"UTF-8"));
        List<Map<String,Object>> resultList = accountAndPasswordService.query(nap);
        logger.info("查询最新"+count+"条成功！");
        return resultList;
	}
}

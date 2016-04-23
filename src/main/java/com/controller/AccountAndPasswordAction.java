package com.controller;

import com.entity.AccountAndPassword;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.NameAndPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import util.RedisUtil;
import util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/accountandpassword")
public class AccountAndPasswordAction {

    private static final Logger logger = LoggerFactory.getLogger(AccountAndPasswordAction.class);

    @Autowired
    private NameAndPasswordService accountAndPasswordService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ModelAndView query(@RequestParam("count") String count, @RequestParam("name") String name) throws UnsupportedEncodingException, JsonProcessingException {
        logger.info("查询账号密码 find account and password start");
        ModelAndView mav = new ModelAndView();
        logger.info("查询redis……find from redis start");
        String resultString = RedisUtil.findFromRedis("resultList", redisTemplate);
        logger.info("查询redis……find from redis end");
        String jsonResult;
        if (StringUtil.isNotEmpty(resultString)) {
            jsonResult = resultString;
        } else {
            AccountAndPassword nap = new AccountAndPassword();
            nap.setExtFld(count);
            nap.setName(new String(name.getBytes(), "GBK"));
            nap.setName(new String(name.getBytes(), "UTF-8"));
            List<Map<String, Object>> resultList = accountAndPasswordService.query(nap);
            ObjectMapper objectMapper = new ObjectMapper();
            jsonResult = objectMapper.writeValueAsString(resultList);
            logger.info("放入redis……put to redis start");
            RedisUtil.putToRedis("resultList", jsonResult, redisTemplate);
            logger.info("放入redis……put to redis end");
        }
        logger.info("查询账号密码 find account and password end");
        mav.addObject("resultList", jsonResult);
        return mav;
    }

}

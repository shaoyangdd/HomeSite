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
        String jsonResult;
        //只缓存所有的，模糊查询的不从redis中查找，而是从mysql中查询
        if(StringUtil.isEmpty(name)){
            logger.info("name is empty!!");
            logger.info("查询redis……find from redis start");
            String resultString = RedisUtil.findFromRedis("resultList", redisTemplate);
            logger.info("查询redis……find from redis end");
            if (StringUtil.isNotEmpty(resultString)) {
                jsonResult = resultString;
            } else {
                AccountAndPassword nap = new AccountAndPassword();
                nap.setExtFld(count);
                nap.setName(new String(name.getBytes(), "UTF-8"));
                List<Map<String, Object>> resultList = accountAndPasswordService.query(nap);
                ObjectMapper objectMapper = new ObjectMapper();
                jsonResult = objectMapper.writeValueAsString(resultList);
                logger.info("放入redis……put to redis start");
                RedisUtil.putToRedis("resultList", jsonResult, redisTemplate);
                logger.info("放入redis……put to redis end");
            }
        }else{
            AccountAndPassword nap = new AccountAndPassword();
            nap.setExtFld(count);
            nap.setName(new String(name.getBytes(), "UTF-8"));
            List<Map<String, Object>> resultList = accountAndPasswordService.query(nap);
            ObjectMapper objectMapper = new ObjectMapper();
            jsonResult = objectMapper.writeValueAsString(resultList);
        }
        logger.info("查询账号密码 find account and password end");
        mav.addObject("resultList", jsonResult);
        return mav;
    }

}

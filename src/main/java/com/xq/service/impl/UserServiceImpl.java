package com.xq.service.impl;

import com.xq.dao.UserDao;
import com.xq.rabbitmq.MQReceiver;
import com.xq.rabbitmq.MQSender;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/13 21:32
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserDao userDao;

    @Autowired
    MQSender mqSender;

    @Autowired
    MQReceiver mqReceiver;


    @Override
    public Map getUser(Serializable id) {
//        return userDao.getUser(id);
        mqSender.sendMessage(id);

        return null;
    }

}

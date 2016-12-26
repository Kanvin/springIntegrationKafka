package com.zpq.service.impl;

import com.zpq.dao.UserDao;
import com.zpq.model.User;
import com.zpq.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import java.util.Map;

public class DfConsumerServiceImpl implements ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(DfConsumerServiceImpl.class);

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void processMessage(Message<User> message) {

        Map userMap = (Map) message.getPayload();
        String userName = (String)userMap.get("name");
        String userPassword = (String)userMap.get("password");
        userDao.addUser(new User(userName, userPassword));

        logger.info("DfConsumerServiceImpl consumed: " + message.toString());
        logger.info("DF PAYLOAD: " + message.getPayload());

    }
}

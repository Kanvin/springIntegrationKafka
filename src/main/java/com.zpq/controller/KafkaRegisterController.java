package com.zpq.controller;

import com.zpq.model.User;
import com.zpq.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kafka")
public class KafkaRegisterController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaRegisterController.class);

    @Autowired
    private ProducerService registerProducerServiceImpl;

    @RequestMapping(value ="/register", method = RequestMethod.POST )
    @ResponseBody
    public Boolean register(@RequestBody User user){

        logger.info("register controller started");
        boolean result = registerProducerServiceImpl.sendMessage(user);

        return result;
    }
}

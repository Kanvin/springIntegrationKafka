package com.zpq.service.impl;

import com.zpq.model.User;
import com.zpq.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class RegisterProducerServiceImpl implements ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(RegisterProducerServiceImpl.class);
    public static final String REGISTER_TOPIC = "registerMessageTopic";


    @Autowired
    @Qualifier("inputToKafka")
    private MessageChannel messageChannel;

    @Override
    public boolean sendMessage(User user) {

        logger.info("RegisterProducerServiceImpl sent a message to :" + REGISTER_TOPIC);
        boolean result = messageChannel.send(MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, REGISTER_TOPIC).build());
        logger.info("Message from RegisterProducerServiceImpl was sent successfully: " + result);

        return result;
    }
}

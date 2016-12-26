package com.zpq.service;

import com.zpq.model.User;
import org.springframework.messaging.Message;

public interface ConsumerService {

    void processMessage(Message<User> message);
}

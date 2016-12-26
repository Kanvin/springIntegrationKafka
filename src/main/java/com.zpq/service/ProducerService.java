package com.zpq.service;


import com.zpq.model.User;

public interface ProducerService {

    public boolean sendMessage(User user);
}

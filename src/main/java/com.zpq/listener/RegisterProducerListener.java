package com.zpq.listener;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListenerAdapter;


public class RegisterProducerListener extends ProducerListenerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterProducerListener.class);

    @Override
    public boolean isInterestedInSuccess() {
        return true;
    }

    /**
     *
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param recordMetadata
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        super.onSuccess(topic, partition, key, value, recordMetadata);
        LOG.info("******* OnMessage : offset [{}]  partition [{}]", recordMetadata.offset(), recordMetadata.partition());
    }

    /**
     *
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param exception
     */
    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        super.onError(topic, partition, key, value, exception);
        LOG.info("******* Topic :{}, Partition : {}, Key : {}, Value : {}", topic, partition, key, value, exception.getMessage());
    }
}
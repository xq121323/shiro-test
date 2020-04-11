package com.xq.rabbitmq;

import com.xq.config.RabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/13 18:05
 */
@Service
public class MQSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) {
        System.out.println("发送的消息：" + message);
        amqpTemplate.convertAndSend(RabbitmqConfig.DIRECT_QUEUE, String.valueOf(message));
    }

}

package com.xq.rabbitmq;

import com.xq.config.RabbitmqConfig;
import com.xq.dao.UserDao;
import org.apache.catalina.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/13 18:12
 */
@Service
public class MQReceiver {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserDao userDao;

    @RabbitListener(queues = RabbitmqConfig.DIRECT_QUEUE)
    public void receiver(Object message) {
        Map user=null;
        System.out.println("接受到的消息：" + message);

        if (message instanceof Message) {
            String s = new String(((Message) message).getBody(), Charset.forName("UTF-8"));
            try {
                System.out.println(s);
                user = userDao.getUser(s);
                System.out.println(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

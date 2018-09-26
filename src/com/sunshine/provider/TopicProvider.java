package com.sunshine.provider;

import com.sunshine.entity.MsgEntity;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Package:   com.sunshine.provider 
 * @ClassName: TopicProvider
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年09月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
public class TopicProvider {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.200.225:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic testTopic = session.createTopic("testTopic");
        MessageProducer producer = session.createProducer(testTopic);
        TextMessage textMessage = session.createTextMessage("topic数据");
        producer.send(textMessage);
        connection.close();
    }
}

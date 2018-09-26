package com.sunshine.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.*;

/**
 * @Package:   com.sunshine.consumer
 * @ClassName: Consummer
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年09月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
public class TopicSpringConsumer {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.200.225:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic testTopic = session.createTopic("testTopic");
        MessageConsumer consumer = session.createConsumer(testTopic);
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        adapter.setDelegate(new TextDelegate());
        consumer.setMessageListener(adapter);
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

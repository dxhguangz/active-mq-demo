package com.sunshine.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

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
public class TopicConsumer {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.200.225:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Thread thread1 = new Thread(() -> {
            receive(connection);
        });

        thread1.start();
        Connection connection1 = connectionFactory.createConnection();
        connection1.start();
        Thread thread2 = new Thread(() -> {
            receive(connection1);
        });
        thread2.start();
    }

    private static void receive(Connection connection) {
        Session session;
        try {
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("testTopic");
            MessageConsumer consumer = session.createConsumer(topic);
            TextMessage receive = (TextMessage)consumer.receive(5000 * 10);
            System.out.println(receive.getText());
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

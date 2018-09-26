package com.sunshine.provider;

import com.sunshine.entity.MsgEntity;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Package:   com.sunshine.provider 
 * @ClassName: MsgProvider
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年09月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
public class QueueProvider {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.200.225:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue testQueue = session.createQueue("testQueue");
        MessageProducer producer = session.createProducer(testQueue);
        ObjectMessage objectMessage = session.createObjectMessage();
        objectMessage.setObject(new MsgEntity("求知",50));
        producer.send(objectMessage);
        connection.close();
    }

}

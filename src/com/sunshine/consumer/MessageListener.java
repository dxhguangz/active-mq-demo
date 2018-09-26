package com.sunshine.consumer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.*;

/**
 * @Package:   com.sunshine 
 * @ClassName: MessageListener
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年09月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
public class MessageListener extends MessageListenerAdapter {


    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        TextMessage message1 = (TextMessage) message;
        System.out.println("消息监听:"+message1.getText());
        super.onMessage(message, session);
    }
}

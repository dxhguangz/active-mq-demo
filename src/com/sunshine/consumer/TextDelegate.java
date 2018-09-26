package com.sunshine.consumer;
/**
 * @Package:   com.sunshine.consumer 
 * @ClassName: TextDelegate
 * @Statement: <p></p>
 * @JDK version used: 1.8
 * @Author: 胆木
 * @Create Date: 2018年09月26日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 3.0
 */
public class TextDelegate{
    public void handleMessage(String text){
        System.out.println("TextDelegate");
        System.out.println(text);
    }
}

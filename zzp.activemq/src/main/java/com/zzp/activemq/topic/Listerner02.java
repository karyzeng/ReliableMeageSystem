package com.zzp.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listerner02 implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println("������02���յ���Ϣ��"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

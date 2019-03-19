package com.zzp.activemq.queue;

import com.zzp.activemq.common.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

public class MQConsumer {

    public static void main(String[] args) {
        // ���ӹ���
        ConnectionFactory connectionFactory;
        // ����ʵ��
        Connection connection = null;
        // �շ����߳�ʵ��
        Session session;
        // ��Ϣ����Ŀ���ַ
        Destination destination;
        try {
            // ʵ�������ӹ���
            connectionFactory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKETURL);
            // ��ȡ����ʵ��
            connection = connectionFactory.createConnection();
            // ��������
            connection.start();
            // �������ջ��͵��߳�ʵ���������߾Ͳ���Ҫ���������ˣ�
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            // �������У�����һ����ϢĿ�ĵأ�
            destination = session.createQueue("parryQuene");
            // ������Ϣ������
            MessageConsumer consumer = session.createConsumer(destination);
            //ע����Ϣ����
            consumer.setMessageListener(new MQListerner());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

package org.com.muggle.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.com.muggle.service.ProducerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service(value="producerService")
public class ProducerServiceImpl implements ProducerService {

	@Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage(Destination destination, String msg) {
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

	@Override
	public void sendMessage(String msg) {
		jmsTemplate.send( new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}

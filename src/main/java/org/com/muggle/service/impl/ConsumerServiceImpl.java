package org.com.muggle.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.com.muggle.service.ConsumerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service(value = "consumerService")
public class ConsumerServiceImpl implements ConsumerService {
    Logger myLogger = Logger.getLogger("ConsumerServiceImpl");    

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Override
	public String receive(Destination destination) {
		TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
		try {
			return tm.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return "";
	}

}

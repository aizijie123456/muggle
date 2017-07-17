package org.com.muggle.listener;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;
import org.com.muggle.service.ConsumerService;
import org.springframework.jms.core.JmsTemplate;

public class MessageConsumerListener implements MessageListener {
	Logger myLogger = Logger.getLogger("MessageConsumerListener");

	@Resource(name = "consumerService")
	private ConsumerService consumerService;
	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	// invoke this method when you receive a message
	@Override
	public void onMessage(Message message) {
		Destination destination = jmsTemplate.getDefaultDestination();
		String consumData = consumerService.receive(destination);
		myLogger.info("consume data:" + consumData);
	}

}

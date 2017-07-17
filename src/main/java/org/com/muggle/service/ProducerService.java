package org.com.muggle.service;

import javax.jms.Destination;

public interface ProducerService {
    public void sendMessage(Destination destination, final String msg);
    public void sendMessage(final String msg);
}

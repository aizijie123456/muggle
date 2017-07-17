package org.com.muggle.service;

import javax.jms.Destination;

public interface ConsumerService {
    public String receive(Destination destination);
}

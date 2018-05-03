package ru.myapp.app;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.Date;

@Stateless
public class MessageProducerImpl implements MessageProducer {

    @Inject
    @JMSConnectionFactory("jms/ConnectionFactory")
    private JMSContext context;
    @Resource(lookup = "jms/queue/Queue")
    private Queue queue;

    @Override
    public String sendMessage(String message) {
        context.createProducer().send(queue, "Text message sent at " + new Date());
        return "Hello RESTFul ok";
    }
}

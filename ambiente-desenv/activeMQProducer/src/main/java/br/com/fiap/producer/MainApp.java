package br.com.fiap.producer;

import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import br.com.fiap.producer.ProducerRouter;


public class MainApp {
	public static void main(String[] args) {
		ProducerRouter routerBuilder = new ProducerRouter();
		CamelContext ctx = new DefaultCamelContext();
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		try {
			ctx.addRoutes(routerBuilder);
			ctx.start();
			Thread.sleep(5*60*1000);
			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

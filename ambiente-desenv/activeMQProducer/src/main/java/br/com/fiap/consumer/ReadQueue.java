package br.com.fiap.consumer;

import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

import br.com.fiap.producer.ProducerRouter;

public class ReadQueue {
	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ConnectionFactory connectionFactory = 
				new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		
		ctx.addComponent("jms", JmsComponent
				.jmsComponentAutoAcknowledge(connectionFactory));
		
		ctx.addRoutes(new RouteBuilder() {
			
			public void configure() {
				from("jms:fiap31scj")
				.to("stream:out")
				.to("file:/home/ibm/Exercicios/outputFolder");
			}

			public void addRoutesToCamelContext(CamelContext arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
		
		ctx.start();
		Thread.sleep(100000);
		ctx.stop();
	}
}

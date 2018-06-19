package br.com.fiap.producer;

import org.apache.camel.builder.RouteBuilder;

public class ProducerRouter extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		from("file:/home/ibm/Exercicios/inputFolder").split()
			.tokenize("n").to("jms:queue:fiap31scj");
	}
}

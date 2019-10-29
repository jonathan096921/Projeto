package br.com.jonathan.projeto.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("rest")
public class JonathanResourceConfig extends ResourceConfig{
	
	public JonathanResourceConfig() {
		
		packages("br.com.jonathan.projeto.servico");
		
	}

}

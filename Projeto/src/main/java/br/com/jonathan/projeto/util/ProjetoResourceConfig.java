package br.com.jonathan.projeto.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;



@ApplicationPath("rest")
public class ProjetoResourceConfig extends ResourceConfig {

	public ProjetoResourceConfig() {
		
	 ResourceConfig config = new ResourceConfig().packages("br.com.jonathan.projeto.service");
	 config.register(ResponseFilter.class);
	 
	 

		
	}
}


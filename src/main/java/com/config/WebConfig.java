package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// Configurar beans al iniciar aplicacion
@Configuration
// Habilitar operacion con MongoDB
@EnableMongoRepositories("com.dao") // indicar donde buscara lose beans

// Arrancar Web Context (root_config, web_config)
public class WebConfig {
	
}
package com.beam.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by x0r on 14/05/16.
 */
@Configuration
@ComponentScan(basePackages = "com.beam.sample.business")
@Import({DbConfig.class})
public class AppConfig {


}

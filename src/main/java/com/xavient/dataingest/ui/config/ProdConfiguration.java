package com.xavient.dataingest.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = { "prod" })
public class ProdConfiguration {

}

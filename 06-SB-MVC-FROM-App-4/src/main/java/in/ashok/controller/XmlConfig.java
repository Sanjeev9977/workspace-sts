package in.ashok.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 

@Configuration
public class XmlConfig {

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }
}


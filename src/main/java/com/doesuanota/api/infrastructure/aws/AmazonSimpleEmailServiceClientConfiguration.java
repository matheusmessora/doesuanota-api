package com.doesuanota.api.infrastructure.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSimpleEmailServiceClientConfiguration {

    @Autowired
    private AWSCredentials awsCredentials;

    @Bean
    public AmazonSimpleEmailServiceClient amazonSimpleEmailService(){
        return new AmazonSimpleEmailServiceClient(awsCredentials);
    }
}

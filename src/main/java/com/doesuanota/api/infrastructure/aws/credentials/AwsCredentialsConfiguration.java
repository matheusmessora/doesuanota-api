package com.doesuanota.api.infrastructure.aws.credentials;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!local")
public class AwsCredentialsConfiguration {

    @Bean
    public AWSCredentials getAWSCredentials() {
        return new EnvironmentVariableCredentialsProvider().getCredentials();
    }
}

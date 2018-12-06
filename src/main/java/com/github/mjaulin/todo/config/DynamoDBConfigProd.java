package com.github.mjaulin.todo.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
@EnableDynamoDBRepositories(basePackages = "com.github.mjaulin.todo")
class DynamoDBConfigProd {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withClientConfiguration(new ClientConfiguration().withConnectionTimeout(1000).withClientExecutionTimeout(10000))
                .build();
    }

}
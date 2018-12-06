package com.github.mjaulin.todo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { App.class })
@TestPropertySource(properties = { "amazon.dynamodb.endpoint=http://localhost:8000/" })
public class CreateTableTest {

    @BeforeClass
    public static void setUp() {
        Assume.assumeTrue(Boolean.valueOf(System.getProperty("createTables", "false")));
    }

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Test
    public void create() {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Task.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
    }
}

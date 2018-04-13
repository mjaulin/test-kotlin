package com.github.mjaulin.springbootkotlin

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import org.junit.Assume
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [Application::class])
@TestPropertySource(properties = ["amazon.dynamodb.endpoint=http://localhost:8000/"])
class CreateTablesTest {

    companion object {
        @BeforeClass @JvmStatic
        fun setUp()  {
            Assume.assumeTrue((System.getProperty("createTables") ?: "false").toBoolean())
        }
    }

    @Autowired
    private val amazonDynamoDB: AmazonDynamoDB? = null

    @Test
    fun create() {
        val dynamoDBMapper = DynamoDBMapper(amazonDynamoDB)
        val tableRequest = dynamoDBMapper.generateCreateTableRequest(Task::class.java)
        tableRequest.provisionedThroughput = ProvisionedThroughput(1L, 1L)
        amazonDynamoDB!!.createTable(tableRequest)
    }
}
package com.github.mjaulin.springbootkotlin

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import org.hibernate.validator.internal.util.Contracts.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [Application::class])
@TestPropertySource(properties = ["amazon.dynamodb.endpoint=http://localhost:8000/"])
class TaskRepositoryTest {

    private var dynamoDBMapper: DynamoDBMapper? = null

    @Autowired
    private val amazonDynamoDB: AmazonDynamoDB? = null

    @Autowired
    private val repository: TaskRepository? = null

    @Before
    @Throws(Exception::class)
    fun setup() {
        dynamoDBMapper = DynamoDBMapper(amazonDynamoDB)
        val tableRequest = dynamoDBMapper!!.generateCreateTableRequest(Task::class.java)
        tableRequest.provisionedThroughput = ProvisionedThroughput(1L, 1L)
        amazonDynamoDB!!.createTable(tableRequest)
    }

    @After
    fun destroy() {
        val tableRequest = dynamoDBMapper!!.generateDeleteTableRequest(Task::class.java)
        amazonDynamoDB!!.deleteTable(tableRequest)
    }

    @Test
    fun sampleTestCase() {
        val task = Task()
        task.label = "test"
        repository!!.save(task)

        val result = repository.findAll().toList()

        assertTrue(result.isNotEmpty(),"Not empty")
        assertTrue(result[0].label == "test", "Contains item with expected cost")
    }
}
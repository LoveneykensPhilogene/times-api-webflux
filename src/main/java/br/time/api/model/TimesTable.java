package br.time.api.model;

import java.util.Arrays;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import static br.time.api.constant.TimesConstant.ENDPOINT_DYNAMO;
import static br.time.api.constant.TimesConstant.REGION_DYNAMO;

@Configuration
@EnableDynamoDBRepositories
public class TimesTable {
	public static void main(String []args) {
		
		AmazonDynamoDBClient.builder();
		AmazonDynamoDB client=AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
				.build();
		
		DynamoDB dynamoDB=new DynamoDB(client);
		
		String tableName="Times_Table";
		try {
			Table table= dynamoDB.createTable(tableName,
					Arrays.asList(
					new KeySchemaElement("id",KeyType.HASH)),
					Arrays.asList(
					new AttributeDefinition("id",ScalarAttributeType.S)),
					new ProvisionedThroughput(5L,5L));
			table.waitForActive();
		}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}


}

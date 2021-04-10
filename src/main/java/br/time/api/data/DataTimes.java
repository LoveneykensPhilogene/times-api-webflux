package br.time.api.data;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import  static br.time.api.constant.TimesConstant.ENDPOINT_DYNAMO;
import  static br.time.api.constant.TimesConstant.REGION_DYNAMO;

public class DataTimes {
	
	public static void main(String[]args) {
		AmazonDynamoDB client=AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder
				.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
				.build();
		
		DynamoDB dynamoDB=new DynamoDB(client);
		
		Table table=dynamoDB.getTable("Times_Table");
		
		Item time1 =new Item()
		.withPrimaryKey("id","1")
		.withString("name", "Brasil")
		.withString("titulo", "5 Estrelas");
		
		
		Item time2=new Item()
				.withPrimaryKey("id","2")
				.withString("nome", "haiti")
				.withString("titulo","Nao tem");
				
		
		
		
		PutItemOutcome ducomeHeroe1=table.putItem(time1);
		PutItemOutcome ducomeHeroe2=table.putItem(time2);
		
	}


}

package br.time.api.model;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName="Times_Table")
public class Times {
	
	@org.springframework.data.annotation.Id
	@DynamoDBHashKey(attributeName="id")
	private String id;
	
	@DynamoDBAttribute(attributeName="nome")
	private String nome;
	
	@DynamoDBAttribute(attributeName="titulo")
	private String titulo;
	
	public Times(String id,String nome,String titulo) {
		this.id=id;
		this.nome=nome;
		this.titulo=titulo;
		}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}

<header>
<h1>API AWS WEBFLUX</h1>
</header>
<header> 
<ul>
<header><p>Stack utilizada</p></header>
<li>Java11</li>
<li>spring webflux</li>
<li>Spring data</li>
<li>junit</li>
<li>sl4j</li>
<li>reactor</li>
</ul>
</header>

<header>
<h1>Para executar dynamo<h1>
<p>
<h4>
na pasta em que o jar está baixado: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb.
</h4>
</p>
<p>
<h4>
para listar as tabelas criadas: aws dynamodb list-tables --endpoint-url http://localhost:8000
</h4>
</p>

</header>
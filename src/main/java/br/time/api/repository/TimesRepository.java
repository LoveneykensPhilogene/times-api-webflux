package br.time.api.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.time.api.model.Times;
import br.time.api.model.TimesTable;

@EnableScan
public interface TimesRepository extends CrudRepository<Times,String> {
	
	

}

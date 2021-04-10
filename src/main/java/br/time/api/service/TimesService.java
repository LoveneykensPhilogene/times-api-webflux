package br.time.api.service;

import org.springframework.stereotype.Service;

import br.time.api.model.Times;
import br.time.api.repository.TimesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TimesService {
	
	public final TimesRepository timesRepository;
	
	public TimesService(TimesRepository TimesRepository) {
		this.timesRepository=TimesRepository;
	}
	
	public Flux<Times> findAllTimes(){
		return Flux.fromIterable(this.timesRepository.findAll()); 
		
	}
	
	public Mono<Times> findTimesById(String id){
		return Mono.justOrEmpty(this.timesRepository.findById(id));
		
	}
	public Mono<Times>saveTimes(Times time){
		return Mono.justOrEmpty(this.timesRepository.save(time));
	}
	
	public Mono<Boolean> deleteTimeById(String id){
		timesRepository.deleteById(id);
		return Mono.justOrEmpty(true);
	}
	

}

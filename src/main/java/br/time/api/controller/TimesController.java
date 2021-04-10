package br.time.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.time.api.model.Times;
import br.time.api.repository.TimesRepository;
import br.time.api.service.TimesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static br.time.api.constant.TimesConstant.TIMES_ENDPOINT_LOCAL;

@RestController
@RequestMapping(TIMES_ENDPOINT_LOCAL)
public class TimesController {
	
	
 TimesRepository timesRepository; 
	
	
	 TimesService timesService;
	
	private static final Logger log=LoggerFactory.getLogger(TimesController.class);
	
	public TimesController(TimesRepository timesRepository,TimesService timesService) {
		this.timesRepository=timesRepository;
		this.timesService=timesService;
	}
	
	@GetMapping()
	public Flux<Times> getAllItems(){
		log.info("Solicitando a lista de todos os times ");
		return timesService.findAllTimes();
	}
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Times>> findById(@PathVariable String id){
		log.info("Solicitando um time com o id{}",id);
		return  timesService.findTimesById(id)
				.map((item)->new ResponseEntity<>(item,HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public Mono<Times> createHeroes(@RequestBody Times heroes){
		log.info("A new hero was created");
		return timesService.saveTimes(heroes);
  }
	
	@DeleteMapping("/id")
	@ResponseStatus(code=HttpStatus.CONTINUE)
	public Mono<HttpStatus>deleteByIdHeroes(@PathVariable String id){
	       timesService.deleteTimeById(id);
	       log.info("deletando o time com id {}",id);
	       
	   	 return Mono.justOrEmpty(HttpStatus.CONTINUE);
	    	
	}
	
}

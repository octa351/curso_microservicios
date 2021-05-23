package com.octavio.microservices.beerservice.repository;

import com.octavio.microservices.beerservice.model.Beer;
import org.springframework.data.repository.CrudRepository;


public interface BeerRepository extends CrudRepository<Beer, Long> {
}

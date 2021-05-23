package com.octavio.microservices.beerservice.service;

import com.octavio.microservices.beerservice.model.Beer;
import com.octavio.microservices.beerservice.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService {
    private BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> getBeers(){
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beers::add);
        return beers;
    }
}

package com.octavio.microservices.beerservice.controller;

import com.octavio.microservices.beerservice.model.Beer;
import com.octavio.microservices.beerservice.service.BeerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/microservices")
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/beers")
    public ResponseEntity<List<Beer>> getBeers(){
        return ResponseEntity.ok(beerService.getBeers());
    }

}

package com.octavio.microservices.apigateway.controller;

import com.octavio.microservices.apigateway.beerApi.BeerResponse;
import com.octavio.microservices.apigateway.service.BeerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiGateway")
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/beers")
    public ResponseEntity<List<BeerResponse>> getBeers(){
        return ResponseEntity.ok(beerService.getBeers());
    }
}

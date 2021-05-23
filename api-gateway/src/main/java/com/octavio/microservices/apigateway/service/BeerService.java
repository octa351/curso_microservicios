package com.octavio.microservices.apigateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.octavio.microservices.apigateway.beerApi.BeerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BeerService {

    private RestTemplate restTemplate;

    private String beerApiUrl = "/beers";



    @HystrixCommand(fallbackMethod = "fallBackMethod")
    public List<BeerResponse> getBeers(){
        System.out.println("CIRCUITO CERRADO");

        restTemplate = new RestTemplate();

        ResponseEntity<List<BeerResponse>> beerResponse =
                restTemplate.exchange("http://localhost:8080/v1/microservices/beers",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<BeerResponse>>() {
                        });
        return beerResponse.getBody();

    }

    public List<BeerResponse> fallBackMethod(){
        System.out.println("SE APLICO CIRCUIT BREAKER, PASO POR EL METODO DE FALLA!! CIRCUITO ABIERTO!");
        return null;
    }
}

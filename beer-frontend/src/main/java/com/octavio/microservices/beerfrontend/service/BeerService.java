package com.octavio.microservices.beerfrontend.service;

import com.octavio.microservices.beerfrontend.model.BeerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BeerService {
    private RestTemplate restTemplate;


    public List<BeerResponse> getBeers(){

        restTemplate = new RestTemplate();

        ResponseEntity<List<BeerResponse>> beerResponse =
                restTemplate.exchange("http://localhost:8081/apiGateway/beers",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return beerResponse.getBody();

    }
}

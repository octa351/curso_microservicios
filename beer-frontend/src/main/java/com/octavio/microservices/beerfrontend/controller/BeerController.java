package com.octavio.microservices.beerfrontend.controller;

import com.octavio.microservices.beerfrontend.service.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beers")
public class BeerController {

    public BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("fallback", "Service available");
        if(beerService.getBeers() != null) {
            model.addAttribute("beers", beerService.getBeers());
        }
        else{
            model.addAttribute("fallback", "Service unavailable");
        }
        return "allBeers";
    }
}

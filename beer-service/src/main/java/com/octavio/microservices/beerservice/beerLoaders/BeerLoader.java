package com.octavio.microservices.beerservice.beerLoaders;

import com.octavio.microservices.beerservice.model.Beer;
import com.octavio.microservices.beerservice.repository.BeerRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BeerLoader  implements ApplicationListener<ContextRefreshedEvent> {

    private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        beerRepository.saveAll(getBeers());
    }

    private List<Beer> getBeers(){
        Beer beer1 = Beer.builder()
                .name("Wolf IPA")
                .price(150D)
                .build();

        Beer beer2 = Beer.builder()
                .name("Golden Ale")
                .price(100D)
                .build();

        Beer beer3 = Beer.builder()
                .name("Caramel IPA")
                .price(120D)
                .build();

        Beer beer4 = Beer.builder()
                .name("Black Stout")
                .price(200D)
                .build();

        List<Beer> list = new ArrayList<>();
        Collections.addAll(list, beer1,beer2,beer3,beer4);
        return list;
    }
}

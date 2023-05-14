package spring.microservice.msscbrewery.Service;

import spring.microservice.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto  saveNewBeer(BeerDto beerDto);
}


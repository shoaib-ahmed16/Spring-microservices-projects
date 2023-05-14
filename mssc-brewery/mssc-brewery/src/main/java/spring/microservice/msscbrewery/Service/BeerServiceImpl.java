package spring.microservice.msscbrewery.Service;

import org.springframework.stereotype.Service;
import spring.microservice.msscbrewery.web.model.BeerDto;

import java.util.UUID;

@Service
public class BeerServiceImpl  implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }
}

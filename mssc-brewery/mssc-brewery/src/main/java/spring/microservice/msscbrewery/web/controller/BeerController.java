package spring.microservice.msscbrewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.microservice.msscbrewery.Service.BeerService;
import spring.microservice.msscbrewery.web.model.BeerDto;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

//    @Autowired
//    private BeerService beerService;
    private final BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService = beerService;
    }
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(BeerDto beerDto)
    {
        BeerDto savaedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer"+savaedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
}

package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.model.BeerDto;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
        return  new ResponseEntity<>(BeerDto.builder().beerName("Shamian").id(UUID.randomUUID()).beerStyle(BeerStyleEnum.LAGER).lastUpdatedDate(OffsetDateTime.now()).createdDate(OffsetDateTime.now()).quantityOnHand(90).price(10000).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewbeer(@RequestBody BeerDto beerDto){
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/beerId")
    public ResponseEntity updateBeerId(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

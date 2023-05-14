package com.beer.microservice.beerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import web.controller.BeerController;
import web.model.BeerDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.util.UUID;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewbeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().beerName("Shamian").id(UUID.randomUUID()).beerStyle(BeerStyleEnum.LAGER).lastUpdatedDate(OffsetDateTime.now()).createdDate(OffsetDateTime.now()).quantityOnHand(90).price(10000).build();
        String beerDtoJson =objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerId() throws Exception {
        BeerDto beerDto = BeerDto.builder().beerName("Shamian").id(UUID.randomUUID()).beerStyle(BeerStyleEnum.ALE).lastUpdatedDate(OffsetDateTime.now()).createdDate(OffsetDateTime.now()).quantityOnHand(90).price(10000).build();
        String beerDtoJson =objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer/"+UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson)).andExpect(status().isNoContent());
    }
}
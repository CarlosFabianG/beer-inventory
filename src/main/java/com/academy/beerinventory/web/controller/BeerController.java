package com.academy.beerinventory.web.controller;

import com.academy.beerinventory.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/")
    public ResponseEntity <List<BeerDto>> getBeers(){
        List<BeerDto> beers = new ArrayList<>();
        beers.add(new BeerDto("Pacifico", "lager"));
        beers.add(new BeerDto("Minerva", "stout"));
        beers.add(new BeerDto("Victoria", "viena"));

        return new ResponseEntity<>(beers, HttpStatus.OK);
    }
}

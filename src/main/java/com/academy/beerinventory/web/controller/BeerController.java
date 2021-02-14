package com.academy.beerinventory.web.controller;

import com.academy.beerinventory.web.model.BeerDto;
import com.academy.beerinventory.web.service.IBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
    private IBeerService beerService;

    @GetMapping("/")
    public ResponseEntity <List<BeerDto>> getBeers(){
        List<BeerDto> beersFromService = beerService.findAll();
        List<BeerDto> beers = new ArrayList<>();
        beers.add(new BeerDto((long)1, "Pacifico", "lager", (long)2, (long)1, "MX"));
        beers.add(new BeerDto((long)2, "Minerva", "stout", (long)3, (long)1, "MX"));
        beers.add(new BeerDto((long)3, "Victoria", "Viena", (long)6, (long)2, "MX"));

        return new ResponseEntity<>(beers, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BeerDto> addBeer(@RequestBody BeerDto beer) {
        BeerDto beerCreated = beerService.addBeer(beer);
        return new ResponseEntity<>(beerCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeerDto> updateBeer(@PathVariable long id, @RequestBody BeerDto beer) {
        BeerDto beerUpdated = beerService.updateBeer(id, beer);
        return new ResponseEntity<>(beerUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBeer(@PathVariable long id) {
        beerService.deleteBeer(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

}

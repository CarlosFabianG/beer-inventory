package com.academy.beerinventory.web.controller;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.model.BeerDto;
import com.academy.beerinventory.web.service.IBeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private IBeerService beerService;

    public BeerController(IBeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/")
    public ResponseEntity <List<Beer>> getBeers(){
        List<Beer> beersFromService = beerService.findAll();
        List<Beer> beers = new ArrayList<>();
        beers.add(new Beer(1L, "Pacifico", "lager", 2L, 1L, "MX"));
        beers.add(new Beer(2L, "Minerva", "stout", 3L, 1L, "MX"));
        beers.add(new Beer(3L, "Victoria", "Viena", 6L, 2L, "MX"));
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<BeerDto> getBeer(Long id){
        Beer beer = beerService.findById(id);

        //Todo create mappings BeerDtoToBeer and BeerToBeerDto
        BeerDto beerDto = new BeerDto();

        return new ResponseEntity<>(beerDto, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<BeerDto> getBeer(Long id){
        Beer beer = beerService.findById(id);
        // Todo create mappings BeerDtoToBeer and BeerToBeerDto
        BeerDto beerDto = new BeerDto();
        return new ResponseEntity<>(beerDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Beer> addBeer(@RequestBody Beer beer) {
        Beer beerCreated = beerService.addBeer(beer);
        return new ResponseEntity<>(beerCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beer> updateBeer(@PathVariable long id, @RequestBody Beer beer) {
        Beer beerUpdated = beerService.updateBeer(id, beer);
        return new ResponseEntity<>(beerUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBeer(@PathVariable long id) {
        beerService.deleteBeer(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

}

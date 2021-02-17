package com.academy.beerinventory.web.service;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.mappers.BeerMapping;
import com.academy.beerinventory.web.model.BeerDto;
import com.academy.beerinventory.web.repository.IBeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceImpl implements IBeerService{

    private final IBeerRepository beerRepository;

    public BeerServiceImpl(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public List<BeerDto> findAll() {
        List<Beer> allBeers = beerRepository.findAll();
        List<BeerDto> allBeersDto = (List<BeerDto>) allBeers.stream().map(beer -> BeerMapping.BeerToBeerDto(beer));
        return allBeersDto;
    }

    public BeerDto findById(Long id){
        Optional<Beer> beer = beerRepository.findById(id);
        beer.orElseThrow(()->new RuntimeException("Id not found"));
        BeerDto beerDto = BeerMapping.BeerToBeerDto(beer.orElse(null));
        return beerDto;
    }

    @Override
    public BeerDto addBeer(Beer beer) {
        Beer beerSaved = beerRepository.save(beer);
        return BeerMapping.BeerToBeerDto(beerSaved);
    }

    @Override
    public BeerDto updateBeer(long id, Beer beer) {
        beer.setId(id);
        Beer beerSaved = beerRepository.save(beer);
        BeerDto beerUpdated = BeerMapping.BeerToBeerDto(beerSaved);
        return beerUpdated;
    }

    @Override
    public void deleteBeer(long id) {
        beerRepository.deleteById(id);
    }

}
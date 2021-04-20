package com.academy.beerinventory.web.service;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.mappers.BeerMapping;
import com.academy.beerinventory.web.model.BeerDto;
import com.academy.beerinventory.web.repository.IBeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeerServiceImpl implements IBeerService{

    private final IBeerRepository beerRepository;

    public BeerServiceImpl(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public List<BeerDto> findAll() {
        List<Beer> allBeers = beerRepository.findAll();
        List<BeerDto> allBeersDto = allBeers.stream().map(beer -> BeerMapping.BeerToBeerDto(beer)).collect(Collectors.toList());
        return allBeersDto;
    }

    public BeerDto findById(Long id){
        Optional<Beer> beer = beerRepository.findById(id);
        Beer beerResponse = beer.orElseThrow(()->new RuntimeException("Id not found"));
        BeerDto beerDto = BeerMapping.BeerToBeerDto(beerResponse);
        return beerDto;
    }

    @Override
    public BeerDto addBeer(BeerDto beer) {
        Beer beerBeer = BeerMapping.BeerDtoToBeer(beer);
        Beer beerSaved = beerRepository.save(beerBeer);
        return BeerMapping.BeerToBeerDto(beerSaved);
    }

    @Override
    public BeerDto updateBeer(long id, BeerDto beer) {
        beer.setId(id);
        Beer beerFromBeerDto = BeerMapping.BeerDtoToBeer(beer);
        Beer beerSaved = beerRepository.save(beerFromBeerDto);
        BeerDto beerUpdated = BeerMapping.BeerToBeerDto(beerSaved);
        return beerUpdated;
    }

    @Override
    public void deleteBeer(long id) {
        beerRepository.deleteById(id);
    }

}
package com.academy.beerinventory.web.service;

import com.academy.beerinventory.domain.Beer;
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
    public List<Beer> findAll() {
        return (List<Beer>) beerRepository.findAll();
    }

    @Override
    public Beer addBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Beer updateBeer(long id, Beer beer) {
        beer.setId(id);
        return beerRepository.save(beer);
        /*return beerRepository.findById(id).map(currentBeer -> {
            currentBeer.setId(beer.getId());
            currentBeer.setName(beer.getName());
            currentBeer.setType(beer.getType());
            currentBeer.setCountry(beer.getCountry());
            currentBeer.setQuantity(beer.getQuantity());
            currentBeer.setMinQuantity(beer.getMinQuantity());
            return beerRepository.save(currentBeer);
        }).orElseGet(() -> {
            return beerRepository.save(beer);
        });*/

    }

    @Override
    public void deleteBeer(long id) {
        beerRepository.deleteById(id);
    }

    @Override
    public Beer findById(long id) {
        Optional<Beer> beer = beerRepository.findById(id);
        beer.orElseThrow(()-> new RuntimeException("ID Not found"));
        return beer.orElse(null);
    }

}

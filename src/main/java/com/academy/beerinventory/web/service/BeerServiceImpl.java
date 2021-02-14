package com.academy.beerinventory.web.service;

import com.academy.beerinventory.web.model.BeerDto;
import com.academy.beerinventory.web.repository.IBeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerServiceImpl implements  IBeerService{

    @Autowired
    private IBeerRepository beerRepository;
    @Override
    public List<BeerDto> findAll() {
        return (List<BeerDto>) beerRepository.findAll();
    }

    @Override
    public BeerDto addBeer(BeerDto beer) {
        return beerRepository.save(beer);
    }

    @Override
    public BeerDto updateBeer(long id, BeerDto beer) {
        return beerRepository.findById(id).map(currentBeer -> {
            currentBeer.setId(beer.getId());
            currentBeer.setName(beer.getName());
            currentBeer.setType(beer.getType());
            currentBeer.setCountry(beer.getCountry());
            currentBeer.setQuantity(beer.getQuantity());
            currentBeer.setMinQuantity(beer.getMinQuantity());
            return beerRepository.save(currentBeer);
        }).orElseGet(() -> {
            return beerRepository.save(beer);
        });
    }

    @Override
    public void deleteBeer(long id) {
        beerRepository.deleteById(id);
    }
}

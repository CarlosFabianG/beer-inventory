package com.academy.beerinventory.web.service;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.model.BeerDto;

import java.util.List;

public interface IBeerService {

    public List<BeerDto> findAll();

    public BeerDto findById(Long id);

    public BeerDto addBeer(BeerDto beer);

    public BeerDto updateBeer(long id, BeerDto beer);

    public void deleteBeer(long id);
}
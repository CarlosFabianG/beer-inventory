package com.academy.beerinventory.web.service;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.model.BeerDto;

import java.util.List;

public interface IBeerService {

    public List<Beer> findAll();

    public Beer addBeer(Beer beer);

    public Beer updateBeer(long id, Beer beer);

    public void deleteBeer(long id);

    public Beer findById(long id);

}

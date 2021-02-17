package com.academy.beerinventory.web.service;

import com.academy.beerinventory.domain.Beer;

import java.util.List;

public interface IBeerService {

    public List<Beer> findAll();

    public Beer findById(Long id);

    public Beer addBeer(Beer beer);

    public Beer updateBeer(long id, Beer beer);

    public void deleteBeer(long id);
}
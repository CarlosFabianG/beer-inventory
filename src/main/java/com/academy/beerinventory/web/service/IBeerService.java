package com.academy.beerinventory.web.service;

import com.academy.beerinventory.web.model.BeerDto;

import java.util.List;

public interface IBeerService {

    public List<BeerDto> findAll();
}

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
}

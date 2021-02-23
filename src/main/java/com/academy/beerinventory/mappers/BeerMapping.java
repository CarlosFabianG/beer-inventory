package com.academy.beerinventory.mappers;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.model.BeerDto;

public class BeerMapping {

    public static Beer BeerDtoToBeer(BeerDto beerDto){
        Beer beer = new Beer();
        beer.setId(beerDto.getId());
        beer.setName(beerDto.getName());
        beer.setQuantity(beerDto.getQuantity());
        beer.setCountry(beerDto.getCountry());
        beer.setType(beerDto.getType());
        beer.setMinQuantity(beerDto.getMinQuantity());
        return beer;
    }

    public static BeerDto BeerToBeerDto(Beer beer){
        BeerDto beerDto = new BeerDto();
        beerDto.setId(beer.getId());
        beerDto.setName(beer.getName());
        beerDto.setQuantity(beer.getQuantity());
        beerDto.setCountry(beer.getCountry());
        beerDto.setType(beer.getType());
        beerDto.setMinQuantity(beer.getMinQuantity());
        return beerDto;
    }
}

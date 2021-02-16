package com.academy.beerinventory.mappers;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.model.BeerDto;

public class BeerMapping {

    public static Beer BeerDtoToBeer(BeerDto beerDto){
        Beer beer = new Beer();

        return beer;
    }

    public static BeerDto BeerToBeerDto(Beer beer){
        BeerDto beerDto = new BeerDto();

        return beerDto;
    }
}

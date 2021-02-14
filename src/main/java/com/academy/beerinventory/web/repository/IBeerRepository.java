package com.academy.beerinventory.web.repository;

import com.academy.beerinventory.web.model.BeerDto;
import org.springframework.data.repository.CrudRepository;

public interface IBeerRepository extends CrudRepository<BeerDto, Long> {

}

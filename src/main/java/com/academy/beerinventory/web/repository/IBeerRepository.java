package com.academy.beerinventory.web.repository;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.model.BeerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface IBeerRepository extends JpaRepository<Beer, Long> {

}

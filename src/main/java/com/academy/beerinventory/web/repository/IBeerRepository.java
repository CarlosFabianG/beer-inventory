package com.academy.beerinventory.web.repository;

import com.academy.beerinventory.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeerRepository extends JpaRepository<Beer, Long> {

}

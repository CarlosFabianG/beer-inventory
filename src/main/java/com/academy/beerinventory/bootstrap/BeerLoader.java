package com.academy.beerinventory.bootstrap;

import com.academy.beerinventory.domain.Beer;
import com.academy.beerinventory.web.repository.IBeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
command line runner is used to run beans using the CommandeLineRunner interface

CommandLineRunner is an interface used to indicate that a bean should run when it is
contained within a SpringApplication https://zetcode.com/springboot/commandlinerunner/

It creates cities in a H2 in-memory database and later lists them.
Examples
https://github.com/OmarMorales71/spring5-recipe-app-1/blob/master/src/main/java/guru/springframework/bootstrap/RecipeBootstrap.java
https://github.com/OmarMorales71/mssc-beer-service/blob/master/src/main/java/omar/springframework/msscbeerservice/bootstrap/BeerLoader.java


 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final IBeerRepository beerRepository;

    public BeerLoader(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeers();
    }

    private  void loadBeers() {
        if( beerRepository.count() == 0 ) {
            beerRepository.save(new Beer(1L, "Pacifico", "lager", 2L, 1L, "MX"));
            beerRepository.save(new Beer(2L, "Minerva", "stout", 3L, 1L, "MX"));
            beerRepository.save(new Beer(3L, "Victoria", "Viena", 6L, 2L, "MX"));
        }
        System.out.println("Loaded Beers: "+ beerRepository.count());
    }
}

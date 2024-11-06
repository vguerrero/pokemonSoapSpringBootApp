package com.vmgs.tech.pokemonapp.webservice;

import com.vmgs.tech.pokemonapp.business.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class TestController {
    @Autowired
    PokemonService pokemonService;

    public TestController() {
        System.out.println("init TestController...");
    }

    @GetMapping
    public String control() {
        var data = pokemonService.getPokemonData(0,5);
        System.out.println(data);
        System.out.println(data.getTotalElements());
        return data.getContent().toString();
    }
}

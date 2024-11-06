package com.vmgs.tech.pokemonapp;

import com.vmgs.tech.pokemonapp.webservice.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
		"com.vmgs.tech.pokemonapp",
		"com.vmgs.tech.pokemonapp.presentation",

}, scanBasePackageClasses = TestController.class)
public class PokemonAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(PokemonAppApplication.class, args);

	}

}

package com.vmgs.tech.pokemonapp.business;

import com.mysoapws.soap.gen.Pokemonsoap;
import com.vmgs.tech.pokemonapp.dataaccess.model.Pokemon;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PokemonService {
    Page<Pokemon> getPokemonData(int offset, int limit);

    List<Pokemonsoap> mapToPokemonSoap(List<Pokemon> pokemonList);
}

package com.vmgs.tech.pokemonapp.dataaccess;

import com.vmgs.tech.pokemonapp.dataaccess.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestRequester {

    Page<Pokemon> getPokemonData(Pageable pageable);
}

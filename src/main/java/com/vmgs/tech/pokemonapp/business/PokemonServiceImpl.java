package com.vmgs.tech.pokemonapp.business;

import com.mysoapws.soap.gen.Pokemonsoap;
import com.vmgs.tech.pokemonapp.dataaccess.RestRequester;
import com.vmgs.tech.pokemonapp.dataaccess.model.Pokemon;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{

    private RestRequester restRequester;

    private ModelMapper modelMapper;

    public PokemonServiceImpl(RestRequester restRequester, ModelMapper modelMapper) {
        this.restRequester = restRequester;
        this.modelMapper= modelMapper;
    }

    public Page<Pokemon> getPokemonData(int offset, int limit){
        Pageable pageable = PageRequest.of(offset, limit);
        var page = restRequester.getPokemonData(pageable);
        return page;
    }

    public List<Pokemonsoap> mapToPokemonSoap(List<Pokemon> pokemonList){
        return modelMapper.map(pokemonList, new TypeToken<List<Pokemonsoap>>(){}.getType());
    }
}

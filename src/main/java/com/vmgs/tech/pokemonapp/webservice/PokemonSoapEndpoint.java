package com.vmgs.tech.pokemonapp.webservice;

import com.mysoapws.soap.gen.PokemonServiceRequest;
import com.mysoapws.soap.gen.PokemonServiceResponse;
import com.mysoapws.soap.gen.Pokemonsoap;
import com.vmgs.tech.pokemonapp.business.PokemonService;
import com.vmgs.tech.pokemonapp.dataaccess.model.Pokemon;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PokemonSoapEndpoint {
    private static final String NAMESPACE_URI = "http://www.mysoapws.com/soap/gen";
    PokemonService pokemonService;


    public PokemonSoapEndpoint(PokemonService pokemonService, ModelMapper modelMapper) {
        this.pokemonService = pokemonService;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pokemonServiceRequest")
    @ResponsePayload
    public PokemonServiceResponse getCountry(@RequestPayload PokemonServiceRequest request) {
        PokemonServiceResponse response = new PokemonServiceResponse();
        Page<Pokemon> pokemonPage = pokemonService.getPokemonData(request.getOffset(),request.getLimit());
        List<Pokemonsoap> pokemonsoapList =pokemonService.mapToPokemonSoap(pokemonPage.getContent());
        response.getPokemon().addAll(pokemonsoapList);
        return response;
    }


}

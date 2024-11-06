package com.vmgs.tech.pokemonapp.dataaccess;

import com.vmgs.tech.pokemonapp.dataaccess.model.Pokemon;
import com.vmgs.tech.pokemonapp.dataaccess.model.PokemonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestRequesterImpl implements RestRequester{

    @Value("${spring.rest.app.url}")
    private String url;

    private final RestTemplate restTemplate;

    public RestRequesterImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Page<Pokemon> getPokemonData(Pageable pageable)  {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("offset", pageable.getPageNumber())
                .queryParam("limit", pageable.getPageSize());

        ResponseEntity<PokemonData> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET, null, new ParameterizedTypeReference<PokemonData>() {
                });
        Page<Pokemon> page = new PageImpl<>(responseEntity.getBody().getResults());
        return page;

    }
}

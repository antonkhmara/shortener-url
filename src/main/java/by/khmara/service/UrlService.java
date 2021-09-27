package by.khmara.service;

import by.khmara.entity.Redirect;
import by.khmara.repository.UrlRepository;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Bean
public class UrlService {
    @Inject
    private UrlRepository urlRepository;

    public Map<String, String> urlMapping() {
        List<Redirect> redirects = urlRepository.findAll();

        return redirects.stream().collect(Collectors.toMap(e -> e.getAlias(), e-> e.getUrl()));
    }
}

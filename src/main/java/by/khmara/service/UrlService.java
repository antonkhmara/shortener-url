package by.khmara.service;

import by.khmara.entity.Redirect;
import by.khmara.repository.UrlRepository;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Bean
public class UrlService {
    @Inject
    private UrlRepository urlRepository;

    public Optional<Redirect> getUrl(String alias) {
        return urlRepository.findByAlias(alias);
    }
}

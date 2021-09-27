package by.khmara.controller;

import by.khmara.entity.Redirect;
import by.khmara.service.UrlService;
import io.micronaut.http.*;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;

@Controller
public class RedirectController {

    @Inject
    private UrlService urlService;

    @Get("/{alias}")
    public HttpResponse<?> redirect(@PathVariable String alias, HttpHeaders headers) throws URISyntaxException {
        Optional<Redirect> redirect = urlService.getUrl(alias);

        if (redirect.isPresent()) {
            return HttpResponse.redirect(new URI(redirect.get().getUrl()));
        }

        return HttpResponse.notFound();
    }
}

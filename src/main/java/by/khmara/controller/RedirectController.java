package by.khmara.controller;

import by.khmara.service.UrlService;
import io.micronaut.http.*;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Controller
public class RedirectController {

    @Inject
    private UrlService urlService;

    @Get("/{alias}")
    public HttpResponse<?> redirect(@PathVariable String alias, HttpHeaders headers) throws URISyntaxException {
        Map<String, String> urlMap = urlService.urlMapping();
        URI uri = new URI("");

        if (urlMap.containsKey(alias)) {
            uri = new URI(urlMap.get(alias));
            return HttpResponse.redirect(uri);
        }

        return HttpResponse.notFound();
    }
}

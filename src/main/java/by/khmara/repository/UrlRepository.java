package by.khmara.repository;

import by.khmara.entity.Redirect;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface UrlRepository extends CrudRepository<Redirect, String> {

    List<Redirect> findAll();
}

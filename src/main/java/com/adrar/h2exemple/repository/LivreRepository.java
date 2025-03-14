package com.adrar.h2exemple.repository;

import com.adrar.h2exemple.model.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
    boolean findByTitreAndDescription(String titre, String description);
}

package com.adrar.h2exemple.controller;

import com.adrar.h2exemple.exception.LivreNotFoundException;
import com.adrar.h2exemple.exception.NoLivreFoundException;
import com.adrar.h2exemple.model.Livre;
import com.adrar.h2exemple.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // Méthode qui retourne tous les objets Livre
    @GetMapping("/livres")
    public Iterable<Livre> getAllLivres() {
        if(livreService.countLivre() == 0) {
            throw new NoLivreFoundException();
        }
        return livreService.getAll();
    }

    @GetMapping("/livre/{id}")
    public Livre getLivreById(@PathVariable Integer id) {
        return livreService.getById(id).orElseThrow(
                ()-> new LivreNotFoundException(id)
        );
    }

    // Méthode qui ajoute un Livre
    @PostMapping("/livre")
    @ResponseStatus(HttpStatus.CREATED)
    public Livre saveLivre(@RequestBody Livre livre) {
        return livreService.add(livre);
    }

    // Méthode qui supprime un Livre par son id
    @DeleteMapping("/livre/{id}")
    public String deleteLivreById(@PathVariable Integer id) {
        if(livreService.remove(id)) {
            return "Livre supprimé avec succes";
        }
        return "Livre introuvable";
    }

    // Méthode qui met à jour un Livre
    @PutMapping("/livre/{id}")
    public Livre updateLivreById(@PathVariable Integer id, @RequestBody Livre livre) {
        return livreService.update(livre, id);
    }
}

package com.adrar.h2exemple.service;

import com.adrar.h2exemple.model.Livre;
import com.adrar.h2exemple.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    //Méthode qui retourne tous les objets Livre
    public Iterable<Livre> getAll(){
        return livreRepository.findAll();
    }

    public Long countLivre() {
        return livreRepository.count();
    }

    //Méthode qui retourne un Livre par son id
    public Optional<Livre> getById(int id){
        return livreRepository.findById(id);
    }
    //Méthode qui ajoute un Livre
    public Livre add(Livre livre){
        return livreRepository.save(livre);
    }

    //Méthode qui supprime un Livre par son id
    public boolean remove(int id) {
        if(!livreRepository.existsById(id)) {
            return false;
        }
        livreRepository.deleteById(id);
        return true;
    }

    //Méthode qui met à jour un Livre
    public Livre update(Livre livre, int id){
        if(!livreRepository.existsById(id)) {
            livre.setTitre("Livre introuvable");
            return livre;
        }
        livre.setId(id);
        return livreRepository.save(livre);
    }
}

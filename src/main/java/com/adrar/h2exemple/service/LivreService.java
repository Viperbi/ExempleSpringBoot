package com.adrar.h2exemple.service;

import com.adrar.h2exemple.dto.LivreDto;
import com.adrar.h2exemple.exception.SaveLivreExistException;
import com.adrar.h2exemple.exception.UpdateLivreNotFoundException;
import com.adrar.h2exemple.model.Livre;
import com.adrar.h2exemple.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private LivreDtoWrapper livreDtoWrapper;

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
        if(livreRepository.findByTitreAndDescription(livre.getTitre(), livre.getDescription())) {
            throw  new SaveLivreExistException(livre);
        }
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
            throw new UpdateLivreNotFoundException(id);
        }
        livre.setId(id);
        return livreRepository.save(livre);
    }

    public List<LivreDto> getAllLivresDto() {
        List<LivreDto> listDto = new ArrayList<>();
        for(Livre livre : getAll()){
            listDto.add(livreDtoWrapper.toDto(livre));
        }
        return listDto;
    }

    public Optional<LivreDto> getLivreDtoById(int id) {
        Livre livre = getById(id).orElseThrow(
                ()-> new UpdateLivreNotFoundException(id)
        );
        LivreDtoWrapper livreDtoWrapper = new LivreDtoWrapper();
        return Optional.of(livreDtoWrapper.toDto(livre));
    }
}

package com.adrar.h2exemple.service;

import com.adrar.h2exemple.dto.LivreDto;
import com.adrar.h2exemple.model.Livre;
import org.springframework.stereotype.Service;

@Service
public class LivreDtoWrapper {

    public LivreDto toDto(Livre livre) {
        return new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getDatePublication(),
                livre.getMaisonEdition()
        );
    }
}

package com.adrar.h2exemple.dto;

import java.util.Date;

public record LivreDto(
        Integer id,
        String titre,
        String auteur,
        Date datePublication,
        String maisonEdition
) {

}

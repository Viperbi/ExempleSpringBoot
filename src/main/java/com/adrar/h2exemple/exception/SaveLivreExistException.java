package com.adrar.h2exemple.exception;

import java.util.Date;

public class SaveLivreExistException extends RuntimeException {
    public SaveLivreExistException(String titre, String description, Date datePublication) {
        super(
                "Le livre avec ces informations existe déjà."
        );
    }
}

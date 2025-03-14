package com.adrar.h2exemple.exception;

import com.adrar.h2exemple.model.Livre;

import java.util.Date;

public class SaveLivreExistException extends RuntimeException {
    public SaveLivreExistException(Livre livre) {
        super("Le livre : " + livre.getTitre() + ", " + livre.getDescription() + " existe déjà");
    }
}

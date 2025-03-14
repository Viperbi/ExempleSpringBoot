package com.adrar.h2exemple.exception;

public class UpdateLivreNotFoundException extends RuntimeException {
    public UpdateLivreNotFoundException(Integer id) {
        super(
                "Le livre avec id : " + id + " n'existe pas."
        );
    }
}

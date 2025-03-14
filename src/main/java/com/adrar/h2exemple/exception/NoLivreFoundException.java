package com.adrar.h2exemple.exception;

public class NoLivreFoundException extends RuntimeException {
    public NoLivreFoundException() {
        super("Aucun livre dans la base de données");
    }
}

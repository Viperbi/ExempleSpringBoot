package com.adrar.h2exemple.controller;

import com.adrar.h2exemple.exception.LivreNotFoundException;
import com.adrar.h2exemple.exception.NoLivreFoundException;
import com.adrar.h2exemple.exception.SaveLivreExistException;
import com.adrar.h2exemple.exception.UpdateLivreNotFoundException;
import com.adrar.h2exemple.model.Livre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LivreExceptionController {

    @ExceptionHandler(LivreNotFoundException.class)
    public ResponseEntity<Map<String, String>> livreNotFound(LivreNotFoundException livreNotFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", livreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoLivreFoundException.class)
    public ResponseEntity<Map<String,String>> noLivres(NoLivreFoundException noLivreFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", noLivreFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(UpdateLivreNotFoundException.class)
    public ResponseEntity<Map<String, String>> updateLivreNotFound(UpdateLivreNotFoundException updateLivreNotFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", updateLivreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(SaveLivreExistException.class)
    public ResponseEntity<Map<String, String>> saveLivreExist(SaveLivreExistException saveLivreExist) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", saveLivreExist.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

}


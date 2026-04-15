package com.loki.TVA.exception;

public class CharacterNotFoundException extends RuntimeException{
    public CharacterNotFoundException(Long id){
        super("Character not found by id "+ id);
    }
}

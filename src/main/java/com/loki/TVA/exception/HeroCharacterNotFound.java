package com.loki.TVA.exception;

public class HeroCharacterNotFound extends RuntimeException{
    public HeroCharacterNotFound(Long id){
        super("Hero Character Not Found by id "+ id);
    }
}

package com.loki.TVA.exception;

public class VariantNotFoundException extends RuntimeException{
    public VariantNotFoundException(Long id){
        super("variant not found by id "+ id);
    }
}

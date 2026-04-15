package com.loki.TVA.controller;

import com.loki.TVA.dto.VariantRequestDTO;
import com.loki.TVA.dto.VariantResponseDTO;
import com.loki.TVA.service.VariantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tva")
public class VariantController {

    @Autowired
    private VariantService service;

//    get all data
    @GetMapping("/variant")
      public ResponseEntity<List<VariantResponseDTO>> getAllVariant(){
          List<VariantResponseDTO> variant = service.getAllVariant();
          return ResponseEntity.ok(variant);
      }

//      get by id
    @GetMapping("/variant/{id}")
    public ResponseEntity<VariantResponseDTO> getVariantById(@PathVariable Long id){
        VariantResponseDTO variant = service.getVariantById(id);
        return ResponseEntity.ok(variant);
    }

//    create variants
    @PostMapping("/variant")
    public ResponseEntity<VariantResponseDTO> createVariant(@Valid @RequestBody VariantRequestDTO request){
                VariantResponseDTO variant = service.createVariant(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(variant);

    }

//    update variants by id
    @PatchMapping("/variant/{id}")
    public ResponseEntity<VariantResponseDTO> updateVariantById(@PathVariable Long id, @Valid @RequestBody VariantRequestDTO request){
        VariantResponseDTO variant = service.updateVariantById(id,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(variant);
    }

//    delete variant by id
    @DeleteMapping("/variant/{id}")
    public ResponseEntity<Void> deleteVariantById(@PathVariable Long id){
        service.deleteVariantById(id);
        return ResponseEntity.noContent().build();
    }
}

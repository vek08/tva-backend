package com.loki.TVA.service;

import com.loki.TVA.dto.VariantRequestDTO;
import com.loki.TVA.dto.VariantResponseDTO;
import com.loki.TVA.exception.VariantNotFoundException;
import com.loki.TVA.model.Variant;
import com.loki.TVA.repo.VariantRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    private VariantRepo vRepo;

    //    get all variant
    @Override
    public List<VariantResponseDTO> getAllVariant() {
        List<Variant> entity = vRepo.findAll();

        List<VariantResponseDTO> list = new ArrayList<>();
        for (Variant db : entity) {
            list.add(VariantResponseDTO.builder()
                    .id(db.getId())
                    .name(db.getName())
                    .timelineId(db.getTimelineId())
                    .threatLevel(db.getThreatLevel())
                    .status(db.getStatus())
                    .build()

            );

        }
        return list;
    }

    @Override
    public VariantResponseDTO getVariantById(Long id) {
        Variant entity = vRepo.findById(id).orElseThrow(() -> new VariantNotFoundException(id));

        return VariantResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .timelineId(entity.getTimelineId())
                .threatLevel(entity.getThreatLevel())
                .status(entity.getStatus())
                .build();
    }

    //    create variant
    @Override
    public VariantResponseDTO createVariant(VariantRequestDTO request) {
        Variant entity = Variant.builder()
                .name(request.getName())
                .timelineId(request.getTimelineId())
                .threatLevel(request.getThreatLevel())
                .status(request.getStatus())
                .build();

        Variant saved = vRepo.save(entity);

        return VariantResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .timelineId(saved.getTimelineId())
                .threatLevel(saved.getThreatLevel())
                .status(saved.getStatus())
                .build();
    }

    //    update variant by id
    @Override
    public VariantResponseDTO updateVariantById(Long id, VariantRequestDTO request) {
        Variant entity = vRepo.findById(id).orElseThrow(() -> new VariantNotFoundException(id));
        entity.setName(request.getName());
        entity.setThreatLevel(request.getThreatLevel());
        entity.setStatus(request.getStatus());
        entity.setTimelineId(request.getTimelineId());

        Variant updateSaved = vRepo.save(entity);

        return VariantResponseDTO.builder()
                .id(updateSaved.getId())
                .name(updateSaved.getName())
                .threatLevel(updateSaved.getThreatLevel())
                .timelineId(updateSaved.getTimelineId())
                .status(updateSaved.getStatus())
                .build();
    }

//    delete the variant
    @Override
    public void deleteVariantById(Long id) {
        Variant entity = vRepo.findById(id).orElseThrow(() -> new VariantNotFoundException(id));
        vRepo.delete(entity);
    }

}

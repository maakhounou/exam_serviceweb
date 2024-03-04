package com.groupe.isi.service.impl;

import com.groupe.isi.repository.EtudiantRepository;
import com.groupe.isi.service.EtudiantService;
import com.groupe.isi.service.dto.EtudiantDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<EtudiantDTO> findAll() {
        return etudiantRepository
            .findAll()
            .stream()
            .map(e -> new EtudiantDTO(e.getId(), e.getName(), e.getLastname(), e.getEmail(), e.getPhone()))
            .collect(Collectors.toList());
    }
}

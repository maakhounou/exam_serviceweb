package com.groupe.isi.service;

import com.groupe.isi.service.dto.EtudiantDTO;

import java.util.List;

public interface EtudiantService {
    public List<EtudiantDTO> findAll();
}

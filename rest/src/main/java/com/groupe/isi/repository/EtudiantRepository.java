package com.groupe.isi.repository;

import com.groupe.isi.domain.Etudiant;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findById(long id);
}

package com.sistema.softwares_service.repository;

import com.sistema.softwares_service.model.Software;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<Software, Long> {
    boolean existsByNome(String nome);
    List<Software> findByDisponivelTrue();
}

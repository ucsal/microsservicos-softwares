package com.sistema.softwares_service.service;

import com.sistema.softwares_service.dto.SoftwareRequestDTO;
import com.sistema.softwares_service.model.Software;
import com.sistema.softwares_service.repository.SoftwareRepository;
import com.sistema.softwares_service.validation.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SoftwareService {

    private final SoftwareRepository softwareRepository;

    public SoftwareService(SoftwareRepository softwareRepository) {
        this.softwareRepository = softwareRepository;
    }

    @Transactional
    public Software create(SoftwareRequestDTO dto) {
        if (softwareRepository.existsByNome(dto.getNome())) {
            throw new IllegalArgumentException("Software já existe com esse nome");
        }
        Software software = Software.builder()
                .nome(dto.getNome())
                .linkInstalacao(dto.getLinkInstalacao())
                .versao(dto.getVersao())
                .isSoftwareLivre(dto.getIsSoftwareLivre())
                .dataSolicitacao(LocalDate.now())
                .disponivel(true)
                .build();

        return softwareRepository.save(software);
    }

    public List<Software> getAll() {
        return softwareRepository.findAll();
    }

    public Software getById(Long id) {
        return softwareRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Software não encontrado com id: " + id));
    }

    @Transactional
    public Software update(Long id, SoftwareRequestDTO dto) {
        Software software = getById(id);
        software.setNome(dto.getNome());
        software.setLinkInstalacao(dto.getLinkInstalacao());
        software.setVersao(dto.getVersao());
        software.setIsSoftwareLivre(dto.getIsSoftwareLivre());
        return softwareRepository.save(software);
    }

    @Transactional
    public void delete(Long id) {
        if (!softwareRepository.existsById(id)) {
            throw new ResourceNotFoundException("Software não encontrado com id: " + id);
        }
        softwareRepository.deleteById(id);
    }

    public List<Software> getAvailable() {
        return softwareRepository.findByDisponivelTrue();
    }

    @Transactional
    public Software markAsUnavailable(Long id) {
        Software software = getById(id);
        software.setDisponivel(false);
        return softwareRepository.save(software);
    }
}

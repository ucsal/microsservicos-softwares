package com.sistema.softwares_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SoftwareResponseDTO {
    private Long id;
    private String nome;
    private String linkInstalacao;
    private String versao;
    private Boolean isSoftwareLivre;
    private LocalDate dataSolicitacao;
    private Boolean disponivel;
}

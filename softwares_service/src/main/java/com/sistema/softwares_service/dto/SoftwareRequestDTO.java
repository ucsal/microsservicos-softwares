package com.sistema.softwares_service.dto;
import lombok.Data;

@Data
public class SoftwareRequestDTO {
    private String nome;
    private String linkInstalacao;
    private String versao;
    private Boolean isSoftwareLivre;
}
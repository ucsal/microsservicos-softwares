package com.sistema.softwares_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "softwares")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do software é obrigatório.")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O link de instalação é obrigatório.")
    @Column(nullable = false)
    private String linkInstalacao;

    @NotBlank(message = "A versão é obrigatória.")
    @Column(nullable = false)
    private String versao;

    @NotNull(message = "A informação se o software é livre é obrigatória.")
    @Column(nullable = false)
    private Boolean isSoftwareLivre;

    @NotNull(message = "A data de solicitação é obrigatória.")
    @Column(nullable = false)
    private LocalDate dataSolicitacao;

    @Column(nullable = false)
    private Boolean disponivel = true; // true por padrão
}


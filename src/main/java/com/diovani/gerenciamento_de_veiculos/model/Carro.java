package com.diovani.gerenciamento_de_veiculos.model;

import com.diovani.gerenciamento_de_veiculos.enums.CombustivelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "MODELO_ID", referencedColumnName = "ID", nullable = false)
    private Modelo modelo;

    @Column(nullable = false)
    private Integer ano;

    @Enumerated(EnumType.STRING)
    private CombustivelEnum combustivel;

    private Integer numeroPortas;

    @Column(nullable = false)
    private String cor;

    private String urlImagem;

    public Carro(LocalDateTime dataCadastro, Modelo modelo, Integer ano, CombustivelEnum combustivel, Integer numeroPortas, String cor, String urlImagem) {
        this.dataCadastro = dataCadastro;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.numeroPortas = numeroPortas;
        this.cor = cor;
        this.urlImagem = urlImagem;
    }
}

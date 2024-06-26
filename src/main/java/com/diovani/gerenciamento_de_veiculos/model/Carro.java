package com.diovani.gerenciamento_de_veiculos.model;

import com.diovani.gerenciamento_de_veiculos.enums.CombustivelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

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
    private Timestamp timestampCadastro;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "MODELO_ID", referencedColumnName = "ID", nullable = false)
    private Modelo modelo;

    @Column(nullable = false)
    private Integer ano;

    @Enumerated(EnumType.STRING)
    private CombustivelEnum combustivel;

    private String numeroPortas;

    @Column(nullable = false)
    private String cor;

    private String urlImagem;

    public Carro(Timestamp timestampCadastro, Modelo modelo, Integer ano, CombustivelEnum combustivel, String numeroPortas, String cor, String urlImagem) {
        this.timestampCadastro = timestampCadastro;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.numeroPortas = numeroPortas;
        this.cor = cor;
        this.urlImagem = urlImagem;
    }
}

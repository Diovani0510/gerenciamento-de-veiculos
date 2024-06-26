package com.diovani.gerenciamento_de_veiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MODELO")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "MARCA_ID", referencedColumnName = "ID", nullable = false)
    private Marca marca;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valorFipe;

}

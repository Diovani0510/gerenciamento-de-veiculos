package com.diovani.gerenciamento_de_veiculos.dto.marca;

import jakarta.validation.constraints.NotBlank;

public record PostMarcaDTO(
        @NotBlank(message = "Nome da marca é obrigatório.") String nome,
        String urlImagem) {
}

package com.diovani.gerenciamento_de_veiculos.dto.marca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record PostMarcaDTO(
        @NotBlank(message = "Nome da marca é obrigatório.") String nome,
        @NotEmpty(message = "A URL da imagem informada não deve ser vazia.") String urlImagem) {
}

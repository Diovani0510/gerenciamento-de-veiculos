package com.diovani.gerenciamento_de_veiculos.service.marca;

import com.diovani.gerenciamento_de_veiculos.dto.marca.PostMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.model.Marca;
import org.springframework.stereotype.Service;

@Service
public class MarcaBuilderService {

    public Marca postMarcaDtoToMarca(PostMarcaDTO dto) {
        return Marca.builder()
                .nome(dto.nome())
                .urlImagem(dto.urlImagem())
                .build();
    }
}

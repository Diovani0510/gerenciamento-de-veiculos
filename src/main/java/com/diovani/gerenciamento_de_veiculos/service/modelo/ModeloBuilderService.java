package com.diovani.gerenciamento_de_veiculos.service.modelo;

import com.diovani.gerenciamento_de_veiculos.dto.modelo.PostModeloDTO;
import com.diovani.gerenciamento_de_veiculos.model.Marca;
import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import com.diovani.gerenciamento_de_veiculos.service.marca.MarcaService;
import org.springframework.stereotype.Service;

@Service
public class ModeloBuilderService {

    private final MarcaService marcaService;

    public ModeloBuilderService(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    public Modelo postModeloDtoToModelo(PostModeloDTO dto) {
        Marca marca = this.marcaService.buscarPorId(dto.marcaId());

        return Modelo.builder()
                .nome(dto.nome())
                .marca(marca)
                .valorFipe(dto.valorFipe())
                .build();
    }
}

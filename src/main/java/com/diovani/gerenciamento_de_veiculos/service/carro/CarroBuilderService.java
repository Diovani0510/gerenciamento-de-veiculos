package com.diovani.gerenciamento_de_veiculos.service.carro;

import com.diovani.gerenciamento_de_veiculos.dto.carro.PostCarroDTO;
import com.diovani.gerenciamento_de_veiculos.model.Carro;
import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import com.diovani.gerenciamento_de_veiculos.service.modelo.ModeloService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarroBuilderService {

    private final ModeloService modeloService;

    public CarroBuilderService(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    public Carro postCarroDtoToCarro(PostCarroDTO dto) {
        Modelo modelo = this.modeloService.buscarPorId(dto.modeloId());

        return Carro.builder()
                .dataCadastro(LocalDateTime.now())
                .modelo(modelo)
                .ano(dto.ano())
                .combustivel(dto.combustivel())
                .ano(dto.ano())
                .numeroPortas(dto.numeroPortas())
                .cor(dto.cor())
                .urlImagem(dto.urlImagem())
                .build();
    }
}

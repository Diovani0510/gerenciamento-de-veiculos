package com.diovani.gerenciamento_de_veiculos.service.carro;

import com.diovani.gerenciamento_de_veiculos.dto.carro.PutCarroDTO;
import com.diovani.gerenciamento_de_veiculos.exception.EntidadeNãoEncontradaException;
import com.diovani.gerenciamento_de_veiculos.exception.InternalServerErrorException;
import com.diovani.gerenciamento_de_veiculos.model.Carro;
import com.diovani.gerenciamento_de_veiculos.repository.CarroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public Carro salvar(Carro carro) {
        try {
            return this.repository.save(carro);
        } catch (Exception e) {
            log.error("Falha ao tentar salvar carro.", e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Carro buscarPorId(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntidadeNãoEncontradaException("Carro não encontrado."));
    }

    public Carro editar(Long id, PutCarroDTO dto) {
        Carro carro = this.buscarPorId(id);

        if (dto.combustivel() != null) {
            carro.setCombustivel(dto.combustivel());
        }

        if (!dto.urlImagem().isBlank()) {
            carro.setCor(dto.cor());
        }

        if (!dto.urlImagem().isBlank()) {
            carro.setUrlImagem(dto.urlImagem());
        }

        return this.salvar(carro);
    }

    public Page<Carro> listar(Integer numeroPagina, Integer quantidadeItens) {
        try {
            return this.repository.findAll(PageRequest.of(numeroPagina, quantidadeItens));
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de carros.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Page<Carro> listarPorModeloId(Long modeloId, Integer numeroPagina, Integer quantidadeItens) {
        try {
            return this.repository.findAllByModeloId(modeloId, PageRequest.of(numeroPagina, quantidadeItens));
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de carros.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Page<Carro> listarPorMarcaId(Long marcaId, Integer numeroPagina, Integer quantidadeItens) {
        try {
            return this.repository.findAllByModeloMarcaId(marcaId, PageRequest.of(numeroPagina, quantidadeItens));
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de carros.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Long deletarPorId(Long id) {
        try {
            this.repository.deleteById(id);
            return id;
        } catch (Exception e) {
            log.error("Falha ao tentar deletar carro. Id: " + id.toString(), e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}

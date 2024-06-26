package com.diovani.gerenciamento_de_veiculos.service.marca;

import com.diovani.gerenciamento_de_veiculos.dto.ResumoDTO;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PutMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.exception.EntidadeNaoEncontradaException;
import com.diovani.gerenciamento_de_veiculos.exception.InternalServerErrorException;
import com.diovani.gerenciamento_de_veiculos.model.Marca;
import com.diovani.gerenciamento_de_veiculos.repository.MarcaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MarcaService {
    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public Marca salvar(Marca marca) {
        try {
            return this.repository.save(marca);
        } catch (Exception e) {
            log.error("Falha ao tentar salvar marca.", e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Marca buscarPorId(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Marca não encontrada."));
    }

    public Marca editar(Long id, PutMarcaDTO dto) {
        Marca marca = this.buscarPorId(id);

        if (!dto.nome().isBlank()) {
            marca.setNome(dto.nome());
        }

        if (!dto.urlImagem().isBlank()) {
            marca.setUrlImagem(dto.urlImagem());
        }

        return this.salvar(marca);
    }

    public Page<Marca> listar(Integer numeroPagina, Integer quantidadeItens) {
        try {
            return this.repository.findAll(PageRequest.of(numeroPagina, quantidadeItens));
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de marcas.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public List<ResumoDTO> listarResumo() {
        try {
            List<Marca> marcasResumidas = this.repository.findAll();
            return marcasResumidas.stream().map(marca -> new ResumoDTO(marca.getId(), marca.getNome())).toList();
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de marcas.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Long deletarPorId(Long id) {
        try {
            this.repository.deleteById(id);
            return id;
        } catch (Exception e) {
            log.error("Falha ao tentar deletar marca. Id: " + id.toString(), e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}

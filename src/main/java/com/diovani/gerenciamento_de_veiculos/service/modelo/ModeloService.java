package com.diovani.gerenciamento_de_veiculos.service.modelo;

import com.diovani.gerenciamento_de_veiculos.dto.ResumoDTO;
import com.diovani.gerenciamento_de_veiculos.dto.modelo.PutModeloDTO;
import com.diovani.gerenciamento_de_veiculos.exception.EntidadeNaoEncontradaException;
import com.diovani.gerenciamento_de_veiculos.exception.InternalServerErrorException;
import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import com.diovani.gerenciamento_de_veiculos.repository.ModeloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ModeloService {
    private final ModeloRepository repository;

    public ModeloService(ModeloRepository repository) {
        this.repository = repository;
    }

    public Modelo salvar(Modelo modelo) {
        try {
            return this.repository.save(modelo);
        } catch (Exception e) {
            log.error("Falha ao tentar salvar modelo.", e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Modelo buscarPorId(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Modelo não encontrado."));
    }

    public Modelo editar(Long id, PutModeloDTO dto) {
        Modelo modelo = this.buscarPorId(id);

        if (dto.valorFipe() != null) {
            modelo.setValorFipe(dto.valorFipe());
        }

        if (!dto.nome().isBlank()) {
            modelo.setNome(dto.nome());
        }

        return this.salvar(modelo);
    }

    public Page<Modelo> listar(Integer numeroPagina, Integer quantidadeItens) {
        try {
            return this.repository.findAll(PageRequest.of(numeroPagina, quantidadeItens));
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de modelos.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Page<Modelo> listarPorMarcaId(Long marcaId, Integer numeroPagina, Integer quantidadeItens) {
        try {
            return this.repository.findAllByMarcaId(marcaId, PageRequest.of(numeroPagina, quantidadeItens));
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de modelos.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public List<ResumoDTO> listarResumoPorMarcaId(Long marcaId) {
        try {
            List<Modelo> modelosResumidos = this.repository.findAllByMarcaId(marcaId);
            return modelosResumidos.stream().map(modelo -> new ResumoDTO(modelo.getId(), modelo.getNome())).toList();
        } catch (Exception e) {
            log.error("Falha ao buscar a lista de modelos.", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public Long deletarPorId(Long id) {
        try {
            this.repository.deleteById(id);
            return id;
        } catch (Exception e) {
            log.error("Falha ao tentar deletar modelo. Id: " + id.toString(), e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}

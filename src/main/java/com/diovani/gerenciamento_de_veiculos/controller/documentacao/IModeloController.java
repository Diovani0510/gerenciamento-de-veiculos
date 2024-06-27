package com.diovani.gerenciamento_de_veiculos.controller.documentacao;


import com.diovani.gerenciamento_de_veiculos.dto.ResumoDTO;
import com.diovani.gerenciamento_de_veiculos.dto.modelo.PostModeloDTO;
import com.diovani.gerenciamento_de_veiculos.dto.modelo.PutModeloDTO;
import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Controller de Modelos", description = "Gerenciamento de Modelos")
public interface IModeloController {
    @Operation(summary = "Criar Modelo", description = "Cria um novo Modelo.")
    ResponseEntity<Modelo> salvar(@Valid @RequestBody PostModeloDTO modeloDTO);

    @Operation(summary = "Buscar Modelo por id", description = "Busca um Modelo por seu Id.")
    ResponseEntity<Modelo> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Editar Modelo", description = "Edita um Modelo após buscar ele por seu Id.")
    ResponseEntity<Modelo> editar(@PathVariable Long id, @Valid @RequestBody PutModeloDTO modeloDTO);

    @Operation(summary = "Buscar lista de Modelos", description = "Busca uma lista paginada de Modelos.")
    ResponseEntity<Page<Modelo>> listar(@RequestParam(defaultValue = "0") final Integer numeroPagina,
                                       @RequestParam(defaultValue = "5") final Integer quantidadeItens);

    @Operation(summary = "Buscar lista de Modelos Por Marca", description = "Busca uma lista paginada de Modelos por Marca.")
    ResponseEntity<Page<Modelo>> listarPorMarca(@PathVariable Long marcaId,
                                        @RequestParam(defaultValue = "0") final Integer numeroPagina,
                                        @RequestParam(defaultValue = "5") final Integer quantidadeItens);


    @Operation(summary = "Buscar lista resumida de Modelos", description = "Busca uma lista resumida de Modelos por Marca.")
    ResponseEntity<List<ResumoDTO>>  listarResumo(@PathVariable Long marcaId);


    @Operation(summary = "Deletar Modelo", description = "Deleta um Modelo por seu Id.")
    ResponseEntity<Long> deletarPorId(@PathVariable Long id);
}

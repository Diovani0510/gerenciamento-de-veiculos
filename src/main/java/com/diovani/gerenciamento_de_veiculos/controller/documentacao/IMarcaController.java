package com.diovani.gerenciamento_de_veiculos.controller.documentacao;


import com.diovani.gerenciamento_de_veiculos.dto.ResumoDTO;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PostMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PutMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.model.Marca;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Controller de Marcas", description = "Gerenciamento de Marcas")
public interface IMarcaController {
    @Operation(summary = "Criar Marca", description = "Cria uma nova Marca.")
    ResponseEntity<Marca> salvar(@Valid @RequestBody PostMarcaDTO marcaDTO);

    @Operation(summary = "Buscar Marca por id", description = "Busca uma Marca por seu Id.")
    ResponseEntity<Marca> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Editar Marca", description = "Edita uma Marca após buscar ela por seu Id.")
    ResponseEntity<Marca> editar(@PathVariable Long id, @RequestBody PutMarcaDTO marcaDTO);

    @Operation(summary = "Buscar lista de Marcas", description = "Busca uma lista paginada de Marcas.")
    ResponseEntity<Page<Marca>> listar(@RequestParam(defaultValue = "0") final Integer numeroPagina,
                                       @RequestParam(defaultValue = "5") final Integer quantidadeItens);

    @Operation(summary = "Buscar lista resumida de Marcas", description = "Busca uma lista resumida de Marcas.")
    ResponseEntity<List<ResumoDTO>>  listarResumo();

    @Operation(summary = "Deletar Marca", description = "Deleta uma Marca por seu Id.")
    ResponseEntity<Long> deletarPorId(@PathVariable Long id);
}

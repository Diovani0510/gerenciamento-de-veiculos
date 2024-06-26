package com.diovani.gerenciamento_de_veiculos.controller.documentacao;


import com.diovani.gerenciamento_de_veiculos.dto.carro.PostCarroDTO;
import com.diovani.gerenciamento_de_veiculos.dto.carro.PutCarroDTO;
import com.diovani.gerenciamento_de_veiculos.model.Carro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Controller de Carros", description = "Gerenciamento de Carros")
public interface ICarroController {
    @Operation(summary = "Criar Carro", description = "Cria um novo Carro.")
    ResponseEntity<Carro> salvar(@Valid @RequestBody PostCarroDTO carroDTO);

    @Operation(summary = "Buscar Carro por id", description = "Busca um Carro por seu Id.")
    ResponseEntity<Carro> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Editar Carro", description = "Edita um Carro após buscar ele por seu Id.")
    ResponseEntity<Carro> editar(@PathVariable Long id, @Valid @RequestBody PutCarroDTO carroDTO);

    @Operation(summary = "Buscar lista de Carros", description = "Busca uma lista paginada de Carros.")
    ResponseEntity<Page<Carro>> listar(@RequestParam(defaultValue = "0") final Integer numeroPagina,
                                       @RequestParam(defaultValue = "5") final Integer quantidadeItens);

    @Operation(summary = "Buscar lista de Carros Por Modelo", description = "Busca uma lista paginada de Carros por Modelo.")
    ResponseEntity<Page<Carro>> listarPorModelo(@PathVariable Long modeloId,
                                        @RequestParam(defaultValue = "0") final Integer numeroPagina,
                                        @RequestParam(defaultValue = "5") final Integer quantidadeItens);

    @Operation(summary = "Buscar lista de Carros Por Marca", description = "Busca uma lista paginada de Carros por Marca.")
    ResponseEntity<Page<Carro>> listarPorMarca(@PathVariable Long marcaId,
                                                @RequestParam(defaultValue = "0") final Integer numeroPagina,
                                                @RequestParam(defaultValue = "5") final Integer quantidadeItens);

    @Operation(summary = "Deletar Carro", description = "Deleta um Carro por seu Id.")
    ResponseEntity<Long> deletarPorId(@PathVariable Long id);
}

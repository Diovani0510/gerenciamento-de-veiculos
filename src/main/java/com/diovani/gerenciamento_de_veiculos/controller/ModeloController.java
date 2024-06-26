package com.diovani.gerenciamento_de_veiculos.controller;

import com.diovani.gerenciamento_de_veiculos.controller.documentacao.IModeloController;
import com.diovani.gerenciamento_de_veiculos.dto.modelo.PostModeloDTO;
import com.diovani.gerenciamento_de_veiculos.dto.modelo.PutModeloDTO;
import com.diovani.gerenciamento_de_veiculos.model.Modelo;
import com.diovani.gerenciamento_de_veiculos.service.modelo.ModeloBuilderService;
import com.diovani.gerenciamento_de_veiculos.service.modelo.ModeloService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelos")
public class ModeloController implements IModeloController {

    private final ModeloBuilderService builderService;
    private final ModeloService service;

    public ModeloController(ModeloBuilderService builderService, ModeloService service) {
        this.builderService = builderService;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Modelo> salvar(@Valid @RequestBody PostModeloDTO modeloDTO) {
        Modelo modelo = this.builderService.postModeloDtoToModelo(modeloDTO);
        return ResponseEntity.ok(this.service.salvar(modelo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> editar(@PathVariable Long id, @Valid @RequestBody PutModeloDTO modeloDTO) {
        return ResponseEntity.ok(this.service.editar(id, modeloDTO));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Modelo>> listar(@RequestParam Integer numeroPagina, @RequestParam Integer quantidadeItens) {
        return ResponseEntity.ok(this.service.listar(numeroPagina, quantidadeItens));
    }

    @GetMapping("/listar/marca/{marcaId}")
    public ResponseEntity<Page<Modelo>> listarPorMarca(@PathVariable Long marcaId,
                                                @RequestParam(defaultValue = "0") final Integer numeroPagina,
                                                @RequestParam(defaultValue = "5") final Integer quantidadeItens) {
        return ResponseEntity.ok(this.service.listarPorMarcaId(marcaId, numeroPagina, quantidadeItens));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.deletarPorId(id));
    }
}

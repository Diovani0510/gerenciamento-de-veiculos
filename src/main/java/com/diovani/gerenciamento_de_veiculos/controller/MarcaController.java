package com.diovani.gerenciamento_de_veiculos.controller;

import com.diovani.gerenciamento_de_veiculos.controller.documentacao.IMarcaController;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PostMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PutMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.model.Marca;
import com.diovani.gerenciamento_de_veiculos.service.marca.MarcaBoulderService;
import com.diovani.gerenciamento_de_veiculos.service.marca.MarcaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
public class MarcaController implements IMarcaController {

    private final MarcaBoulderService builderService;
    private final MarcaService service;

    public MarcaController(MarcaBoulderService builderService, MarcaService service) {
        this.builderService = builderService;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Marca> salvar(@Valid @RequestBody PostMarcaDTO marcaDTO) {
        Marca marca = this.builderService.postMarcaDtoToMarca(marcaDTO);
        return ResponseEntity.ok(this.service.salvar(marca));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> editar(@PathVariable Long id, @Valid @RequestBody PutMarcaDTO marcaDTO) {
        return ResponseEntity.ok(this.service.editar(id, marcaDTO));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Marca>> listar(@RequestParam Integer numeroPagina, @RequestParam Integer quantidadeItens) {
        return ResponseEntity.ok(this.service.listar(numeroPagina, quantidadeItens));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.deletarPorId(id));
    }
}

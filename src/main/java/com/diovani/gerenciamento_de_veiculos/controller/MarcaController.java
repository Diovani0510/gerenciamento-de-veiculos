package com.diovani.gerenciamento_de_veiculos.controller;

import com.diovani.gerenciamento_de_veiculos.controller.documentacao.IMarcaController;
import com.diovani.gerenciamento_de_veiculos.dto.ResumoDTO;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PostMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.dto.marca.PutMarcaDTO;
import com.diovani.gerenciamento_de_veiculos.model.Marca;
import com.diovani.gerenciamento_de_veiculos.service.marca.MarcaBuilderService;
import com.diovani.gerenciamento_de_veiculos.service.marca.MarcaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController implements IMarcaController {

    private final MarcaBuilderService builderService;
    private final MarcaService service;

    public MarcaController(MarcaBuilderService builderService, MarcaService service) {
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

    @GetMapping("/listar/resumo")
    public  ResponseEntity<List<ResumoDTO>> listarResumo() {
        return ResponseEntity.ok(this.service.listarResumo());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.deletarPorId(id));
    }
}

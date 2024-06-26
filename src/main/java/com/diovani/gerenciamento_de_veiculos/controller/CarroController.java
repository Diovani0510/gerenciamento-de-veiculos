package com.diovani.gerenciamento_de_veiculos.controller;

import com.diovani.gerenciamento_de_veiculos.controller.documentacao.ICarroController;
import com.diovani.gerenciamento_de_veiculos.dto.carro.PostCarroDTO;
import com.diovani.gerenciamento_de_veiculos.dto.carro.PutCarroDTO;
import com.diovani.gerenciamento_de_veiculos.model.Carro;
import com.diovani.gerenciamento_de_veiculos.service.carro.CarroBuilderService;
import com.diovani.gerenciamento_de_veiculos.service.carro.CarroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController implements ICarroController {

    private final CarroBuilderService builderService;
    private final CarroService service;

    public CarroController(CarroBuilderService builderService, CarroService service) {
        this.builderService = builderService;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Carro> salvar(@Valid @RequestBody PostCarroDTO carroDTO) {
        Carro carro = this.builderService.postCarroDtoToCarro(carroDTO);
        return ResponseEntity.ok(this.service.salvar(carro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> editar(@PathVariable Long id, @Valid @RequestBody PutCarroDTO carroDTO) {
        return ResponseEntity.ok(this.service.editar(id, carroDTO));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Carro>> listar(@RequestParam Integer numeroPagina, @RequestParam Integer quantidadeItens) {
        return ResponseEntity.ok(this.service.listar(numeroPagina, quantidadeItens));
    }

    @GetMapping("/listar/modelo/{modeloId}")
    public ResponseEntity<Page<Carro>> listarPorModelo(@PathVariable Long modeloId,
                                                      @RequestParam(defaultValue = "0") final Integer numeroPagina,
                                                      @RequestParam(defaultValue = "5") final Integer quantidadeItens) {
        return ResponseEntity.ok(this.service.listarPorMarcaId(modeloId, numeroPagina, quantidadeItens));
    }

    @GetMapping("/listar/marca/{marcaId}")
    public ResponseEntity<Page<Carro>> listarPorMarca(@PathVariable Long marcaId,
                                                       @RequestParam(defaultValue = "0") final Integer numeroPagina,
                                                       @RequestParam(defaultValue = "5") final Integer quantidadeItens) {
        return ResponseEntity.ok(this.service.listarPorMarcaId(marcaId, numeroPagina, quantidadeItens));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.deletarPorId(id));
    }
}

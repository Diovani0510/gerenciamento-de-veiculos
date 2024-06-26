package com.diovani.gerenciamento_de_veiculos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Assumption Controller", description = "Trip assumptions")
@RestController
@RequestMapping("/carros")
public class CarroController {

    @Operation(summary = "Create new assumption", description = "Create a new assumption with name and estimated time.")
    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }
}

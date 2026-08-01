package com.jerry.empresa.controller;

import com.jerry.empresa.entity.Cliente;
import com.jerry.empresa.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService=clienteService;
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }
    @GetMapping("/{id")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }
}

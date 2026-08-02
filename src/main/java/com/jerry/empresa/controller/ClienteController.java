package com.jerry.empresa.controller;

import com.jerry.empresa.entity.Cliente;
import com.jerry.empresa.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> createClientesById(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.createCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente>updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.updateCliente(id, cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}

package com.jerry.empresa.controller;

import com.jerry.empresa.entity.Cliente;
import com.jerry.empresa.service.ClienteService;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService=clienteService;
    }
    @GetMapping
    public List<Cliente> getClienteById(){
        return clienteService.getClienteById();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        return clienteService.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Cliente> createClientesById(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.createCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente>updateCliente(@PathVariable Long id,  @RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.updateCliente(id, cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}

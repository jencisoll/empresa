package com.jerry.empresa.service;

import com.jerry.empresa.entity.Cliente;
import com.jerry.empresa.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
    }
    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Cliente updateCliente(Long id, Cliente clienteDetails){
        Cliente cliente = getClienteById(id);
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setEmail(clienteDetails.getEmail());
        return clienteRepository.save(cliente);
    }
    public void deleteCliente(Long id){
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }
}
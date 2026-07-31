package com.jerry.empresa.service;

import com.jerry.empresa.entity.Cliente;
import com.jerry.empresa.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

public List<Cliente> getAllClientes(){
    return clienteRepository.findAll();
}
}
public Cliente getClienteById(Long id){
    return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado: "+id));
}

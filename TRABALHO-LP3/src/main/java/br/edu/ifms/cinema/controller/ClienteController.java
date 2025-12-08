/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.ClienteDAO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.mapper.clienteMap;
import br.edu.ifms.cinema.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor ferreira
 */
public class ClienteController {
   private GenericDAO <Cliente> clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public ClienteResponseDTO create(ClienteRequestDTO dto) {
        ClienteResponseDTO response = new ClienteResponseDTO();
        if (dto == null || dto.getId() != 0) { 
            response.setStatus(false);
            response.setMessage("Dados inválidos para criação do cliente.");
            return response;
        }

        Cliente cliente = clienteMap.toCliente(dto);
        boolean success = clienteDAO.add(cliente);

        response = clienteMap.fromCliente(cliente);

        if (success) {
            response.setStatus(true);
            response.setMessage("Cliente cadastrado com sucesso!");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao cadastrar o cliente.");
        }
        return response;
    }

    public ClienteResponseDTO update(Long id, ClienteRequestDTO dto) {
        ClienteResponseDTO response = new ClienteResponseDTO();
        if (dto == null || id == null) {
            response.setStatus(false);
            response.setMessage("Dados inválidos para atualização do cliente.");
            return response;
        }

        Cliente existingCliente = clienteDAO.getById(id);
        if (existingCliente == null) {
            response.setStatus(false);
            response.setMessage("Cliente não encontrado.");
            return response;
        }

        Cliente cliente = clienteMap.toCliente(dto);
        cliente.setId(id);

        boolean success = clienteDAO.update(cliente);
        response = clienteMap.fromCliente(cliente);

        if (success) {
            response.setStatus(true);
            response.setMessage("Cliente atualizado com sucesso!");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao atualizar o cliente.");
        }
        return response;
    }

    public ClienteResponseDTO delete(Long id) {
        ClienteResponseDTO response = new ClienteResponseDTO();
        if (id == null) {
            response.setStatus(false);
            response.setMessage("ID do cliente inválido.");
            return response;
        }

        Cliente cliente = clienteDAO.getById(id);
        if (cliente == null) {
            response.setStatus(false);
            response.setMessage("Cliente não encontrado.");
            return response;
        }

        boolean success = clienteDAO.remove(cliente);

        if (success) {
            response.setStatus(true);
            response.setMessage("Cliente removido com sucesso!");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao remover o cliente.");
        }
        return response;
    }

    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = clienteDAO.getById(id);
        if (cliente != null) {
            ClienteResponseDTO response = clienteMap.fromCliente(cliente);
            response.setStatus(true);
            response.setMessage("Cliente encontrado.");
            return response;
        }
        ClienteResponseDTO response = new ClienteResponseDTO();
        response.setStatus(false);
        response.setMessage("Cliente não encontrado.");
        return response;
    }

    public List<ClienteResponseDTO> listAll() {
        List<Cliente> clientes = clienteDAO.getAll();
        List<ClienteResponseDTO> responses = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteResponseDTO response = clienteMap.fromCliente(cliente);
            response.setStatus(true);
            responses.add(response);
        }
        return responses;
    }
}

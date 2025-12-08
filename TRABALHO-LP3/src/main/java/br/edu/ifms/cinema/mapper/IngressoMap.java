/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.AssentoResponseDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.dto.IngressoRequestDTO;
import br.edu.ifms.cinema.dto.IngressoResponseDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Assento;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Ingresso;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author victor ferreira
 */
public class IngressoMap {
    
    public static Ingresso toIngresso(IngressoRequestDTO dto, Sessao sessao, Cliente cliente, Assento assento) {
        Ingresso ingresso = new Ingresso();
        ingresso.setId(dto.getId());
        ingresso.setCodigo(dto.getCodigo());
        ingresso.setValor(dto.getValor());
        ingresso.setSessao(sessao);
        ingresso.setCliente(cliente);
        ingresso.setAssento(assento);
        return ingresso;
        
    }
    
    public static IngressoResponseDTO fromIngresso (Ingresso ingresso, SessaoResponseDTO sessao, ClienteResponseDTO cliente, AssentoResponseDTO assento) {
        IngressoResponseDTO response = new IngressoResponseDTO();
        response.setId(ingresso.getId());
        response.setCodigo(ingresso.getCodigo());
        response.setValor(ingresso.getValor());
        response.setSessao(sessao);
        response.setCliente(cliente);
        response.setAssento(assento);
        return response;
    }
    
}

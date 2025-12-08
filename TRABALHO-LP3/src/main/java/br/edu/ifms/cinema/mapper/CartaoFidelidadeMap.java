/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.CartaoFidelidadeRequestDTO;
import br.edu.ifms.cinema.dto.CartaoFidelidadeResponseDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.model.CartaoFidelidade;
import br.edu.ifms.cinema.model.Cliente;

/**
 *
 * @author victor ferreira
 */
public class CartaoFidelidadeMap {
    
    public static CartaoFidelidade toCartaoFidelidade(CartaoFidelidadeRequestDTO dto, Cliente cliente) {
        CartaoFidelidade cartao = new CartaoFidelidade();
        cartao.setId(dto.getId());
        cartao.setPontos(dto.getPontos());
        cartao.setNivel(dto.getNivel());
        cartao.setCliente(cliente);
        return cartao;
    }
    
    public static CartaoFidelidadeResponseDTO fromCartaoFidelidade (CartaoFidelidade cartao, ClienteResponseDTO cliente){
        CartaoFidelidadeResponseDTO response = new CartaoFidelidadeResponseDTO();
        response.setId(cartao.getId());
        response.setPontos(cartao.getPontos());
        response.setNivel(cartao.getNivel());
        response.setCliente(cliente);
        return response;
    }
    
}

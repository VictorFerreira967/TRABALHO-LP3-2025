/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.AssentoRequestDTO;
import br.edu.ifms.cinema.dto.AssentoResponseDTO;
import br.edu.ifms.cinema.dto.SalaResponseDTO;
import br.edu.ifms.cinema.model.Assento;
import br.edu.ifms.cinema.model.Sala;

/**
 *
 * @author victor ferreira
 */
public class AssentoMap {
    
    public static Assento toAssento(AssentoRequestDTO dto, Sala sala) {
       Assento assento  = new Assento(); 
       assento.setId(dto.getId());
       assento.setNumero(dto.getNumero());
       assento.setDisponivel(dto.isDisponivel());
       assento.setSala(sala);
       return assento;
    }
    
    public static AssentoResponseDTO fromAssento (Assento assento, SalaResponseDTO sala){
        AssentoResponseDTO response = new AssentoResponseDTO();
        response.setId(assento.getId());
        response.setNumero(assento.getNumero());
        response.setDisponivel(assento.isDisponivel());
        response.setSala(sala);
        return response;
    }
    
}

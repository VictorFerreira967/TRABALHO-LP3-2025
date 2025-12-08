/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.model.Assento;
import br.edu.ifms.cinema.model.Sala;

/**
 *
 * @author victor ferreira
 */
public class AssentoMap {
    public static Assento toAssento(AssentoRequestDTO dto, Sala sala) {
        Assento assento = new Assento();
        Assento.setId(dto.getId());
    }
    
}

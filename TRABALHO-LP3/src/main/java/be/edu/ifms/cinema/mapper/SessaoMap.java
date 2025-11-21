/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema.mapper;

import be.edu.ifms.cinema.dto.FilmeResponseDTO;
import be.edu.ifms.cinema.dto.SessaoRequestDTO;
import be.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author victor ferreira
 */
public class SessaoMap {
    //mapeia um bjt sessaoRequest para um obj sessao
    public static Sessao toSessao(SessaoRequestDTO dto,Filme filme){
        Sessao sessao = new Sessao();
        sessao.setId(dto.getId());
        sessao.setHorario(dto.getHorario());
        sessao.setFilme(filme);
        return sessao;
    }
    
    public static SessaoResponseDTO fromSessao(Sessao sessao,FilmeResponseDTO filme){
        SessaoResponseDTO response = new SessaoResponseDTO();
                response.setId(sessao.getId());
                response.setHorario(sessao.getHorario());
                response.setFilme(filme);
                return response;
    }
    
}

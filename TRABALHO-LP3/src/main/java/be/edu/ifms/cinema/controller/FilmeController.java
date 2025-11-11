/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema.controller;

import be.edu.ifms.cinema.dto.FilmeResponseDTO;
import be.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.model.Filme;

/**
 *
 * @author victor ferreira
 */
public class FilmeController {
    private static GenericDAO filmeDAO;
    
    public FilmeResponseDTO add(FilmeRequestDTO dto){
        FilmeResponseDTO response = new FilmeResponseDTO(); 
        if(dto != null){
            
        //serie de validacoes
        if(dto.getId() != null){
            response.setStatus(false);
            response.setMessage("transacao invalida");
            return response;
        }
        //depois das validacoes
        Filme filme = new Filme();
        Filme.setTitulo(dto.getTitulo());
        Filme.getGenero(dto.getGenero());
        Filme.getClasificacao(dto.getClassificacao());
        Filme.getDuracao(dto.getDuracaoMinutos());
        for (SessaoRequestDTO sessaoDTO : dto.getSessoes());;
            Sessao sessao = new Sessao();
            sessao.setId(sessaoDTO.getId());
            sessao.setHorario(sessaoDTO.getHorario());
           // sessao.setFilme(sessoDTO.get)
        }
        FilmeDAO = new FilmeDAO();
        FilmeDAO.add(filme);
        //mapeamento de filme, para FilmeDTO
        //sessaoRespnseDTO
        response.setStatus(true);
        response.setMessage("Filme cadastrado com sucesso");
        
        return response;
    
    
    }
}

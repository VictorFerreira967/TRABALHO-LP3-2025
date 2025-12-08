/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.mapper.SessaoMap;
import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.mapper.FilmeMap;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudante
 */
public class FilmeController {
    private GenericDAO<Filme> filmeDAO;

    public FilmeController() {
        filmeDAO = new FilmeDAO();
    }

    public FilmeResponseDTO create(FilmeRequestDTO dto) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        if (dto == null || dto.getId() != null) {
            response.setStatus(false);
            response.setMessage("Dados inválidos para criação do filme.");
            return response;
        }

        Filme filme = FilmeMap.toFilme(dto);
        if (dto.getSessoes() != null) {
            for (SessaoRequestDTO sessaoDTO : dto.getSessoes()) {
                Sessao sessao = SessaoMap.toSessao(sessaoDTO, filme);
                filme.getSessoes().add(sessao);
            }
        }

        boolean success = filmeDAO.add(filme);

        response = FilmeMap.fromFilme(filme);
        if (filme.getSessoes() != null) {
            for (Sessao sessao : filme.getSessoes()) {
                SessaoResponseDTO sessaoDTO = SessaoMap.fromSessao(sessao, response);
                response.getSessoes().add(sessaoDTO);
            }
        }

        if (success) {
            response.setStatus(true);
            response.setMessage("Filme cadastrado com sucesso!");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao cadastrar o filme.");
        }
        return response;
    }

    public FilmeResponseDTO update(Long id, FilmeRequestDTO dto) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        if (dto == null || id == null) {
            response.setStatus(false);
            response.setMessage("Dados inválidos para atualização do filme.");
            return response;
        }

        Filme existingFilme = filmeDAO.getById(id);
        if (existingFilme == null) {
            response.setStatus(false);
            response.setMessage("Filme não encontrado.");
            return response;
        }

        Filme filme = FilmeMap.toFilme(dto);
        filme.setId(id);

        boolean success = filmeDAO.update(filme);
        response = FilmeMap.fromFilme(filme);

        if (success) {
            response.setStatus(true);
            response.setMessage("Filme atualizado com sucesso!");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao atualizar o filme.");
        }
        return response;
    }

    public FilmeResponseDTO delete(Long id) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        if (id == null) {
            response.setStatus(false);
            response.setMessage("ID do filme inválido.");
            return response;
        }

        Filme filme = filmeDAO.getById(id);
        if (filme == null) {
            response.setStatus(false);
            response.setMessage("Filme não encontrado.");
            return response;
        }

        boolean success = filmeDAO.remove(filme);

        if (success) {
            response.setStatus(true);
            response.setMessage("Filme removido com sucesso!");
        } else {
            response.setStatus(false);
            response.setMessage("Erro ao remover o filme.");
        }
        return response;
    }

    public FilmeResponseDTO findById(Long id) {
        Filme filme = filmeDAO.getById(id);
        if (filme != null) {
            FilmeResponseDTO response = FilmeMap.fromFilme(filme);
             if (filme.getSessoes() != null) {
                for (Sessao sessao : filme.getSessoes()) {
                    SessaoResponseDTO sessaoDTO = SessaoMap.fromSessao(sessao, response);
                    response.getSessoes().add(sessaoDTO);
                }
            }
            response.setStatus(true);
            response.setMessage("Filme encontrado.");
            return response;
        }
        FilmeResponseDTO response = new FilmeResponseDTO();
        response.setStatus(false);
        response.setMessage("Filme não encontrado.");
        return response;
    }

    public List<FilmeResponseDTO> listAll() {
        List<Filme> filmes = filmeDAO.getAll();
        List<FilmeResponseDTO> responses = new ArrayList<>();
        for (Filme filme : filmes) {
            FilmeResponseDTO response = FilmeMap.fromFilme(filme);
             if (filme.getSessoes() != null) {
                for (Sessao sessao : filme.getSessoes()) {
                    SessaoResponseDTO sessaoDTO = SessaoMap.fromSessao(sessao, response);
                    response.getSessoes().add(sessaoDTO);
                }
            }
            response.setStatus(true);
            responses.add(response);
        }
        return responses;
    }
}
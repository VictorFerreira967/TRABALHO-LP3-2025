/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema;

import be.edu.ifms.cinema.dto.FilmeRequestDTO;
import be.edu.ifms.cinema.dto.FilmeResponseDTO;
import be.edu.ifms.cinema.dto.SessaoRequestDTO;
import be.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.controller.FilmeController;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;



/**
 *
 * @author victor ferreira
 */
public class Main {
   public static void main(String[] args) {
        FilmeRequestDTO request = new FilmeRequestDTO();
        request.setTitulo("Matrix");
        request.setGenero("SCI-FI");
        request.setDuracaoMinutos(202);
        request.setClassificacao("Livre");
        
        SessaoRequestDTO sessao = new SessaoRequestDTO();
        sessao.setFilme(request);
        sessao.setHorario(LocalDateTime.of(2025,11,18,15,30));
        request.getSessoes().add(sessao);

        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
        sessao2.setFilme(request);
        sessao2.setHorario(LocalDateTime.of(2025,11,18,18,50));
        request.getSessoes().add(sessao2);
        
        FilmeController controle = new FilmeController();
        FilmeResponseDTO response = controle.add(request);
        if(response.isStatus()){
            JOptionPane.showMessageDialog(null,response.getMessage(),"Cadastrado Com Sucesso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme");
            System.out.println("ID: "+ response.getId());
            System.out.println("Título: "+ response.getTitulo());
            System.out.println("Gênero: "+ response.getGenero());
            System.out.println("Duração: (min.): "+ response.getDuracaoMinutos());
            System.out.println("Classificação: "+ response.getClassificacao());
            System.out.println("Sessões: ");
            for (SessaoResponseDTO sessaoResp : response.getSessoes()) {
                System.out.println("Id: "+ sessaoResp.getId());
                System.out.println("Horário: "+ sessaoResp.getHorario());
                System.out.println("----------------------------");
            }
        }else{
            JOptionPane.showMessageDialog(null,response.getMessage(),"Falha no Cadastro", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
}
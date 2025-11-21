/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema.dto;


import java.time.LocalDateTime;

/**
 *
 * @author victor ferreira
 */
public class SessaoRequestDTO {
    private Long id;
    private LocalDateTime horario;
    private FilmeRequestDTO filme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public FilmeRequestDTO getFilme() {
        return filme;
    }

    public void setFilme(FilmeRequestDTO filme) {
        this.filme = filme;
    }

   
    

  
    }

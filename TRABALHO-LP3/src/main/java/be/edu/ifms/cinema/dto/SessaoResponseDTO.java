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
public class SessaoResponseDTO {
    private long id;
    private LocalDateTime horario;
    private FilmeResponseDTO filme;
    private boolean Status;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public FilmeResponseDTO getFilme() {
        return filme;
    }

    public void setFilme(FilmeResponseDTO filme) {
        this.filme = filme;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
                  
    
                  
}

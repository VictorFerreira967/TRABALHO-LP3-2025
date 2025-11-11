/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema.dto;

/**
 *
 * @author victor ferreira
 */
public class SessaoResquestDTO {
    private Long id;
    private LocalDateTime horario;
    private long idfilme;

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

    public long getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(long idfilme) {
        this.idfilme = idfilme;
    }
    
    
    
    
    
}

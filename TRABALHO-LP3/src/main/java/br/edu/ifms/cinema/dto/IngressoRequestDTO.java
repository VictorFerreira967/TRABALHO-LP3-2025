/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dto;

/**
 *
 * @author victor ferreira
 */
public class IngressoRequestDTO {
    
    private long id;
    private String codigo;
    private double valor;
    private long sessaoId;
    private long clienteId;
    private long assentoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(long sessaoId) {
        this.sessaoId = sessaoId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public long getAssentoId() {
        return assentoId;
    }

    public void setAssentoId(long assentoId) {
        this.assentoId = assentoId;
    }
    
    
}

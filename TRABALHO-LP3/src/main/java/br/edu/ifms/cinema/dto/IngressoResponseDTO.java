/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dto;

/**
 *
 * @author victor ferreira
 */
public class IngressoResponseDTO {
    
    private Long id;
    private String codigo;
    private Double valor;
    private SessaoResponseDTO sessao;
    private ClienteResponseDTO cliente;
    private AssentoResponseDTO assento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public SessaoResponseDTO getSessao() {
        return sessao;
    }

    public void setSessao(SessaoResponseDTO sessao) {
        this.sessao = sessao;
    }

    public ClienteResponseDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponseDTO cliente) {
        this.cliente = cliente;
    }

    public AssentoResponseDTO getAssento() {
        return assento;
    }

    public void setAssento(AssentoResponseDTO assento) {
        this.assento = assento;
    }
    
    
}

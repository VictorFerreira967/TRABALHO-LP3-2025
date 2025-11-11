/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema;

import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author victor ferreira
 */
public class Main {
    public static void main(String[] args) {
        Filme f1 = new Filme();
        Filme f2 = new Filme();
        Filme f3 = new Filme();
        
        f1.setGenero("A volta do indiano");
        f1.setGenero("Açao");
        f1.setDuracaoMinutos(144);
        f1.setClassificacao("18");
        
        f2.setGenero("Divertidade");
        f2.setGenero("Animacao");
        f2.setDuracaoMinutos(144);
        f2.setClassificacao("Livre");
        
        f3.setGenero("whalle");
        f3.setGenero("Animacao");
        f3.setDuracaoMinutos(180);
        f3.setClassificacao("Livre");
        
        Sessao s1 = new Sessao();
        Sessao s2 = new Sessao();
        Sessao s3 = new Sessao();
        Sessao s4 = new Sessao();
        
        s1.setHorario(localDataTime.of(2025, 11, 11 14, 00));
        s1.setFilme(f2);
        
        s2.setHorario(localDataTime.of(2025, 11, 11 14, 00));
        s1.setFilme(f2);
        
        s3.setHorario(localDataTime.of(2025, 11, 11 14, 00));
        s3.setFilme(f2);
        
        s4.setHorario(localDataTime.of(2025, 11, 11 14, 00));
        s4.setFilme(f2);
        
        
        f1.getSessao().add(s4);
        f2.getSessao().add(s4);
        f3.getSessao().add(s4);
        f4.getSessao().add(s4);
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.edu.ifms.cinema;


import br.edu.ifms.cinema.controller.ClienteController;
import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dao.AssentoDAO;
import br.edu.ifms.cinema.dao.CartaoFidelidadeDAO;
import br.edu.ifms.cinema.dao.IngressoDAO;
import br.edu.ifms.cinema.dao.SalaDAO;
import br.edu.ifms.cinema.dao.SessaoDAO;
import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Assento;
import br.edu.ifms.cinema.model.CartaoFidelidade;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Ingresso;
import br.edu.ifms.cinema.model.Sala;
import br.edu.ifms.cinema.model.Sessao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author victor ferreira
 */
public class Main {
       private static void logResponse(String entityName, boolean status, String message) {
        String type = status ? "SUCESSO" : "FALHA";
        System.out.println("--- " + entityName.toUpperCase() + " - " + type + " ---");
        System.out.println("Mensagem: " + message);
        System.out.println("------------------------------------");
        // Opcional: Mostrar JOptionPane, mas pode não funcionar em ambiente headless
        // if (!status) {
        //     JOptionPane.showMessageDialog(null, message, "Falha na Inserção de " + entityName, JOptionPane.ERROR_MESSAGE);
        // }
    }
    
    private static FilmeResponseDTO inserirFilme(FilmeController controller, String titulo, String genero, int duracao, String classificacao, LocalDateTime horario1, LocalDateTime horario2) {
        FilmeRequestDTO filmeRequest = new FilmeRequestDTO();
        filmeRequest.setTitulo(titulo);
        filmeRequest.setGenero(genero);
        filmeRequest.setDuracaoMinutos(duracao);
        filmeRequest.setClassificacao(classificacao);
        
        List<SessaoRequestDTO> sessoes = new ArrayList<>();
        
        SessaoRequestDTO sessao1Request = new SessaoRequestDTO();
        sessao1Request.setHorario(horario1);
        sessoes.add(sessao1Request);
        
        if (horario2 != null) {
            SessaoRequestDTO sessao2Request = new SessaoRequestDTO();
            sessao2Request.setHorario(horario2);
            sessoes.add(sessao2Request);
        }
        
        filmeRequest.setSessoes(sessoes);
        
        FilmeResponseDTO filmeResponse = controller.create(filmeRequest);
        logResponse("Filme: " + titulo, filmeResponse.isStatus(), filmeResponse.getMessage());
        return filmeResponse;
    }
    
    private static ClienteResponseDTO inserirClienteComCartao(ClienteController clienteController, CartaoFidelidadeDAO cartaoDAO, String nome, String email, String telefone, int pontos, String nivel) {
        ClienteRequestDTO clienteRequest = new ClienteRequestDTO();
        clienteRequest.setNome(nome);
        clienteRequest.setEmail(email);
        clienteRequest.setTelefone(telefone);
        
        ClienteResponseDTO clienteResponse = clienteController.create(clienteRequest);
        logResponse("Cliente: " + nome, clienteResponse.isStatus(), clienteResponse.getMessage());
        
        if (clienteResponse.isStatus()) {
            // Recuperar o objeto Cliente persistido para as próximas inserções
            Cliente cliente = new Cliente();
            cliente.setId(clienteResponse.getId());
            cliente.setNome(clienteResponse.getNome());
            cliente.setEmail(clienteResponse.getEmail());
            cliente.setTelefone(clienteResponse.getTelefone());
            
            // Inserção de Cartão Fidelidade
            CartaoFidelidade cartao = new CartaoFidelidade();
            cartao.setPontos(pontos);
            cartao.setNivel(nivel);
            cartao.setCliente(cliente);
            
            boolean cartaoSuccess = cartaoDAO.add(cartao);
            logResponse("Cartão Fidelidade para " + nome, cartaoSuccess, cartaoSuccess ? "Cartão Fidelidade cadastrado com sucesso!" : "Erro ao cadastrar Cartão Fidelidade.");
        }
        return clienteResponse;
    }
    
    public static void main(String[] args) {
        
        // --- INICIALIZAÇÃO DE DAOs E CONTROLLERS ---
        SalaDAO salaDAO = new SalaDAO();
        AssentoDAO assentoDAO = new AssentoDAO();
        ClienteController clienteController = new ClienteController();
        CartaoFidelidadeDAO cartaoDAO = new CartaoFidelidadeDAO();
        FilmeController filmeController = new FilmeController();
        SessaoDAO sessaoDAO = new SessaoDAO();
        IngressoDAO ingressoDAO = new IngressoDAO();
        
        // --- 1. INSERÇÃO DE SALA E ASSENTOS ---
        System.out.println("--- 1. INSERINDO SALA E ASSENTOS ---");
        Sala sala1 = new Sala();
        sala1.setNome("Sala Principal - 4K");
        sala1.setCapacidade(50);
        
        List<Assento> assentosSala1 = new ArrayList<>();
        // Criando 50 assentos (A1 a A50)
        for (int i = 1; i <= 50; i++) {
            Assento assento = new Assento();
            assento.setNumero("A" + i);
            assento.setDisponivel(true);
            assento.setSala(sala1);
            assentosSala1.add(assento);
        }
        sala1.setAssentos(assentosSala1);
        
        boolean salaSuccess = salaDAO.add(sala1);
        logResponse("Sala Principal", salaSuccess, salaSuccess ? "Sala e seus 50 assentos cadastrados com sucesso!" : "Erro ao cadastrar Sala.");
        
        
        // --- 2. INSERÇÃO DE CLIENTES E CARTÕES FIDELIDADE ---
        System.out.println("\n--- 2. INSERINDO CLIENTES E CARTÕES FIDELIDADE ---");
        
        // Lista para armazenar os clientes inseridos (necessário para o Ingresso)
        List<ClienteResponseDTO> clientesResponse = new ArrayList<>();
        
        clientesResponse.add(inserirClienteComCartao(clienteController, cartaoDAO, "Victor", "victor@email.com", "67991234567", 200, "Ouro"));
        clientesResponse.add(inserirClienteComCartao(clienteController, cartaoDAO, "Paulão", "paulao@email.com", "67992345678", 50, "Bronze"));
        clientesResponse.add(inserirClienteComCartao(clienteController, cartaoDAO, "Luquinhas", "luquinhas@email.com", "67993456789", 150, "Prata"));
        clientesResponse.add(inserirClienteComCartao(clienteController, cartaoDAO, "Leodonam", "leodonam@email.com", "67994567890", 300, "Ouro"));
        clientesResponse.add(inserirClienteComCartao(clienteController, cartaoDAO, "Vini", "vini@email.com", "67995678901", 10, "Bronze"));
        
        
        // --- 3. INSERÇÃO DE FILMES E SESSÕES ---
        System.out.println("\n--- 3. INSERINDO FILMES E SESSÕES ---");
        
        // Inserir o primeiro filme e capturar a resposta para usar na inserção do Ingresso
        FilmeResponseDTO filmeResponse = inserirFilme(filmeController, 
                     "A Origem", 
                     "Ficção Científica", 
                     148, 
                     "14", 
                     LocalDateTime.of(2025, 12, 10, 19, 0), 
                     LocalDateTime.of(2025, 12, 10, 22, 30));
        
        // Inserir os demais filmes
        inserirFilme(filmeController, 
                     "O Poderoso Chefão", 
                     "Crime/Drama", 
                     175, 
                     "16", 
                     LocalDateTime.of(2025, 12, 11, 15, 0), 
                     null);
        
        inserirFilme(filmeController, 
                     "Pulp Fiction: Tempo de Violência", 
                     "Crime/Drama", 
                     154, 
                     "18", 
                     LocalDateTime.of(2025, 12, 11, 20, 30), 
                     LocalDateTime.of(2025, 12, 12, 0, 0));
        
        inserirFilme(filmeController, 
                     "A Lista de Schindler", 
                     "Drama/Histórico", 
                     195, 
                     "14", 
                     LocalDateTime.of(2025, 12, 12, 18, 0), 
                     null);
        
        inserirFilme(filmeController, 
                     "Forrest Gump: O Contador de Histórias", 
                     "Drama/Romance", 
                     142, 
                     "Livre", 
                     LocalDateTime.of(2025, 12, 13, 17, 0), 
                     LocalDateTime.of(2025, 12, 13, 20, 0));
        
        
        // --- 4. INSERÇÃO DE INGRESSO (Depende de Cliente, Sessão e Assento) ---
        System.out.println("\n--- 4. INSERINDO INGRESSO ---");
        
        // Pré-requisitos para o Ingresso:
        Cliente clienteIngresso = null;
        Sessao sessaoIngresso = null;
        Assento assentoIngresso = null;
        
        // A. Obter o Cliente (Victor)
        if (!clientesResponse.isEmpty() && clientesResponse.get(0).isStatus()) {
            ClienteResponseDTO clienteResp = clientesResponse.get(0);
            clienteIngresso = new Cliente();
            clienteIngresso.setId(clienteResp.getId());
            // ... (outros setters se necessário)
        }
        
        // B. Obter a Sessão (Primeira sessão do filme "A Origem")
        if (filmeResponse.isStatus() && !filmeResponse.getSessoes().isEmpty()) {
            SessaoResponseDTO sessaoResp = filmeResponse.getSessoes().get(0);
            // É necessário buscar a Sessão persistida pelo ID
            sessaoIngresso = sessaoDAO.getById(sessaoResp.getId());
        }
        
        // C. Obter o Assento (Assento A1, assumindo ID 1)
        if (salaSuccess) {
            // Assumindo que o primeiro assento inserido tem ID 1.
            assentoIngresso = assentoDAO.getById(1L);
        }
        
        if (clienteIngresso != null && sessaoIngresso != null && assentoIngresso != null) {
            Ingresso ingresso = new Ingresso();
            ingresso.setCodigo("ING-AOR-12345");
            ingresso.setValor(35.00);
            ingresso.setCliente(clienteIngresso);
            ingresso.setSessao(sessaoIngresso);
            ingresso.setAssento(assentoIngresso);
            
            boolean ingressoSuccess = ingressoDAO.add(ingresso);
            logResponse("Ingresso", ingressoSuccess, ingressoSuccess ? "Ingresso cadastrado com sucesso!" : "Erro ao cadastrar Ingresso.");
            
            // Opcional: Marcar assento como indisponível
            if (ingressoSuccess) {
                assentoIngresso.setDisponivel(false);
                assentoDAO.update(assentoIngresso);
                System.out.println("Assento " + assentoIngresso.getNumero() + " marcado como indisponível.");
            }
        } else {
            logResponse("Ingresso", false, "Pré-requisitos (Cliente, Sessão ou Assento) não atendidos para a inserção do Ingresso.");
            System.out.println("Status dos pré-requisitos: Cliente=" + (clienteIngresso != null) + ", Sessão=" + (sessaoIngresso != null) + ", Assento=" + (assentoIngresso != null));
        }
        
        
        // --- LISTAGEM PARA VERIFICAÇÃO ---
        
        // Exemplo de listagem de todos os clientes
        System.out.println("\n--- LISTANDO TODOS OS CLIENTES INSERIDOS ---");
        List<ClienteResponseDTO> clientes = clienteController.listAll();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            for (ClienteResponseDTO c : clientes) {
                System.out.println("Cliente: " + c.getNome() + " (ID: " + c.getId() + ", Email: " + c.getEmail() + ")");
            }
        }
        

        }
    }

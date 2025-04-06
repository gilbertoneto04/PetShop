package Petshop;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
    private String nome;
    private String telefone;
    private String cpf;  // CPF como identificador único
    private String usuario;
    private String senha;
    private static Map<String, String> clientesRegistrados = new HashMap<>();
    private static Map<String, Cliente> clientesPorCpf = new HashMap<>();  // Mapa para garantir CPF único

    public Cliente(String nome, String telefone, String cpf, String usuario, String senha) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório para cliente");
        }
        if (clientesPorCpf.containsKey(cpf)) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        clientesRegistrados.put(usuario, senha);
        clientesPorCpf.put(cpf, this);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    // Método para realizar login
    public static boolean login(String usuario, String senha) {
        if (clientesRegistrados.containsKey(usuario)){
            String senhaArmazenada = clientesRegistrados.get(usuario);
            if (senhaArmazenada.equals(senha)) {
                System.out.println("Login bem-sucedido!");
                return true;
            }
        }
        System.out.println("Usuário ou senha incorretos.");
        return false;
    }

    // Método para encontrar cliente por CPF
    public static Cliente getClientePorCpf(String cpf) {
        return clientesPorCpf.get(cpf);
    }
}
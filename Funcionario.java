package Petshop;

public class Funcionario {
    private String nome;
    private String cpf;  // CPF como identificador único
    private String cargo;

    public Funcionario(String nome, String cpf, String cargo) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório para funcionário");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    // Getters e Setters (com validação no setter de CPF)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
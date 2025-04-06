package Petshop;

import java.util.ArrayList;
import java.util.List;

public class SistemaPetshop {
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Servico> servicosDisponiveis;
    private List<OrdemServico> ordensServico;
    private List<Paciente> pacientes;

    public SistemaPetshop() {
        this.setFuncionarios(new ArrayList<>());
        this.setClientes(new ArrayList<>());
        this.servicosDisponiveis = new ArrayList<>();
        this.ordensServico = new ArrayList<>();
        this.setPacientes(new ArrayList<>());
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        getFuncionarios().add(funcionario);
    }

    public void listarFuncionarios() {
        for (Funcionario f : getFuncionarios()) {
            System.out.println("Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
        }
    }

    public void adicionarCliente(Cliente cliente) {
        getClientes().add(cliente);
    }

    public void listarClientes() {
        for (Cliente c : getClientes()) {
            System.out.println("Nome: " + c.getNome() + " | Telefone: " + c.getTelefone());
        }
    }

    public void adicionarServico(Servico servico) {
        servicosDisponiveis.add(servico);
    }

    public void listarServicos() {
        for (Servico s : servicosDisponiveis) {
            System.out.println("Serviço: " + s.getDescricao() + " | Preço: " + s.getPreco());
        }
    }

    public void criarOrdemServico(OrdemServico ordem) {
        ordensServico.add(ordem);
    }

    public void listarOrdensServico() {
        for (OrdemServico o : ordensServico) {
            System.out.println("Cliente: " + o.getCliente().getNome() + " | Concluída: " + o.isConcluida());
        }
    }

    public void adicionarPaciente(Paciente paciente) {
        getPacientes().add(paciente);
    }

    public void listarPacientes() {
        for (Paciente p : getPacientes()) {
            System.out.println("Paciente: " + p.getNome() + " | Espécie: " + p.getEspecie() + " | Dono: " + p.getDono().getNome());
        }
    }

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}

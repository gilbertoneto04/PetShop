package Petshop;

import java.util.ArrayList;
import java.util.List;

public class OrdemServico {

	    private Cliente cliente;
	    private List<Servico> servicos;
	    private boolean concluida;

	    public OrdemServico(Cliente cliente) {
	        this.cliente = cliente;
	        this.servicos = new ArrayList<>();
	        this.concluida = false;
	    }

	    public void adicionarServico(Servico servico) {
	        servicos.add(servico);
	    }

	    public void concluirOrdem() {
	        this.concluida = true;
	    }

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<Servico> getServicos() {
			return servicos;
		}

		public void setServicos(List<Servico> servicos) {
			this.servicos = servicos;
		}

		public boolean isConcluida() {
			return concluida;
		}

		public void setConcluida(boolean concluida) {
			this.concluida = concluida;
		}

	}



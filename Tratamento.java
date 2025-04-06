package Petshop;

public class Tratamento {
    private String descricao;
    private boolean emAndamento;

    public Tratamento(String descricao) {
        this.descricao = descricao;
        this.emAndamento = true;
    }

    public void atualizarStatus(boolean concluido) {
        this.emAndamento = !concluido;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}
}


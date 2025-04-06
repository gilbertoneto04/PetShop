package Petshop;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private String especie;
    private String raca;
    private Cliente dono;
    private List<Tratamento> tratamentos;

    public Paciente(String nome, String especie, String raca, Cliente dono) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dono = dono;
        this.tratamentos = new ArrayList<>();
    }

    public void adicionarTratamento(Tratamento tratamento) {
        tratamentos.add(tratamento);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}


}


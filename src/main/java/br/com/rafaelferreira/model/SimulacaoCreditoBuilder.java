package br.com.rafaelferreira.model;

public class SimulacaoCreditoBuilder {

	private String id;
	private String cpf;
	private String nome;
	private String email;
	private double valor;
	private int parcelas;
	private boolean seguro;

	public SimulacaoCreditoBuilder id(String id) {
		this.id = id;
		return this;
	}
	
	public SimulacaoCreditoBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public SimulacaoCreditoBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public SimulacaoCreditoBuilder email(String email) {
		this.email = email;
		return this;
	}

	public SimulacaoCreditoBuilder valor(double valor) {
		this.valor = valor;
		return this;
	}

	public SimulacaoCreditoBuilder parcelas(int parcelas) {
		this.parcelas = parcelas;
		return this;
	}

	public SimulacaoCreditoBuilder seguro(boolean seguro) {
		this.seguro = seguro;
		return this;
	}

	public SimulacaoCredito build() {

		return new SimulacaoCredito(id, cpf, nome, email, valor, parcelas, seguro);
	}

}
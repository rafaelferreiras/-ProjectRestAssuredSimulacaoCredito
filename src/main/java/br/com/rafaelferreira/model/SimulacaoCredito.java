package br.com.rafaelferreira.model;

public class SimulacaoCredito {

	private String id;
	private String cpf;
	private String nome;
	private String email;
	private double valor;
	private int parcelas;
	private boolean seguro;
	
	

	public SimulacaoCredito() {
		
	}

	public SimulacaoCredito(String id, String cpf, String nome, String email, double valor, int parcelas,
			boolean seguro) {

		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.valor = valor;
		this.parcelas = parcelas;
		this.seguro = seguro;

	}

	public String getCpf() {
		return cpf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public boolean getSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return "SimulacaoCredito [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", valor="
				+ valor + ", parcelas=" + parcelas + ", seguro=" + seguro + "]";
	}

}

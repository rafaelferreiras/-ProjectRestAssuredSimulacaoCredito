package br.com.rafaelferreira.data;

import java.util.ArrayList;

public final class GeraCPF {

	private ArrayList<Integer> listaAleatoria = new ArrayList<Integer>();
	private ArrayList<Integer> listaNumMultiplicados = null;

	public int geraNumAleatorio() {
		return (int) (Math.random() * 10);
	}

	public ArrayList<Integer> geraCPFParcial() {
		for (int i = 0; i < 9; i++)
			listaAleatoria.add(geraNumAleatorio());
		return listaAleatoria;
	}

	public ArrayList<Integer> geraDigito() {
		listaNumMultiplicados = new ArrayList<Integer>();
		int primeiroDigito;
		int totalSomatoria = 0;
		int restoDivisao;
		int peso = 10;
		for (int item : listaAleatoria)
			listaNumMultiplicados.add(item * peso--);
		for (int item : listaNumMultiplicados)
			totalSomatoria += item;
		restoDivisao = (totalSomatoria % 11);
		primeiroDigito = restoDivisao < 2 ? 0 : 11 - restoDivisao;
		listaAleatoria.add(primeiroDigito);
		return listaAleatoria;
	}

	public String geraCPFFinal() {

		geraCPFParcial();
		geraDigito();
		geraDigito();
		String cpf = "";
		for (int item : listaAleatoria)
			cpf += Integer.toString(item);
		return cpf;
	}

}
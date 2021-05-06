package br.com.rafaelferreira.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

import br.com.rafaelferreira.config.Configuration;
import br.com.rafaelferreira.config.ConfigurationManager;
import br.com.rafaelferreira.model.SimulacaoCredito;
import br.com.rafaelferreira.model.SimulacaoCreditoBuilder;

public class DataFactory {

	private Faker faker;
	private static final Random RND = new Random();
	private String genericValue;
	Configuration configuration = ConfigurationManager.getConfiguration();
	GeraCPF cpf = new GeraCPF();
	static SimulacaoCredito simulacao;
	List<String> getSimulacao = new ArrayList<String>();

	public DataFactory() {

		faker = new Faker(new Locale("pt-BR"));
	}

	public String getGenericValue() {
		return genericValue;
	}

	public List<String> getSimulacao() {

		getSimulacao.add(simulacao.getId());
		getSimulacao.add(simulacao.getCpf());
		getSimulacao.add(simulacao.getNome());
		getSimulacao.add(simulacao.getEmail());
		getSimulacao.add(String.valueOf(simulacao.getParcelas()));
		getSimulacao.add(String.valueOf(simulacao.getValor()));
		getSimulacao.add(String.valueOf(simulacao.getSeguro()));

		return getSimulacao;
	}

	public SimulacaoCredito getSimulacaoOnAttribute() {

		return simulacao;
	}

	public SimulacaoCredito createSimulacao() {

		return simulacao = new SimulacaoCreditoBuilder().cpf(cpf.geraCPFFinal()).nome(faker.name().firstName())
				.email(faker.internet().emailAddress())
				.valor(valueRandomOnLimit(configuration.ValueMin(), configuration.ValueMax()))
				.parcelas(valueRandomOnLimit(configuration.ValueMinParcela(), configuration.ValueMaxParcela()))
				.seguro(faker.random().nextBoolean()).build();

	}

	public String createCPF() {

		return cpf.geraCPFFinal();

	}

	public String makeRandom(String[] array) {

		return genericValue = returnRandomItemOnArray(array);

	}

	public static int valueRandomOnLimit(int min, int max) {
		return RND.nextInt(max - min + 1) + min;
	}

	public String returnRandomItemOnArray(String[] array) {
		return array[(RND.nextInt(array.length))];
	}

}

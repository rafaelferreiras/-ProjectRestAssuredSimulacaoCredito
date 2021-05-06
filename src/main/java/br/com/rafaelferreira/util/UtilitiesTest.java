package br.com.rafaelferreira.util;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelferreira.data.DataFactory;
import br.com.rafaelferreira.model.SimulacaoCredito;
import io.restassured.response.Response;

public class UtilitiesTest {

	public static List<String> getListFullByJsonPath(Response response) {

		DataFactory data = new DataFactory();

		SimulacaoCredito simulacaoCredito = response.then().extract().jsonPath().getObject("", SimulacaoCredito.class);

		List<String> simulacao = new ArrayList<String>();

		simulacao.add(simulacaoCredito.getId());
		simulacao.add(simulacaoCredito.getCpf());
		simulacao.add(simulacaoCredito.getNome());
		simulacao.add(simulacaoCredito.getEmail());
		simulacao.add(String.valueOf(simulacaoCredito.getParcelas()));
		simulacao.add(String.valueOf(simulacaoCredito.getValor()));
		simulacao.add(String.valueOf(simulacaoCredito.getSeguro()));
		data.getSimulacaoOnAttribute().setId(simulacaoCredito.getId());

		return simulacao;

	}

}

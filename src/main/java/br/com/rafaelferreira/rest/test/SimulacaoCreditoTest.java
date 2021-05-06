package br.com.rafaelferreira.rest.test;

import static br.com.rafaelferreira.util.UtilitiesTest.getListFullByJsonPath;
import static br.com.rafaelferreira.validate.Validator.*;
import static br.com.rafaelferreira.validate.Validator.validaBodyAlert;
import static br.com.rafaelferreira.validate.Validator.validaList;
import static br.com.rafaelferreira.validate.Validator.validaStatusCode;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rafaelferreira.config.Configuration;
import br.com.rafaelferreira.config.ConfigurationManager;
import br.com.rafaelferreira.core.BaseTest;
import br.com.rafaelferreira.data.DataFactory;
import br.com.rafaelferreira.util.Utilities;

public class SimulacaoCreditoTest extends BaseTest {

	private DataFactory data;
	private JSONObject jsonObject;
	private Utilities util;

	private static Configuration configuration;

	@BeforeMethod
	public void beforeMethod() {

		data = new DataFactory();
		util = new Utilities();

		configuration = ConfigurationManager.getConfiguration();
		util.getDataFile("Data.json");

	}

	@Test
	public void CT_01_getCPFComRestricao() {

		jsonObject = util.getDataGroup("CT01");
		get(configuration.restricoes() + data.makeRandom(configuration.CPFRestricoes()));
		validaBodyAlert(jsonObject, data.getGenericValue(), response.jsonPath().get((String) jsonObject.get("path")));
		validaStatusCode(jsonObject, response.getStatusCode());

	}

	@Test
	public void CT_02_getCPFSemRestricao() {

		jsonObject = util.getDataGroup("CT02");
		get(configuration.restricoes().concat(data.createSimulacao().getCpf()));
		validaStatusCode(jsonObject, response.getStatusCode());

	}

	@Test
	public void CT_03_postSimulacao() {

		jsonObject = util.getDataGroup("CT03");
		post(configuration.simulacoes(), data.createSimulacao());
		validaBody(getListFullByJsonPath(response), data.getSimulacao());
		validaStatusCode(jsonObject, response.getStatusCode());

	}

	@Test
	public void CT_04_putSimulacao() {

		jsonObject = util.getDataGroup("CT04");

		put(configuration.simulacoes().concat(data.getSimulacaoOnAttribute().getCpf()), data.createSimulacao());
		validaBody(getListFullByJsonPath(response), data.getSimulacao());
		validaStatusCode(jsonObject, response.getStatusCode());

	}

	@Test
	public void CT_05_getSimulacao() {

		jsonObject = util.getDataGroup("CT05");

		get(configuration.simulacoes());
		validaList(response);
		validaStatusCode(jsonObject, response.getStatusCode());

	}

	@Test
	public void CT_06_deleteSimulacao() {

		jsonObject = util.getDataGroup("CT06");
		String id = data.getSimulacaoOnAttribute().getId();

		delete(configuration.simulacoes().concat(id));
		validaStatusCode(jsonObject, response.getStatusCode());
		get(configuration.simulacoes());
		validaDelete(response, id);

	}

}

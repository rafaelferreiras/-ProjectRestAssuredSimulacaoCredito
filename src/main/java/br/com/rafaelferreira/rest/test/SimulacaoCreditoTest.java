package br.com.rafaelferreira.rest.test;

import static br.com.rafaelferreira.util.UtilitiesTest.getListFullByJsonPath;
import static br.com.rafaelferreira.validate.Acceptance.validaBody;
import static br.com.rafaelferreira.validate.Acceptance.validaBodyAlert;
import static br.com.rafaelferreira.validate.Acceptance.validaDelete;
import static br.com.rafaelferreira.validate.Acceptance.validaList;
import static br.com.rafaelferreira.validate.Acceptance.validaStatusCode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rafaelferreira.config.Configuration;
import br.com.rafaelferreira.config.ConfigurationManager;
import br.com.rafaelferreira.core.BaseTest;
import br.com.rafaelferreira.data.DataFactory;
import br.com.rafaelferreira.util.Utilities;
import br.com.rafaelferreira.validate.Acceptance;

public class SimulacaoCreditoTest extends BaseTest {

	private DataFactory data;
	private Utilities util;
	private static Configuration configLocal;

	@BeforeMethod
	public void beforeMethod() {

		data = new DataFactory();
		util = new Utilities();
		

		configLocal = ConfigurationManager.getConfiguration();
		util.getDataFile("data.json");

	}

	public void initTest(String ct) {

		new Acceptance(util.getDataGroup(ct));
		 

	}

	@Test
	public void CT_01_getCPFComRestricao() {

		initTest("CT01");
		get(configLocal.restricoes().concat(data.makeRandom(configLocal.CPFRestricoes())));
			validaBodyAlert(data.getGenericValue(), response.jsonPath().get(configLocal.pathAlert()));
			validaStatusCode(response.getStatusCode());

	}

	@Test
	public void CT_02_getCPFSemRestricao() {

		initTest("CT02");
		get(configLocal.restricoes().concat(data.createSimulacao().getCpf()));
			validaStatusCode(response.getStatusCode());

	}

	@Test
	public void CT_03_postSimulacao() {

		initTest("CT03");
		post(configLocal.simulacoes(), data.createSimulacao());
			validaBody(getListFullByJsonPath(response), data.getSimulacao());
			validaStatusCode(response.getStatusCode());

	}

	@Test
	public void CT_04_putSimulacao() {

		initTest("CT04");
		put(configLocal.simulacoes().concat(data.getSimulacaoOnAttribute().getCpf()), data.createSimulacao());
			validaBody(getListFullByJsonPath(response), data.getSimulacao());
			validaStatusCode(response.getStatusCode());

	}

	@Test
	public void CT_05_getSimulacao() {

		initTest("CT05");
		get(configLocal.simulacoes());
			validaList(response);
			validaStatusCode(response.getStatusCode());

	}

	@Test
	public void CT_06_deleteSimulacao() {

		initTest("CT06");
		String id = data.getSimulacaoOnAttribute().getId();
		System.out.println("olha eu aqui>>>>>"+id);

		delete(configLocal.simulacoes().concat(id));
			validaStatusCode(response.getStatusCode());
		get(configLocal.simulacoes()); // -> usado para buscar todos os registro para valida o delete
			validaDelete(response, id);

	}

}
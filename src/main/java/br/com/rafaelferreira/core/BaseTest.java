package br.com.rafaelferreira.core;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.lessThan;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import br.com.rafaelferreira.config.Configuration;
import br.com.rafaelferreira.config.ConfigurationManager;
import br.com.rafaelferreira.data.DataFactory;
import br.com.rafaelferreira.endpoint.SimulacaoCreditoEndpoint;
import br.com.rafaelferreira.util.Utilities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {

	static Configuration configuration = ConfigurationManager.getConfiguration();

	protected Response response;

	@BeforeClass
	public void setup() {

		baseURI = SimulacaoCreditoEndpoint.APP_URL_BASE.getUrl();
		port = configuration.portHttp();
		basePath = SimulacaoCreditoEndpoint.APP_BASE_PATH.getUrl();

		requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).log(LogDetail.ALL).build();

		responseSpecification = new ResponseSpecBuilder().log(LogDetail.ALL)
				.expectResponseTime(lessThan(configuration.timeout())).build();

		enableLoggingOfRequestAndResponseIfValidationFails();

	}

	public Response get(String resources) {

		return response = given().when().get(resources);
	}

	public Response post(String resources, Object object) {

		return response = given().body(object).when().post(resources);

	}

	public Response put(String resources, Object object) {

		return response = given().body(object).when().put(resources);

	}

	public Response delete(String resources) {

		return response = given().when().delete(resources);

	}

}

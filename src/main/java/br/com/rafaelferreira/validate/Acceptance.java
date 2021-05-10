package br.com.rafaelferreira.validate;

import static br.com.rafaelferreira.util.Utilities.getInt;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class Acceptance {

	private static JSONObject jsonObject;

	public Acceptance(JSONObject jsonObject) {

		Acceptance.jsonObject = jsonObject;
	}

	public static void validaBodyAlert(String genericValue, String getBody) {

		try {

			assertEquals(getBody, String.format((String)jsonObject.get("message"), genericValue));

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

	}

	public static void validaBody(Object actual, Object expected) {

		try {

			assertEquals(actual, expected);

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}

	}

	public static void validaStatusCode(int statusLine) {

		try {

			assertEquals(statusLine, getInt(jsonObject.get("statusCode")));

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	public static void validaList(Response response) {

		try {

			response.then().body("$", hasSize(greaterThan(0)))
					.body("findAll { it.valor < 1000 && it.valor > 40000 }", hasSize(0))
					.body("findAll { it.parcelas < 2 && it.parcelas > 48 }", hasSize(0));

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	public static void validaDelete(Response response, String id) {

		try {

			response.then().body("findAll { it.id == " + id + "}", hasSize(0));

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

}
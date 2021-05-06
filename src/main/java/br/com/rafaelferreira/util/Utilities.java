package br.com.rafaelferreira.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Utilities {

	// criando um objeto json que vai receber os dados do arquivo json
	JSONObject jsonDataObject;

	public Utilities() {

	}

	public void getDataFile(String fileName) {

		InputStream inputStream = getClass().getResourceAsStream("/" + fileName);
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(inputStream));

		// criando um parses para utilizamos no momento da leitura do arquivo json
		JSONParser parser = new JSONParser();

		try {
			// inserindo o arquivo json em um objeto
			Object jsonFileObject = parser.parse(buffRead);

			// convertendo o objeto com o arquivo json para o formato de objeto json
			jsonDataObject = (JSONObject) jsonFileObject;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		// garantindo que o objeto json não está nulo
		assert jsonDataObject != null;

	}

	public JSONObject getDataGroup(String dataGroup) {
		// retornando o objeto json, filtrando pelo grupo de dados desejado
		return (JSONObject) jsonDataObject.get(dataGroup);
	}

	public static int getInt(Object object) {

		String string = (String) object;
		int number = Integer.parseInt(string);
		return number;

	}

	

}

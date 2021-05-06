package br.com.rafaelferreira.endpoint;

public enum SimulacaoCreditoEndpoint implements Endpoint {

	APP_URL_BASE("http://localhost:8888"), 
	APP_BASE_PATH("/api/v1");

	private String url;

	private SimulacaoCreditoEndpoint(String url) {

		this.url = url;
	}

	public String getUrl(Object... params) {

		return String.format(url, params);
	}

}

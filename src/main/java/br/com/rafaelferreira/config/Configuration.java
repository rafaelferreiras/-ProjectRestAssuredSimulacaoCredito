package br.com.rafaelferreira.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({ "classpath:general.properties", "classpath:local.properties" })
public interface Configuration extends Config {

	@Key("portHttp")
	int portHttp();

	@Key("timeout")
	long timeout();

	@Key("restricoes")
	String restricoes();

	@Key("simulacoes")
	String simulacoes();

	@Key("ValueMax")
	int ValueMax();

	@Key("ValueMin")
	int ValueMin();

	@Key("ValueMaxParcela")
	int ValueMaxParcela();

	@Key("ValueMinParcela")
	int ValueMinParcela();

	@Key("CPFComRestricoes")
	String[] CPFRestricoes();

}

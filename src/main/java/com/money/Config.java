package com.money;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Config extends Configuration {
	@NotEmpty
	private String version;

	@JsonProperty
	public String getVersion() {
		return version;
	}

	@JsonProperty
	public void setVersion(String version) {
		this.version = version;
	}
}

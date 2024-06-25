package com.example.controller_practice;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SecurityDetail {

	@JacksonXmlProperty(localName = "etfOrderId")
	public String etfOrderId;
	
	@JacksonXmlProperty(localName = "securityName")
	public String securityName;
	
	@JacksonXmlProperty(localName = "team")
	public String team;
	
}

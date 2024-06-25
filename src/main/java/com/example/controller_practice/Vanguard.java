package com.example.controller_practice;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Vanguard {

	@JacksonXmlProperty(localName = "etfOrderId")
	public String etfOrderId;
	
	@JacksonXmlProperty(localName = "secName")
	public String secName;
	
	@JacksonXmlProperty(localName = "teamName")
	public String teamName;
	
	@JacksonXmlProperty(localName = "transactionId")
	public String transactionId;
	
	@JacksonXmlProperty(localName = "transactionDate")
	public String transactionDate;
	    
}

package com.example.controller_practice;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class TransactionDetail {

	@JacksonXmlProperty(localName = "etfOrderId")
	public String etfOrderId;
	
	@JacksonXmlProperty(localName = "transactionId")
	public String transactionId;
	
	@JacksonXmlProperty(localName = "transactionDate")
	public String transactionDate;
	
}

package com.example.controller_practice;

import java.util.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class JPMC {

	@JacksonXmlProperty(localName = "fileName")
	public String fileName;
	
	@JacksonXmlProperty(localName = "fileFormat")
	public String fileFormat;
	
	@JacksonXmlProperty(localName = "securityDetails")
	public ArrayList<SecurityDetail> securityDetails;
	
	@JacksonXmlProperty(localName = "transactionDetails")
	public ArrayList<TransactionDetail> transactionDetails;
	
}

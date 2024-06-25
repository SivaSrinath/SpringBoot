package com.example.controller_practice;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Vanguard_Root {

	@JsonProperty("Vanguard")
	@JacksonXmlProperty(localName = "Vanguard")
	@JacksonXmlElementWrapper(localName = "Vanguard")
	public ArrayList<Vanguard> vanguard;

}

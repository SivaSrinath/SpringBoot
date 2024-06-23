package com.example.controller_practice;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Vanguard_Root {

	@JsonProperty("Vanguard")
	public ArrayList<Vanguard> vanguard;

}

package com.example.controller_practice;

import java.util.*;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class JPMC {

	public String fileName;
	public String fileFormat;
	public ArrayList<SecurityDetail> securityDetails;
	public ArrayList<TransactionDetail> transactionDetails;
	
}

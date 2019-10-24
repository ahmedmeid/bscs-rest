package com.goodjob.bscs.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Money {

	String currency;
	Double amount;
}

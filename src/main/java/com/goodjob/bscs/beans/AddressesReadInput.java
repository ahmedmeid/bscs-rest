package com.goodjob.bscs.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class AddressesReadInput {
	

	@SerializedName("CS_ID")
	@Expose
	Long csId;
	
	@SerializedName("CS_ID_PUB")
	@Expose
	String csIdPub;

}

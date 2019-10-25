package com.goodjob.bscs.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Addresses {
	
	@SerializedName("LIST_OF_ALL_ADDRESSES")
	@Expose
	Address[] listOfAllAddresses;
	
	@SerializedName("CS_ID")
	@Expose
	Long csId;
	
	@SerializedName("CS_ID_PUB")
	@Expose
	String csIdPub;

}

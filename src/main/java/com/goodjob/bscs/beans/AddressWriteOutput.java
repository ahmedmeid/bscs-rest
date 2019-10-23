package com.goodjob.bscs.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class AddressWriteOutput {
	
	@SerializedName("ADR_SEQ")
	@Expose
	Long adrSeq;

}

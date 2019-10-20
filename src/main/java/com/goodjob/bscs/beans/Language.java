package com.goodjob.bscs.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {
	
	@SerializedName("LNG_CODE")
	@Expose
	Long id;
	
	@SerializedName("LNG_SHDES")
	@Expose
	String isoCode;
	
	@SerializedName("LNG_DES")
	@Expose
	String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

}

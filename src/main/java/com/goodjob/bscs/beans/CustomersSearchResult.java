package com.goodjob.bscs.beans;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CustomersSearchResult {

	@SerializedName("EXTERNAL_CUSTOMER_SET_ID")
	@Expose
	String externalCustomerSetId;

	@SerializedName("CS_CODE")
	@Expose
	String csCode;

	@SerializedName("BU_ID")
	@Expose
	Long buId;

	@SerializedName("PARTY_TYPE")
	@Expose
	String partyType;

	@SerializedName("CS_DEALERID")
	@Expose
	Long csDealerid;

	@SerializedName("ADR_LNAME")
	@Expose
	String adrLname;

	@SerializedName("ADR_FNAME")
	@Expose
	String adrFname;

	@SerializedName("ADR_NAME")
	@Expose
	String adrName;

	@SerializedName("ADR_STREET")
	@Expose
	String adrStreet;

	@SerializedName("ADR_STREETNO")
	@Expose
	String adrStreetno;

	@SerializedName("ADR_ZIP")
	@Expose
	String adrZip;

	@SerializedName("ADR_CITY")
	@Expose
	String adrCity;

	@SerializedName("ADR_BIRTHDT")
	@Expose
	Date adrBirthdt;

	@SerializedName("CS_STATUS")
	@Expose
	String csStatus;

	@SerializedName("CS_LEVEL_CODE")
	@Expose
	String csLevelCode;

	@SerializedName("PAYMENT_RESP")
	@Expose
	String paymentResp;

	@SerializedName("CS_HIGH")
	@Expose
	Long csIdHigh;

	@SerializedName("CS_CONTR_RESP")
	@Expose
	String csContrResp;

	@SerializedName("CS_ID")
	@Expose
	Long csId;

	@SerializedName("CS_ID_PUB")
	@Expose
	String csIdPub;

}

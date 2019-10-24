package com.goodjob.bscs.beans;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Customer {

	@SerializedName("TB_AMOUNT")
	@Expose
	Money tbAmount;

	@SerializedName("CREATED_BY_USER")
	@Expose
	String createdByUser;

	@SerializedName("TB_MODE")
	@Expose
	String tbMode;

	@SerializedName("TB_PURPOSE")
	@Expose
	String tbPurpose;

	@SerializedName("IS_INDIVIDUAL_OVERDISC_DISABLED")
	@Expose
	Boolean isIndividualOverdiscDisabled;

	@SerializedName("FAMILY_ID")
	@Expose
	Long familyId;

	@SerializedName("LIST_OF_ASSIGNMENTS")
	@Expose
	ListOfAssignments[] listOfAssignments;

	@SerializedName("CS_ID")
	@Expose
	Long csId;

	@SerializedName("CS_ID_PUB")
	@Expose
	String csIdPub;

	@SerializedName("CS_CODE")
	@Expose
	String csCode;

	@SerializedName("CS_STATUS")
	@Expose
	String csStatus;

	@SerializedName("CS_STATUS_DATE")
	@Expose
	Date csStatusDate;

	@SerializedName("CS_ACTIVATION_DATE")
	@Expose
	Date csActivationDate;

	@SerializedName("CS_ID_HIGH")
	@Expose
	Long csIdHigh;

	@SerializedName("CS_ID_HIGH_PUB")
	@Expose
	String csIdHighPub;

	@SerializedName("CS_LEVEL_CODE")
	@Expose
	String csLevelCode;

	@SerializedName("PAYMENT_RESP")
	@Expose
	Boolean paymentResp;

	@SerializedName("PRG_CODE")
	@Expose
	String prgCode;

	@SerializedName("RPCODE")
	@Expose
	Long rpcode;

	@SerializedName("RPCODE_PUB")
	@Expose
	String rpcodePub;

	@SerializedName("TRADE_CODE")
	@Expose
	String tradeCode;

	@SerializedName("AREA_CODE")
	@Expose
	Long areaCode;

	@SerializedName("COST_ID")
	@Expose
	Long costId;

	@SerializedName("COST_CODE_PUB")
	@Expose
	String costCodePub;

	@SerializedName("CS_PASSWORD")
	@Expose
	String csPassword;

	@SerializedName("RS_CODE")
	@Expose
	Long rsCode;

	@SerializedName("WP_CODE")
	@Expose
	Long wpCode;

	@SerializedName("SR_CODE")
	@Expose
	Long srCode;

	@SerializedName("CS_REMARK1")
	@Expose
	String csRemark1;

	@SerializedName("CS_REMARK2")
	@Expose
	String csRemark2;

	@SerializedName("CS_BILL_INFORMATION")
	@Expose
	Boolean csBillInformation;

	@SerializedName("EXPECT_PAY_CURRENCY_ID")
	@Expose
	Long expectPayCurrencyId;

	@SerializedName("EXPECT_PAY_CURRENCY_ID_PUB")
	@Expose
	String expectPayCurrencyIdPub;

	@SerializedName("CS_CONVRATETYPE_PAYMENT")
	@Expose
	Long csConvratetypePayment;

	@SerializedName("CS_CONVRATETYPE_PAYMENT_PUB")
	@Expose
	String csConvratetypePaymentPub;

	@SerializedName("REFUND_CURRENCY_ID")
	@Expose
	Long refundCurrencyId;

	@SerializedName("REFUND_CURRENCY_ID_PUB")
	@Expose
	String refundCurrencyIdPub;

	@SerializedName("CS_CONVRATETYPE_REFUND")
	@Expose
	Long csConvratetypeRefund;

	@SerializedName("CS_CONVRATETYPE_REFUND_PUB")
	@Expose
	String csConvratetypeRefundPub;

	@SerializedName("CS_CRCHECK_AGREED")
	@Expose
	Boolean csCrcheckAgreed;

	@SerializedName("CUSTCAT_CODE")
	@Expose
	Long custcatCode;

	@SerializedName("CUSTCAT_CODE_PUB")
	@Expose
	String custcatCodePub;

	@SerializedName("CS_JURISDICTION_ID")
	@Expose
	Long csJurisdictionId;

	@SerializedName("CS_JURISDICTION_CODE")
	@Expose
	String csJurisdictionCode;

	@SerializedName("CS_INCORPORATED_IND")
	@Expose
	Boolean csIncorporatedInd;

	@SerializedName("CS_BILLCYCLE")
	@Expose
	String csBillcycle;

	@SerializedName("CS_LIMIT_TR1")
	@Expose
	Long csLimitTr1;

	@SerializedName("CS_LIMIT_TR1_PUB")
	@Expose
	String csLimitTr1Pub;

	@SerializedName("CS_LIMIT_TR2")
	@Expose
	Long csLimitTr2;

	@SerializedName("CS_LIMIT_TR2_PUB")
	@Expose
	String csLimitTr2Pub;

	@SerializedName("CS_LIMIT_TR3")
	@Expose
	Long csLimitTr3;

	@SerializedName("CS_LIMIT_TR3_PUB")
	@Expose
	String csLimitTr3Pub;

	@SerializedName("CS_CLIMIT")
	@Expose
	Money csClimit;

	@SerializedName("CS_CONTRESP")
	@Expose
	Boolean csContresp;

	@SerializedName("CS_LAST_BC_DATE")
	@Expose
	Date csLastBcDate;

	@SerializedName("CS_DEPOSIT")
	@Expose
	Money csDeposit;

	@SerializedName("CS_CREDITSCORE")
	@Expose
	String csCreditscore;

	@SerializedName("CS_CSCREDIT_STATUS")
	@Expose
	String csCscreditStatus;

	@SerializedName("CS_CSCREDIT_REMARK")
	@Expose
	String csCscreditRemark;

	@SerializedName("CS_CSCREDIT_DATE")
	@Expose
	Date csCscreditDate;

	@SerializedName("CS_DUNNING")
	@Expose
	Boolean csDunning;

	@SerializedName("CS_PREPAYMENT")
	@Expose
	Boolean csPrepayment;

	@SerializedName("CS_COLLECTOR")
	@Expose
	String csCollector;

	@SerializedName("CS_FC_ID")
	@Expose
	Long csFcId;

	@SerializedName("CS_FC_ID_PUB")
	@Expose
	String csFcIdPub;

	@SerializedName("CS_CSCURBALANCE")
	@Expose
	Money csCscurbalance;

	@SerializedName("CS_PREVBALANCE")
	@Expose
	Money csPrevbalance;

	@SerializedName("CS_UNBILLED_AMOUNT")
	@Expose
	Money csUnbilledAmount;

	@SerializedName("CS_PAYBEHAVIOUR")
	@Expose
	String csPaybehaviour;

	@SerializedName("CS_NO_BOUNCE_PAY")
	@Expose
	Integer csNoBouncePay;

	@SerializedName("CS_DEALERID")
	@Expose
	Long csDealerid;

	@SerializedName("CS_DEALERID_PUB")
	@Expose
	String csDealeridPub;

	@SerializedName("CS_INIT_PREPAID_CONTR_OWNER")
	@Expose
	Boolean csInitPrepaidContrOwner;

	@SerializedName("CS_CREATION_DATE")
	@Expose
	Date csCreationDate;

	@SerializedName("CS_DEACTIVATION_DATE")
	@Expose
	Date csDeactivationDate;

	@SerializedName("CS_SUSPENSION_DATE")
	@Expose
	Date csSuspensionDate;

	@SerializedName("CS_REACTIVATION_DATE")
	@Expose
	Date csReactivationDate;

	@SerializedName("LAST_MODIFICATION_USER")
	@Expose
	String lastModificationUser;

	@SerializedName("PAYMENT_RESP_ID")
	@Expose
	Long paymentRespId;

	@SerializedName("CS_PAYMNT_RESP_CODE")
	@Expose
	String csPaymntRespCode;

	@SerializedName("PARTY_ROLE_ASSIGNMENTS")
	@Expose
	PartyRoleAssignments[] partyRoleAssignments;

	@SerializedName("PARTY_TYPE")
	@Expose
	String partyType;

	@SerializedName("COLL_IND")
	@Expose
	Boolean collInd;

	@SerializedName("MARKED_FOR_RERATING")
	@Expose
	Boolean markedForRerating;

	@SerializedName("EXTERNAL_CUSTOMER_ID")
	@Expose
	String externalCustomerId;

	@SerializedName("EXTERNAL_CUSTOMER_SET_ID")
	@Expose
	String externalCustomerSetId;

}

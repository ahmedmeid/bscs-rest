package com.goodjob.bscs.beans;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CustomersSearchDTO {

	@SerializedName("SEARCH_IS_COMPLETE")
	@Expose
	Boolean searchIsComplete;

	@SerializedName("SEARCH_RESULT")
	@Expose
	List<CustomersSearchResult> searchResults;

}

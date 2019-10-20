package com.goodjob.bscs.beans;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguagesReadDTO {
	
	@SerializedName("LNG_CODE_DEF")
	@Expose
	Long defaultLanguage;
	
	@SerializedName("LIST_OF_LANGUAGES")
	@Expose
	List<Language> languages;

	public Long getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(Long defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	

}

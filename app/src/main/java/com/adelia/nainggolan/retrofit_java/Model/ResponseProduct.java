package com.adelia.nainggolan.retrofit_java.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseProduct{

	@SerializedName("person")
	private List<com.adelia.nainggolan.retrofit_java.Model.PersonItem> person;

	@SerializedName("error")
	private boolean error;

	@SerializedName("status")
	private int status;

	public void setPerson(List<com.adelia.nainggolan.retrofit_java.Model.PersonItem> person){
		this.person = person;
	}

	public List<com.adelia.nainggolan.retrofit_java.Model.PersonItem> getPerson(){
		return person;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}
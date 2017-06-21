package com.cooksys.friendlr.dto;

public class PetWithIdDto {
	private Integer id;
	private String petName;
	private String petType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

}

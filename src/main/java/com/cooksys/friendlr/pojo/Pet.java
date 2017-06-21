package com.cooksys.friendlr.pojo;

import java.util.ArrayList;
import java.util.List;

public class Pet {
	private Integer id;
	private String petName;
	private String petType;
	private List<Integer> owners = new ArrayList<>();

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public List<Integer> getOwners() {
		return owners;
	}

	public void setOwners(List<Integer> owners) {
		this.owners = owners;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

}

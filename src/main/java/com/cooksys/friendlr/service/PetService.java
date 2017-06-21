package com.cooksys.friendlr.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cooksys.friendlr.pojo.Pet;

@Service
public class PetService {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	private List<Pet> allPets = new ArrayList<>();
	
	public List<Pet> getPets() {
		return allPets;
	}
	
	public Pet getPet(Integer pID) {
		return allPets.get(pID);
	}
	
	public Pet createPet(Pet pet) {
		pet.setId(allPets.size());
		allPets.add(pet);
		return pet;
	}
	
	public List<Integer> getOwner(Integer petId) {
		return allPets.get(petId).getOwners();
	}
	
	public Pet addOwner(Integer petId, Integer owner) {
		allPets.get(petId).getOwners().add(owner);
		return allPets.get(petId);
	}
	
	
}

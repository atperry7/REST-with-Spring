package com.cooksys.friendlr.mapper;

import org.mapstruct.Mapper;

import com.cooksys.friendlr.dto.PetWithIdDto;
import com.cooksys.friendlr.dto.PetWithOutId;
import com.cooksys.friendlr.pojo.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

	PetWithOutId toPetWithOutId(Pet p);

	Pet toPet(PetWithOutId dto);

	PetWithIdDto toPetWithId(Pet p);

	Pet toPet(PetWithIdDto dto);

}

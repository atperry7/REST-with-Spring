package com.cooksys.friendlr.mapper;

import org.mapstruct.Mapper;

import com.cooksys.friendlr.dto.PetWithIdDto;
import com.cooksys.friendlr.dto.PetWithOutIdDto;
import com.cooksys.friendlr.pojo.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {

	PetWithOutIdDto toPetWithOutId(Pet p);

	Pet toPet(PetWithOutIdDto dto);

	PetWithIdDto toPetWithId(Pet p);

	Pet toPet(PetWithIdDto dto);

}

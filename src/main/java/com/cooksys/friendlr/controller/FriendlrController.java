package com.cooksys.friendlr.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.friendlr.dto.PersonSansIdDto;
import com.cooksys.friendlr.dto.PersonWithIdDto;
import com.cooksys.friendlr.dto.PetWithIdDto;
import com.cooksys.friendlr.dto.PetWithOutIdDto;
import com.cooksys.friendlr.mapper.PersonMapper;
import com.cooksys.friendlr.mapper.PetMapper;
import com.cooksys.friendlr.pojo.Person;
import com.cooksys.friendlr.pojo.Pet;
import com.cooksys.friendlr.service.FriendlrService;
import com.cooksys.friendlr.service.PetService;

@RestController
@RequestMapping("friendlr")
public class FriendlrController {

	private FriendlrService service;
	private PersonMapper mapper;
	private PetService petService;
	private PetMapper petMapper;

	public FriendlrController(FriendlrService service, PersonMapper mapper, PetService petService, PetMapper petMapper) {
		this.service = service;	
		this.mapper = mapper;
		this.petService = petService;
		this.petMapper = petMapper;
	}
	
	@GetMapping("person")
	public List<PersonWithIdDto> getAll() {
		return service.getAllPersons().stream().map(person -> mapper.toPersonWithId(person)).collect(Collectors.toList());
	}
	
	@GetMapping("pet")
	public List<PetWithIdDto> getAllPets() {
		return petService.getPets().stream().map(pet -> petMapper.toPetWithId(pet)).collect(Collectors.toList());
	}
	
	@GetMapping("person/{id}")
	public PersonSansIdDto get(@PathVariable Integer id) {
		return mapper.toPersonSansId(service.getPerson(id));
	}
	
	@GetMapping("pet/{id}")
	public PetWithOutIdDto getPet(@PathVariable Integer id) {
		return petMapper.toPetWithOutId(petService.getPet(id));
	}
	
	@PostMapping("person")
	public Person post(@RequestBody PersonSansIdDto dto, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return service.createPerson(mapper.toPerson(dto));
	}
	
	@PostMapping("pet")
	public Pet postPet(@RequestBody PetWithOutIdDto dto, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return petService.createPet(petMapper.toPet(dto));
	}
	
	@PostMapping("person/{personId}/friends/{friendId}")
	public PersonWithIdDto post(@PathVariable Integer personId, @PathVariable Integer friendId, HttpServletResponse response) {
		return mapper.toPersonWithId(service.addFriend(personId, friendId));
	}
	
	@PostMapping("person/{personId}/pet/{petId}")
	public PersonWithIdDto postPersonPet(@PathVariable Integer personId, @PathVariable Integer petId, HttpServletResponse response) {
		petService.addOwner(petId, personId);
		return mapper.toPersonWithId(service.addPet(personId, petId));
	}
	
	@PostMapping("pet/{petId}/owner/{ownerId}")
	public PetWithIdDto postPet(@PathVariable Integer petId, @PathVariable Integer ownerId, HttpServletResponse response) {
		service.addPet(ownerId, petId);
		return petMapper.toPetWithId(petService.addOwner(petId, ownerId));
	}
	
	@GetMapping("person/{personId}/pets")
	public List<PetWithIdDto> getPets(@PathVariable Integer personId) {
		return service.getPets(personId).stream().map(petId -> petMapper.toPetWithId(petService.getPet(petId))).collect(Collectors.toList());
	}

	@GetMapping("person/{personId}/friends")
	public List<PersonWithIdDto> getFriends(@PathVariable Integer personId) {
		return service.getFriends(personId).stream().map(person -> mapper.toPersonWithId(person)).collect(Collectors.toList());
	}
	
	@GetMapping("pet/{petId}/owners")
	public List<PersonSansIdDto> getOwners(@PathVariable Integer petId){
		return petService.getOwner(petId).stream().map(person -> mapper.toPersonSansId(service.getPerson(person))).collect(Collectors.toList());
	}
}

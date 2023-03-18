package backend.pet.service;

import java.util.List;

import backend.pet.model.Pet;

public interface PetService {

    List<Pet> getAllPets();

    Pet createPet(Pet pet);

    Pet getPetById(Integer petId);

    Pet updatePet(Integer petId, Pet pet);

    String deletePet(Integer petId);

    
}

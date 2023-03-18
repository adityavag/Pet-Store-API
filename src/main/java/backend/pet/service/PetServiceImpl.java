package backend.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.pet.entity.PetEntity;
import backend.pet.model.Pet;
import backend.pet.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{
    
    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        List<PetEntity> petEntities = petRepository.findAll();
        final List<Pet> pets = petEntities.stream().map(pet->new Pet(
            pet.getId(),
            pet.getName(),
            pet.getOwner(),
            pet.getAge(),
            pet.getType(),
            pet.getGender()
        )).collect(Collectors.toList());
        return pets;
    }

    @Override
    public Pet createPet(Pet pet) {
        PetEntity petEntity = new PetEntity();
        BeanUtils.copyProperties(pet, petEntity);
        petRepository.save(petEntity);
        return pet;
    }
}

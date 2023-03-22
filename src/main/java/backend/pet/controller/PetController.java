package backend.pet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.pet.model.Pet;
import backend.pet.service.PetService;
import jakarta.validation.Valid;

@RestController
public class PetController {

    @Autowired
    private PetService petService;
    
    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }
    @PostMapping("/pets")
    public Pet createPet(@Valid @RequestBody Pet pet){
        return petService.createPet(pet);
    }

    @GetMapping("/pets/{id}")
    public Pet getPetById(@PathVariable("id") Integer petId){
        return petService.getPetById(petId);
    }

    @PutMapping("/pets/{id}")
    public Pet updatePet(@Valid @PathVariable("id") Integer petId, @RequestBody Pet pet){
        return petService.updatePet(petId,pet);
    }

    @DeleteMapping("/pets/{id}")
    public String deletePet(@PathVariable("id") Integer petId){
        return petService.deletePet(petId);
    }
}

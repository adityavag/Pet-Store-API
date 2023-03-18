package backend.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.pet.model.Pet;
import backend.pet.service.PetService;

@RestController
public class PetController {

    @Autowired
    private PetService petService;
    
    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }
    @PostMapping("/pets")
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }

}

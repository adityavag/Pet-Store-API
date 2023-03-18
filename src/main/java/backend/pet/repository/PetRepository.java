package backend.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.pet.entity.PetEntity;

public interface PetRepository extends JpaRepository<PetEntity, Integer>{
    
}

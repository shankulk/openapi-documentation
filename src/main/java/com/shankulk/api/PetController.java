package com.shankulk.api;

import com.shankulk.dto.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {

    @Override
    public ResponseEntity<Pet> addPet(final Pet pet) {
        return ResponseEntity.ok(pet);
    }


}

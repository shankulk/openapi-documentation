package com.shankulk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shankulk.dto.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PetController.class)
class PetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testGetPets() throws Exception {
        final Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("test pet");
        pet.setStatus(Pet.StatusEnum.AVAILABLE);

        final ObjectMapper objectMapper = new ObjectMapper();
        final String body = objectMapper.writeValueAsString(pet);

        final MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.post("/pet").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk())
                .andReturn();

        final Pet returnedPet = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Pet.class);
        Assertions.assertThat(returnedPet.getId()).isEqualTo(pet.getId());
    }
}

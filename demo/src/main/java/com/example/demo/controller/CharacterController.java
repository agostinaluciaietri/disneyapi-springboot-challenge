package com.example.demo.controller;

import com.example.demo.model.Character;
import com.example.demo.domain.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping()
    public Iterable<Character> get() {
        return service.getCharacters();
    }

    @GetMapping("/{id}")
    public Optional<Character> get(@PathVariable("id") Long pk_characterID) {
        return service.getCharacterById(pk_characterID);
    }

    @GetMapping("/name/{name}")
    public Optional<Character> get(@PathVariable("name") String name) {
        return service.getCharacterByName(name);
    }

    @PostMapping//(consumes = {"application/json"})
    public String post(@RequestBody Character character) {
        Character c = service.save(character);

        return "Character saved successfully: " + c.getPk_characterID();
    }
}

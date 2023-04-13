package com.example.demo.domain;

import com.example.demo.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository repo;

    public Iterable<Character> getCharacters() {
        return repo.findAll();
    }

    public Optional<Character> getCharacterById(Long pk_characterID) {
        return repo.findById(pk_characterID);
    }

    public Optional<Character> getCharacterByName(String name) {
        return repo.findByName(name);
    }

    public List<Character> getCharactersFake() {
        List<Character> characters = new ArrayList<>();

        characters.add(new Character(1L, "mickey.jpg", "Mickey Mouse", 94, 10,
                "Before Walt Disney created Mickey Mouse, he made Oswald the " +
                        "Lucky Rabbit. But in a dispute with his business partner at " +
                        "Universal, Disney lost the rights to Oswald. The loss of his" +
                        " first character inspired the birth of the Mouse. If you look " +
                        "at the two characters, you can see the resemblance"));

        characters.add(new Character(2L, "pluto.jpg", "Pluto", 85, 15,
                "Pluto first appeared as a nameless bloodhound tracking the escaped" +
                        " convict Mickey in the film The Chain Gang, which released on August" +
                        " 6, 1930. On October 23 of that same year, The Picnic was " +
                        "released. Pluto was Minnie's dog and was named Rover. The Moose Hunt," +
                        " which came out on May 3, 1931, Pluto appeared as Mickey's pet, " +
                        "and was given the name 'Pluto'"));

        characters.add(new Character(3L, "minnie.jpg", "Minnie Mouse", 94, 10,
                "The first film featuring her was The Gallopin' Gaucho. The" +
                        " film was the second of their series to be produced, but the" +
                        " third to be released, and was released on December 30, 1928." +
                        " We find Minnie employed at the Cantina Argentina, a bar and" +
                        " restaurant established in the Pampas of Argentina. She " +
                        "performs the Tango for Mickey the gaucho and Black Pete the" +
                        " outlaw. Both flirt with her but the latter intends to " +
                        "abduct her while the former obliges in saving the Damsel " +
                        "in Distress from the villain"));

        return characters;
    }

    public Character save(Character character) {
        return repo.save(character);
    }
}

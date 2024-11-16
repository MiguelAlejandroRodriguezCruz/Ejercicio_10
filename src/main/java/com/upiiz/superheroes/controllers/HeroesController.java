package com.upiiz.superheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.services.HeroeService;

@RestController
@RequestMapping("api/v1/heroes")
public class HeroesController {

    @Autowired
    private HeroeService heroeService;

    @GetMapping
    public ResponseEntity<List<HeroeEntity>> getHeroes() {
        return ResponseEntity.ok(heroeService.getAllHeroes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroeEntity> getHeroe(@RequestParam Long id) {
        return ResponseEntity.ok(heroeService.getHeroeById(id));
    }

    @PostMapping
    public ResponseEntity<HeroeEntity> createHeroe(@RequestBody HeroeEntity heroeEntity) {
        return ResponseEntity.ok(heroeService.creteHeroe(heroeEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroeEntity> updateHeroe(@RequestBody HeroeEntity heroeEntity, @RequestParam Long id) {
        heroeEntity.setId(id);
        return ResponseEntity.ok(heroeService.updateHeroe(heroeEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HeroeEntity> deleteHeroe(@RequestParam Long id) {
        heroeService.deleteHeroe(id);
        return ResponseEntity.noContent().build();
    }
}

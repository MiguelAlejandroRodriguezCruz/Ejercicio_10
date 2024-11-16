package com.upiiz.superheroes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.repositories.HeroeRepository;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    public List<HeroeEntity> getAllHeroes() {
        return heroeRepository.findAll();
    }

    public HeroeEntity getHeroeById(Long id) {
        return heroeRepository.findById(id).orElse(null);
    }

    public HeroeEntity creteHeroe(HeroeEntity heroe) {
        return heroeRepository.save(heroe);
    }

    public HeroeEntity updateHeroe(HeroeEntity heroe) {
        return heroeRepository.save(heroe);
    }

    public void deleteHeroe(Long id) {
        heroeRepository.deleteById(id);
    }
}

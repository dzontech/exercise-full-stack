package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vesti")
@CrossOrigin
public class VestControler {

    @Autowired
    private VestRepository repository;

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<Iterable<Vest>> getAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Vest> getById(@PathVariable long id) {
        Optional<Vest> v = repository.findById(id);
        if(v.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(v.get());
    }

    @PutMapping(value = "/addComment/{vest_id}", consumes = {"application/json"})
    public ResponseEntity<Void> addComment(@PathVariable long vest_id, @RequestBody Komentar komentar){
        Optional<Vest> v = repository.findById(vest_id);
        if(v.isEmpty())
            return ResponseEntity.notFound().build();
        else{
            Vest vest = v.get();
            vest.getKomentari().add(komentar);
            repository.save(vest);
            return ResponseEntity.ok().build();
        }
    }
}

package com.example.userBorrowBook.controller;

import com.example.userBorrowBook.model.Library;
import com.example.userBorrowBook.model.LibraryBasicInfo;
import com.example.userBorrowBook.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibraryById(@PathVariable String id) {
        return libraryRepository.findById(id);
    }

    @GetMapping("/basic")
    public List<LibraryBasicInfo> getAllLibrariesBasicInfo() {
        return libraryRepository.findAllProjectedBy();
    }

    @GetMapping("/paged")
    public Page<Library> getAllLibrariesPaged(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryRepository.save(library);
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable String id, @RequestBody Library library) {
        library.setId(id);
        return libraryRepository.save(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable String id) {
        libraryRepository.deleteById(id);
    }
}

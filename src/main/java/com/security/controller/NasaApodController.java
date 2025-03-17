package com.security.controller;

import com.security.dto.NasaApodDTO;
import com.security.service.NasaApodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/apod")
public class NasaApodController {

    private final NasaApodService nasaApodService;

    public NasaApodController(NasaApodService nasaApodService) {
        this.nasaApodService = nasaApodService;
    }

    @GetMapping
    public List<NasaApodDTO> getApods() {
        return nasaApodService.getAllNasaApod();
    }

    @PostMapping("/add")
    public String add(@RequestBody NasaApodDTO apod) {
        return nasaApodService.add(apod);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NasaApodDTO> getApodById(@PathVariable Long id) {
        NasaApodDTO apodDTO = nasaApodService.getNasaApodById(id);
        return ResponseEntity.ok(apodDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody NasaApodDTO nasaApod) {
        String response = nasaApodService.update(nasaApod);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String response = nasaApodService.delete(id);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

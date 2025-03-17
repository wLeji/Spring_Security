package com.security.service;

import com.security.dto.NasaApodDTO;
import com.security.entity.NasaApod;
import com.security.mapping.NasaApodMapping;
import com.security.repository.NasaApodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NasaApodService {

    private final NasaApodRepository nasaApodRepository;
    private final NasaApodMapping nasaApodMapping;

    public NasaApodDTO getNasaApodById(Long id) {
        NasaApod apod = nasaApodRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Nasa Apod found"));
        return nasaApodMapping.entityToDTO(apod);
    }

    public List<NasaApodDTO> getAllNasaApod() {
        Iterable<NasaApod> nasaApodList = nasaApodRepository.findAll();
        List<NasaApodDTO> apodDTOS = new ArrayList<>();
        for (NasaApod apod : nasaApodList) {
            apodDTOS.add(nasaApodMapping.entityToDTO(apod));
        }
        return apodDTOS;
    }

    public String add(NasaApodDTO apod) {
        NasaApod newApod = nasaApodMapping.dtoToEntity(apod);
        nasaApodRepository.save(newApod);
        return "Apod added successfully";
    }

    public String update(NasaApodDTO apod) {
        NasaApod existingApod = nasaApodRepository.findById(apod.getId())
                .orElseThrow(() -> new NoSuchElementException("No Nasa Apod found"));
        nasaApodMapping.updateEntityFromDTO(apod, existingApod);
        nasaApodRepository.save(existingApod);
        return "Apod updated successfully";
    }

    public String delete(Long id) {
        NasaApod apod = nasaApodRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Nasa Apod found"));
        nasaApodRepository.delete(apod);
        return "Apod deleted";
    }
}

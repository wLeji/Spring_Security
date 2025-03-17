package com.security.mapping;

import com.security.dto.NasaApodDTO;
import com.security.entity.NasaApod;
import org.springframework.stereotype.Component;

@Component
public class NasaApodMapping {

    public NasaApod dtoToEntity(NasaApodDTO dto) {
        return NasaApod.builder()
                .date(dto.date)
                .explanation(dto.explanation)
                .hdurl(dto.hdurl)
                .media_type(dto.media_type)
                .service_version(dto.service_version)
                .title(dto.title)
                .url(dto.url)
                .build();
    }

    public NasaApodDTO entityToDTO(NasaApod entity) {
        return NasaApodDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .explanation(entity.getExplanation())
                .hdurl(entity.getHdurl())
                .media_type(entity.getMedia_type())
                .service_version(entity.getService_version())
                .title(entity.getTitle())
                .url(entity.getUrl())
                .build();
    }

    public void updateEntityFromDTO(NasaApodDTO apodDTO, NasaApod nasaApod) {
        nasaApod.setDate(apodDTO.getDate());
        nasaApod.setExplanation(apodDTO.getExplanation());
        nasaApod.setHdurl(apodDTO.getHdurl());
        nasaApod.setMedia_type(apodDTO.getMedia_type());
        nasaApod.setService_version(apodDTO.getService_version());
        nasaApod.setTitle(apodDTO.getTitle());
        nasaApod.setUrl(apodDTO.getUrl());
    }
}

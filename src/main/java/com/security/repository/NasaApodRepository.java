package com.security.repository;

import com.security.entity.NasaApod;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface NasaApodRepository extends CrudRepository<NasaApod, Long> {
    @Transactional
    @Modifying
    @Query("""
            update NasaApod a set a.date = ?1, a.explanation = ?2, a.hdurl = ?3, a.media_type = ?4, a.service_version = ?5, a.title = ?6, a.url = ?7 where a.id = ?8""")
    void update(String date, String explanation, String hdurl, String media_type, String service_version, String title, String url, Long id);
}

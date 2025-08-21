package com.example.micros.companiescrud.repositories;

import com.example.micros.companiescrud.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {
}

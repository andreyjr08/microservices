package com.example.micros.companiescrud.services;

import com.example.micros.companiescrud.entities.Category;
import com.example.micros.companiescrud.entities.Company;
import com.example.micros.companiescrud.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;


    @Override
    public Company readByName(String name) {
        return this.companyRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Company not fount"));
    }

    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(webSite -> {
            if (Objects.isNull(webSite.getCategory())) {
                webSite.setCategory(Category.NONE);
            }
        });

        return this.companyRepository.save(company);
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not fount"));

        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationName(company.getFoundationName());
        companyToUpdate.setFounder(company.getFounder());

        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void detele(String name) {
        var companyToDelete = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not fount"));

        this.companyRepository.delete(companyToDelete);
    }
}

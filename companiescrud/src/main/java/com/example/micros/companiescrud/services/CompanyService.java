package com.example.micros.companiescrud.services;

import com.example.micros.companiescrud.entities.Company;

public interface CompanyService {

    Company readByName(String name);

    Company create(Company company);

    Company update(Company company, String name);

    void detele(String name);
}

package com.example.aestheticClinic.domain.repository;

import com.example.aestheticClinic.domain.entity.Packages;

import java.util.Optional;

public interface PackageRespository {
    Optional<Packages> findById(Long packageId);
}

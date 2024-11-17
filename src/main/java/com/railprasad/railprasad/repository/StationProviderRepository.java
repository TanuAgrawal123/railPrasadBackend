package com.railprasad.railprasad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railprasad.railprasad.model.StationProvider;

public interface StationProviderRepository extends JpaRepository <StationProvider,Integer> {
    
}

package com.railprasad.railprasad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railprasad.railprasad.dto.StationProviderDTO;
import com.railprasad.railprasad.model.StationProvider;
import com.railprasad.railprasad.repository.StationProviderRepository;

@Service
public class StationProviderService {
    
  @Autowired
  StationProviderRepository stationProviderRepository;




    public void submitStationEntry(StationProviderDTO stationDTO) throws Exception {

        try {
            StationProvider station = new StationProvider();
            station.setStationName(stationDTO.getStationName());
            station.setStationCode(stationDTO.getStationCode());
            station.setState(stationDTO.getState());
            station.setProviderid(stationDTO.getProviderid());
            station.setFullName(stationDTO.getFullName());
            station.setPhoneNumber(stationDTO.getPhoneNumber());
            station.setWhatsappNumber(stationDTO.getWhatsappNumber());
            station.setEmailId(stationDTO.getEmailId());
            stationProviderRepository.save(station);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    public List<StationProviderDTO> getAllStationProviders() {
        List<StationProvider> stationProviders = stationProviderRepository.findAll();

        // Map StationProvider to StationProviderDTO
        return stationProviders.stream().map(this::convertToDTO).toList();
    }

    private StationProviderDTO convertToDTO(StationProvider stationProvider) {
        StationProviderDTO dto = new StationProviderDTO();
        dto.setStationName(stationProvider.getStationName());
        dto.setStationCode(stationProvider.getStationCode());
        dto.setProviderid(stationProvider.getProviderid());
        dto.setState(stationProvider.getState());
        dto.setFullName(stationProvider.getFullName());
        dto.setPhoneNumber(stationProvider.getPhoneNumber());
        dto.setWhatsappNumber(stationProvider.getWhatsappNumber());
        dto.setEmailId(stationProvider.getEmailId());
        return dto;
    }

    }




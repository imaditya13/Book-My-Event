package com.example.bookmyevemt.services;

import com.example.bookmyevemt.Exception.CityNotFoundException;
import com.example.bookmyevemt.dto.CityRequestDto;
import com.example.bookmyevemt.models.City;
import com.example.bookmyevemt.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CityService {
    CityRepository cityRepository;
    public CityService(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }
    public City saveCity(CityRequestDto requestDto)
    {
        City city = convertToCity(requestDto);
      return cityRepository.save(city);
    }
    public City getCityById(Long cityId) throws CityNotFoundException {
        Optional<City>city = cityRepository.findById(cityId);
        if(city.isEmpty()) throw new CityNotFoundException(cityId);

            return  city.get();
    }
    public Optional<City> getCityByName(String cityName)
    {
        return cityRepository.findByName(cityName);
    }
    public Boolean deleteCityById(Long cityId)
    {
        if(cityRepository.existsById(cityId))
        {
            cityRepository.deleteById(cityId);
            return true;
        }
        return false;

    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    public void deleteAllCities() {
        cityRepository.deleteAll();
    }

    public List<City> createCities(List<CityRequestDto> cityRequestDTOs) {
        List<City> cities = cityRequestDTOs.stream()
                .map(this::convertToCity)
                .collect(Collectors.toList());

        return cityRepository.saveAll(cities);
    }

    private City convertToCity(CityRequestDto cityRequestDTO) {
        City city = new City();
        city.setName(cityRequestDTO.getName());
        // Set other fields for city creation
        return city;
    }

}

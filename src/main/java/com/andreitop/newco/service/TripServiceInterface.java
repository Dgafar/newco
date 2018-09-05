package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripServiceInterface {

  List<?> findAll();
  TripDto findById(Long id);
  void save(TripDto trip);
  void delete(Long id);
  void update(TripDto newTrip);
}

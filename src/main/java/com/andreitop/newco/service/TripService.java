package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
//import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.repository.TripRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepositoryInterface tripRepository;

    @Autowired
    public TripService(TripRepositoryInterface tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Transactional
    public Iterable<TripDto> findAll() {
        return tripRepository.findAll();
    }

    @Transactional
    public Optional<TripDto> findById(Long id) {
        return tripRepository.findById(id);
    }

    @Transactional
    public void save(TripDto trip) {
        tripRepository.save(trip);
    }

    @Transactional
    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    @Transactional
    public void update(TripDto newTrip) {
        tripRepository.save(newTrip);
    }
}

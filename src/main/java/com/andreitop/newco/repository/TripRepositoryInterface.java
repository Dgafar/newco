package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;

import java.util.List;

public interface TripRepositoryInterface {
    List<?> findAll();
    TripDto findById(final Long id);
    void save(final TripDto trip);
    void delete(final Long id) ;
    void update(final TripDto newTrip);
}

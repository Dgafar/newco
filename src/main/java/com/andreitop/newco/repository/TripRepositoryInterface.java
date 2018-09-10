package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;
import org.springframework.data.repository.CrudRepository;

public interface TripRepositoryInterface extends CrudRepository<TripDto, Long> {

}

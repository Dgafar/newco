package com.andreitop.newco.controller;

import com.andreitop.newco.common.ApiConstant;
import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface TripsControllerInterface {

    List<?> findAll();
    TripDto findById(final Long id);
    void create(final TripDto trip);
    void delete(final Long id);
    void update(final TripDto newTrip);

}

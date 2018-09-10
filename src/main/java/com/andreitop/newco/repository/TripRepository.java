//package com.andreitop.newco.repository;
//
//import com.andreitop.newco.dto.TripDto;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class TripRepository implements TripRepositoryInterface {
//
//    private final List<TripDto> trips = new ArrayList<>();
//    private Optional<TripDto> tripDto;
//
//    public Iterable<TripDto> findAll() {
//        return trips;
//    }
//
//    @Override
//    public Iterable<TripDto> findAllById(Iterable<Long> longs) {
//        return trips;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(TripDto entity) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends TripDto> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends TripDto> Iterable<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    public Optional<TripDto> findById(final Long id) {
//        return tripDto;
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    public Optional<TripDto> save(final TripDto trip) {
//        trip.setId((long) (trips.size() + 1));
//        trips.add(trip);
//        return tripDto;
//    }
//
//    public void delete(final Long id) {
//        trips.stream()
//                .filter(t -> t.getId().equals(id))
//                .findFirst()
//                .ifPresent(trips::remove);
//    }
//
//    public void update(final TripDto newTrip) {
//        trips.stream()
//                .filter(t -> t.getId().equals(newTrip.getId()))
//                .findFirst()
//                .ifPresent(t -> trips.set(trips.indexOf(t), newTrip));
//    }
//}

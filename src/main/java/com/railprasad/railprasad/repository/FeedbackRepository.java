package com.railprasad.railprasad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.railprasad.railprasad.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository <Feedback,Long> {
    @Query("SELECT AVG(f.rating) FROM Feedback f WHERE f.stationproviderid = :stationproviderid")
    Double findAverageRatingByStationproviderid(@Param("stationproviderid") Long stationproviderid);
    List<Feedback> findByStationproviderid(Long stationproviderid);
}

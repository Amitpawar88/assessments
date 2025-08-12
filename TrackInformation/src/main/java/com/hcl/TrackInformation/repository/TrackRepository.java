package com.hcl.TrackInformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.TrackInformation.entity.MusicTrack;

@Repository
public interface TrackRepository extends JpaRepository<MusicTrack, Long> {

}

package com.hcl.TrackInformation.service.Impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.TrackInformation.entity.MusicTrack;
import com.hcl.TrackInformation.repository.TrackRepository;
import com.hcl.TrackInformation.service.TrackService;

@Service
public class TrackServiceImpl implements TrackService {
	@Autowired
	private TrackRepository trackRepository;

	@Override
	public MusicTrack createTrack(MusicTrack musicTrack) {
		return trackRepository.save(musicTrack);
	}

	@Override
	public List<MusicTrack> getAllTracks() {
		// TODO Auto-generated method stub
		return trackRepository.findAll();
	}

	@Override
	public void deleteTrackById(Long trackId) {
		// TODO Auto-generated method stub
		if (trackRepository.existsById(trackId)) trackRepository.deleteById(trackId);
		return;
	}

	@Override
	public List<MusicTrack> getSortedTracks() {
		// TODO Auto-generated method stub
		List<MusicTrack> tracks = trackRepository.findAll();
		Collections.sort(tracks, Comparator.comparing(MusicTrack::getTitle));
		return tracks;
	}

}

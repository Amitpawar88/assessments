package com.hcl.TrackInformation.service;

import java.util.List;

import com.hcl.TrackInformation.entity.MusicTrack;

public interface TrackService {
	MusicTrack createTrack(MusicTrack musictrack);
	
	List<MusicTrack> getAllTracks();
	
	void deleteTrackById(Long trackId);
	
	List<MusicTrack> getSortedTracks();
}

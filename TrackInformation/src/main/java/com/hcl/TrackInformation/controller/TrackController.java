package com.hcl.TrackInformation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.TrackInformation.entity.MusicTrack;
import com.hcl.TrackInformation.service.TrackService;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {

	@Autowired
	private TrackService trackService;
	
	@PostMapping("")
	public ResponseEntity<MusicTrack> createTrack(@RequestBody MusicTrack musicTrack) {
		return ResponseEntity.status(HttpStatus.CREATED).body(trackService.createTrack(musicTrack));
	}
	
	@DeleteMapping("/{trackId}")
	public ResponseEntity<?> deleteTrackById(@PathVariable Long trackId) {
		trackService.deleteTrackById(trackId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("")
	public ResponseEntity<List<MusicTrack>> getAllTracks() {
		return ResponseEntity.status(HttpStatus.OK).body(trackService.getAllTracks());
	}
	
	@GetMapping("/sorted")
	public ResponseEntity<List<MusicTrack>> getSortedTracks() {
		return ResponseEntity.status(HttpStatus.OK).body(trackService.getSortedTracks());
	}
}

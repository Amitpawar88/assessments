package com.hcl.TrackInformation.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MusicTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String albumName;
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date releaseDate;
	private Integer playCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
	@Override
	public String toString() {
		return "MusicTrack [id=" + id + ", albumName=" + albumName + ", releaseDate=" + releaseDate + ", playCount="
				+ playCount + "]";
	}
	public MusicTrack(Long id, String albumName, Date releaseDate, Integer playCount) {
		super();
		this.id = id;
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.playCount = playCount;
	}
	public MusicTrack() {
		super();
	}
	
	
}

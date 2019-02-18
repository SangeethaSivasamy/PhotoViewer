package com.photodetails.beans;

import java.sql.Timestamp;

public class PhotoDetailsBean {
	private String photo_id;
	private String photo_id2;
	private String album_name;
	private Timestamp created_date;
	private String place;
	private String photo_location;
	public PhotoDetailsBean() {
	}
	public PhotoDetailsBean(String photo_id,String album_name,Timestamp created_date,String place,String photo_location) {
		this.photo_id=photo_id;
		this.album_name=album_name;
		this.created_date=created_date;
		this.place=place;
		this.photo_location=photo_location;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPhoto_location() {
		return photo_location;
	}
	public void setPhoto_location(String photo_location) {
		this.photo_location = photo_location;
	}

	@Override
	public String toString() {
		return "photo_id["+photo_id+"] album_name["+album_name+"] created_date["+created_date+"]  place["+place+"] photo_location["+photo_location+"]"; 
	}
}

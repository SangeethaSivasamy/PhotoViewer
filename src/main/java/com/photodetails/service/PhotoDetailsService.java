package com.photodetails.service;

import com.photodetails.beans.PhotoDetailsBean;
import com.photodetails.dao.PhotoDetailsDAO;

public class PhotoDetailsService {
	public PhotoDetailsBean getPhotoDetails(String photoId) {
		PhotoDetailsDAO photoDetailsDAO = new PhotoDetailsDAO();
		PhotoDetailsBean photoDetailsBean = photoDetailsDAO.queryPhotoDetails(photoId);
		return photoDetailsBean;
	}
	
	public PhotoDetailsBean setPhotoDetails(String photoId) {
		PhotoDetailsDAO photoDetailsDAO = new PhotoDetailsDAO();
		PhotoDetailsBean photoDetailsBean = photoDetailsDAO.queryPhotoDetails(photoId);
		return photoDetailsBean;
	}
	
}

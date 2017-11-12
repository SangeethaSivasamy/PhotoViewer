package com.photodetails.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.photodetails.beans.PhotoDetailsBean;
import com.photodetails.service.PhotoDetailsService;



@Path("/photodetails")
public class PhotoDetailsController {

	@Path("/query/{photoid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PhotoDetailsBean getPhotoDetails(@PathParam("photoid") String photoId) {
		PhotoDetailsService photoDetailsService = new PhotoDetailsService();
		PhotoDetailsBean photoDetailsBean = photoDetailsService.getPhotoDetails(photoId);
		System.out.println(photoDetailsBean);
		return photoDetailsBean;
	}
}

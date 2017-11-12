package com.photodetails;

import org.testng.annotations.Test;

import com.photodetails.beans.PhotoDetailsBean;
import com.photodetails.dao.PhotoDetailsDAO;


public class PhotoDetailsDAOTest {

	@Test
	public void testgetDetails() {
		PhotoDetailsDAO dao = new PhotoDetailsDAO();
		PhotoDetailsBean bean = dao.queryPhotoDetails("id_1");
		System.out.println(bean);
	}
}

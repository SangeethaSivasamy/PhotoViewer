package com.photodetails.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.photodetails.beans.PhotoDetailsBean;



public class PhotoDetailsDAO {

	public void insertPhotoDetails(PhotoDetailsBean photoDetailsBean) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@sanora.cdyluq6riyyv.us-east-2.rds.amazonaws.com:1521:ORCL","orauser","orapassword");
			String sql = "insert into photodetails values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, photoDetailsBean.getPhoto_id());
			preparedStatement.setString(2, photoDetailsBean.getAlbum_name());
			preparedStatement.setTimestamp(3, photoDetailsBean.getCreated_date());
			preparedStatement.setString(4, photoDetailsBean.getPlace());
			preparedStatement.setString(5, photoDetailsBean.getPhoto_location());
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException sqlex) {
			System.out.println(sqlex);
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				preparedStatement.close();
				preparedStatement=null;
				connection.close();
				connection=null;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}

	}

	public void updatePhotoDetails(String newplace,PhotoDetailsBean oldphotoDetailsBean) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@sanora.cdyluq6riyyv.us-east-2.rds.amazonaws.com:1521:ORCL","orauser","orapassword");
			String sql = "update photodetails set place=? where photo_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newplace);
			preparedStatement.setString(2, oldphotoDetailsBean.getPhoto_id());
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e);
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			try {
				preparedStatement.close();
				preparedStatement=null;
				connection.close();
				connection=null;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}

	public PhotoDetailsBean queryPhotoDetails(String photoId) {
		System.out.println("inside queryPhotoDetails"+photoId);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		PhotoDetailsBean photoDetailsBean = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@sanora.cdyluq6riyyv.us-east-2.rds.amazonaws.com:1521:ORCL","orauser","orapassword");
			String sql = "select * from photodetails where photo_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, photoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				photoDetailsBean = new PhotoDetailsBean();
				photoDetailsBean.setPhoto_id(resultSet.getString(1));
				photoDetailsBean.setAlbum_name(resultSet.getString(2));
				photoDetailsBean.setCreated_date(resultSet.getTimestamp(3));
				photoDetailsBean.setPlace(resultSet.getString("place"));
				photoDetailsBean.setPhoto_location(resultSet.getString(5));
			}
		}/*catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e);
		}*/catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			try {
				preparedStatement.close();
				preparedStatement=null;
				connection.close();
				connection=null;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		return photoDetailsBean;
	}
	
	
	public void batchPhotoDetails() {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@sanora.cdyluq6riyyv.us-east-2.rds.amazonaws.com:1521:ORCL","orauser","orapassword");
			String sql = "insert into photodetails values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "id_2");
			preparedStatement.setString(2, "Favourites");
			preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			preparedStatement.setString(4, "Sunnyvale");
			preparedStatement.setString(5, "/Users/sangeetha/Documents");
			preparedStatement.addBatch();
			
			preparedStatement.clearParameters();
			preparedStatement.setString(1, "id_3");
			preparedStatement.setString(2, "Engagement");
			preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			preparedStatement.setString(4, "Sunnyvale");
			preparedStatement.setString(5, "/Users/sangeetha/Documents");
			preparedStatement.addBatch();
			
			preparedStatement.clearParameters();
			preparedStatement.setString(1, "id_3");
			preparedStatement.setString(2, "Engagement");
			preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			preparedStatement.setString(4, "Sunnyvale");
			preparedStatement.setString(5, "/Users/sangeetha/Documents");
			preparedStatement.addBatch();
			
			preparedStatement.clearParameters();
			preparedStatement.setString(1, "id_7");
			preparedStatement.setString(2, "Marriage");
			preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			preparedStatement.setString(4, "Sunnyvale");
			preparedStatement.setString(5, "/Users/sangeetha/Documents");
			preparedStatement.addBatch();
			
			int[] result = preparedStatement.executeBatch();
			for(int i:result) {
				System.out.println(i);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException sqlex) {
			System.out.println(sqlex);
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				preparedStatement.close();
				preparedStatement=null;
				connection.close();
				connection=null;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}

	}

}

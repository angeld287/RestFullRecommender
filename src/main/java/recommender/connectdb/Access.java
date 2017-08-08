package recommender.connectdb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import recommender.model.Rating;

public class Access {
	public ArrayList<Rating> getRatings(Connection con) throws SQLException, IOException{
		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM rating");
		ResultSet rs = stmt.executeQuery();
		//`user_voted``restaurant_voted``number_voted
		try	{
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/aangeles/Desktop/workspace1/RestFullRecommender/data/result.csv"));
			while(rs.next()){
				Rating ratingObj = new Rating();
				ratingObj.setId(rs.getInt("id"));
				ratingObj.setNumber_voted(rs.getFloat("number_voted"));//(rs.getString("name"));
				ratingObj.setRestaurant_voted(rs.getInt("restaurant_voted"));//(rs.getString("duration"));
				ratingObj.setUser_voted(rs.getInt("user_voted"));//(rs.getDouble("fee"));
				ratingList.add(ratingObj);
				bw.write(rs.getInt("user_voted")+","+rs.getInt("restaurant_voted")+","+rs.getFloat("number_voted")+ "\n");
			}
			bw.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return ratingList;
	}
}

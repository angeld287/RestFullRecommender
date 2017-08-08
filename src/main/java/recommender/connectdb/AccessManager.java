package recommender.connectdb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import recommender.model.Rating;

public class AccessManager {
	public ArrayList<Rating> getRatings() throws Exception{
		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		ratingList = access.getRatings(con);
		return ratingList;
	}
}

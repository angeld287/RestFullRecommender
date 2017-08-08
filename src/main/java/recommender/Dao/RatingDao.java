package recommender.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import recommender.model.Rating;


public class RatingDao {
	public static final Map<String, Rating> empMap = new HashMap<String, Rating>();
	
	static{
		initEmps();
	}

	private static void initEmps() {
		// TODO Auto-generated method stub
		Rating rat1 = new Rating(1, 4, 9, 5);
		Rating rat2 = new Rating(2, 5, 6, 3.1);
		Rating rat3 = new Rating(3, 6, 7, 4.2);
 
        empMap.put(Integer.toString(rat1.getId()), rat1);
        empMap.put(Integer.toString(rat2.getId()), rat2);
        empMap.put(Integer.toString(rat3.getId()), rat3);
	}
	
	public static Rating getRating(String user_voted) {
		return empMap.get(user_voted);
	}
	
	public static List<Rating> getAllRatings() {
        Collection<Rating> c = empMap.values();
        List<Rating> list = new ArrayList<Rating>();
        list.addAll(c);
        return list;
    }
     
    List<Rating> list;
}

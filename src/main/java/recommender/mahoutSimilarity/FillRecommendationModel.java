package recommender.mahoutSimilarity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import recommender.model.Recommendations;

public class FillRecommendationModel {
	
	public FillRecommendationModel(){
		
	}
	
	public ArrayList<Recommendations> GetRecommendation() throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/aangeles/Desktop/workspace1/RestFullRecommender/data/recomendation.csv"));
		ArrayList<Recommendations> rList = new ArrayList<Recommendations>();
		String line;
		rList.clear();
		while((line = br.readLine()) != null){
			String[] elements = line.split(",");
			
			int user = Integer.parseInt(elements[0]);
			int restaurant = Integer.parseInt(elements[1]);
			float recommendation = Float.parseFloat(elements[2]);
			
			Recommendations r = new Recommendations();
			r.setUser(user);
			r.setRestaurant(restaurant);
			r.setRecomendation(recommendation);
			rList.add(r);
		}
		br.close();
		
		return rList;
		
	}
	
}

package recommender.mahoutSimilarity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import static java.lang.Math.toIntExact;

import recommender.model.Rating;
import recommender.model.Recommendations;

public class itemRecommender {
	
	ArrayList<Recommendations> listRecomendations;
	public ArrayList<Recommendations> getRecommendations(String User_Voted) throws IOException, TasteException{

			DataModel dm = new FileDataModel(new File("C:/Users/aangeles/Desktop/workspace1/RestFullRecommender/data/result.csv"));
			System.out.println("FileDataModel");
			/*for (DataModel model: dm){
				
			}*/
			UserSimilarity similarity = new PearsonCorrelationSimilarity(dm);
			System.out.println("similarity");
	        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.4, similarity, dm);
	        System.out.println("neighborhood");
	        UserBasedRecommender recommender = new GenericUserBasedRecommender(dm, neighborhood, similarity);
	        System.out.println("recommender "+User_Voted);
	        List<RecommendedItem> lr = recommender.recommend(Long.valueOf(User_Voted).longValue(),4);
	        System.out.println("List<RecommendedItem>"+lr);
	        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/aangeles/Desktop/workspace1/RestFullRecommender/data/recomendation.csv"));     
	        System.out.println("BufferedWriter");
	        for(RecommendedItem item : lr)
	        {
	            System.out.println(item);
	            bw.write(User_Voted+ "," +item.getItemID()+ "," +item.getValue()+ "\n");
	        }
	        bw.close();
		return listRecomendations;
	}
}

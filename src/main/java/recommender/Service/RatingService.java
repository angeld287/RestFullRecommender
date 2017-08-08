package recommender.Service;

import java.awt.Event;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.google.gson.Gson;

import recommender.Dao.RatingDao;
import recommender.connectdb.AccessManager;
import recommender.mahoutSimilarity.FillRecommendationModel;
import recommender.mahoutSimilarity.itemRecommender;
import recommender.model.Rating;
import recommender.model.Recommendations;

@Path("/ratings")
public class RatingService {
	// URI:
    // /contextPath/servletPath/ratings
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Rating> getRating_JSON() throws Exception {
        List<Rating> listOfRatings = new AccessManager().getRatings(); //RatingDao.getAllRatings();
        return listOfRatings;
    }
    
 // URI:
 	// /contextPath/servletPath/ratings/{user_voted}
 	@GET
 	@Path("/{user_voted}")
 	@Produces({ MediaType.APPLICATION_JSON })
 	public List<Recommendations> get(@PathParam("user_voted") String user_voted) throws Exception {
 		List<Rating> listOfRatings = new AccessManager().getRatings();
 		List<Recommendations> recomendations = new itemRecommender().getRecommendations(user_voted); 
 		List<Recommendations> recomendations2 = new FillRecommendationModel().GetRecommendation();
 		return recomendations2;
 		}
 	
 	@GET
 	@Path("/ACAO/{user_voted}")
 	@Produces({ MediaType.APPLICATION_JSON })
 	public Response getResponse(@PathParam("user_voted") String user_voted) throws Exception { 
 		List<Rating> listOfRatings = new AccessManager().getRatings();
 		List<Recommendations> recomendations = new itemRecommender().getRecommendations(user_voted); 
 		List<Recommendations> recomendations2 = new FillRecommendationModel().GetRecommendation();
 	     
 		return Response.ok(new GenericEntity<List<Recommendations>>(recomendations2) {})
 				.header("Access-Control-Allow-Origin", "*")
 			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
 			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
 	}
}

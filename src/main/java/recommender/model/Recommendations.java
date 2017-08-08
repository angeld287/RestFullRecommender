package recommender.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recommendations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recommendations {
	private int user;
	private int restaurant;
 	private float recomendation;
 	
	public Recommendations() {
		
	}

	public Recommendations(int user, int restaurant, int recomendation) {
		this.user = user;
		this.restaurant = restaurant;
		this.recomendation = recomendation;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}

	public float getRecomendation() {
		return recomendation;
	}

	public void setRecomendation(float recomendation) {
		this.recomendation = recomendation;
	}	
 	
}

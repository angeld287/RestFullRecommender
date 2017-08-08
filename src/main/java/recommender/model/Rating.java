package recommender.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rating")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rating {
	
	//`id``user_voted``restaurant_voted``number_voted`
		private int id;
	 	private int user_voted;
	    private int restaurant_voted;
	    private double number_voted;
	    
	    public Rating(){
	    	
	    }
	    
		public Rating(int id, int user, int restaurant, double value) {
			this.id = id;
	        this.user_voted = user;
	        this.restaurant_voted = restaurant;
	        this.number_voted = value;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getUser_voted() {
			return user_voted;
		}

		public void setUser_voted(int user_voted) {
			this.user_voted = user_voted;
		}

		public int getRestaurant_voted() {
			return restaurant_voted;
		}

		public void setRestaurant_voted(int restaurant_voted) {
			this.restaurant_voted = restaurant_voted;
		}

		public double getNumber_voted() {
			return number_voted;
		}

		public void setNumber_voted(float number_voted) {
			this.number_voted = number_voted;
		}
	
}

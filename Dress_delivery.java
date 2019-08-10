
public class Dress_delivery {
	public float calculate(float distance) {
		if(distance <= 2) {
			return 150;
		}
		else {
			return (150 + (distance - 2) * 25);
		}
	}

}

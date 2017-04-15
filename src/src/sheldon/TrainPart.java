package sheldon;

public class TrainPart {
	public TrainPart(){

	}
TrainPart behindMe;
TrainPart inFrontOfMe;
Rail currentRail;
boolean hasPassengers = true;

	public void MoveToRail (Rail ra){
	}
	public boolean HasPassenger (){// ülnek e a vonaton
		System.out.println("This carriage has passangers : " + hasPassengers);
		return hasPassengers;
	}
}

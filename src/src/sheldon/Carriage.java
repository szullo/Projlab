package sheldon;

public class Carriage extends TrainPart{
	public Carriage(){
	}
Color myColor;
public void MoveToRail (Rail ra){ // következő sínre mozgat
	System.out.println("I'm being moved to another rail! - said by a carriage");
	if(behindMe != null){
		currentRail.Clear();
		behindMe.MoveToRail(currentRail); // rekurzívan meghívja a mögötte álló kocsin ha van olyan
	}
	if(!inFrontOfMe.HasPassenger() && HasPassenger()){
		boolean stimmelszinu = ra.CompareColors();//my color összehasonlítása
			if(stimmelszinu){
				System.out.println("I'm at a station, and the colors are matching - told by a carriage");
				System.out.println("So passangers, get off.. - shouted the carriage");
				hasPassengers = false;
				if(behindMe == null){
					System.out.println("I was the last carriage, that had people on it! - said the carriage with a happy smile on its face");
					Main.EmptyTrainCounterPlusPlus();
				}
			}
		}
		ra.AddTrainToRail();// hozzádha a kocsit a sínhez
}
}

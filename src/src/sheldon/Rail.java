package sheldon;

public class Rail {
	public Rail(){
	}
	Rail[] neighbours = new Rail[2];
	TrainPart myTrainPart;
	
	public Rail GetNextRail (){ // a sín megmondja a trainpartnak hogy mi az ő szomszédja hova kell lépni
		System.out.println("Next rail has been given to another trainpart! - told the wise old rail");
		return neighbours[1];
	}
	public boolean CompareColors (){
		System.out.println("sorry, but this isnt a good color match! - complained the rail, even though it didnt have any colors at all");
		return false;
	}
	public void AddTrainToRail (){ // ha egyszerre több vonat lenne a sinen akkor ütközés --> a játék véget ér
		if(myTrainPart != null){
			System.out.println("Trainpart has collided :(, another day without accidents, crap - says the rail while it got sadder and sadder");
		}else{
			myTrainPart = new TrainPart();
			System.out.println("The given Rail was perfect, noone was on this one!. - thought the rail");
		}
	}
	public void Clear (){
		System.out.println("Rail is cleared! Has no train on it. - there's no train in poor rail's heart..");
	}
	
	public boolean HasTrain(){
		if(myTrainPart == null){
			System.out.println("No there's no train standing on me! - in other words i'm independent! - demanded the rail");
			return false;
		}else{
			System.out.println("Yes I have a train on me, so I'm already taken, sorry, bae! - proclaimed the rail");
			return true;
		}
	}
	public void ChangeDirection() {
	}
	public void ChangeGate (){
	}
	public void changecolor (Color c){
	}
}

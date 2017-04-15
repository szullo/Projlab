package sheldon;

public class Engine extends TrainPart {
public Engine(){

}
	public void Move (){ // mivel a Train Part specializációja ezért a current rail segítségével el tudja dönteni hogy hova kell lépnie
		System.out.println("Engine starts moving the train - cho cho!");
		Rail s = currentRail.GetNextRail();
		s.AddTrainToRail();
		currentRail.Clear();
		behindMe.MoveToRail(s); // meghívja a mögötte álló kocsinak hogy hova lépjen
		currentRail = s;
	}
}

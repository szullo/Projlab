package sheldon;

import java.util.ArrayList;

public class UnderPassCreator {
	public UnderPassCreator(){

	}
	ArrayList<SpecialRail> underPassEdges = new ArrayList<SpecialRail>();
	ArrayList<Rail> railList = new ArrayList<Rail>();
	public void Generate (){//amikor egyik special rail se aktív akkor a special rail-ből kapu lesz
		System.out.println("Underpass is under construction");
		System.out.println("...");
		System.out.println("...");
		System.out.println("Underpass created! was fast");
	}
	
public void AddGate (){
	int hey = GetSpecialRailActive();
	if(hey == 0){//amikor egyik special rail se aktív akkor a special rail-ből kapu lesz
		System.out.println("A gate added! -yea  - says the UPC " );
		SpecialRail asd = new SpecialRail();
		underPassEdges.add(asd);
	}
	if(hey == 1){// ha már van egy kapu akkor is krelódik még egy, ezután pedig létrejön az alagút a két kapu között
		System.out.println("A gate added! More more more!  - says the UPC with a strange smile. Threesome :D");
		SpecialRail asd = new SpecialRail();
		underPassEdges.add(asd);
		Generate();
		// ha már 2 kapu van akkor nem tud továbbit hozzáadni
	}
}
public int GetSpecialRailActive (){
	System.out.println("This many SpecialRail is active : " + underPassEdges.size());
	return underPassEdges.size();// megadja hogy jelenleg hány special rail viselkedik kapuként
}
public void RemoveGate (){
	int hey = GetSpecialRailActive();
	if(hey != 0 && !UPhasTrain()){
		if(hey == 2){
			System.out.println("A gate removed - noo, I'm gonna miss you - says the UPC");
			Remove(); // eltünteti az alagutat, megszünnek az alagút sinei
			underPassEdges.remove(0);
		}else{
			System.out.println("A gate removed- noo, I'm alone again T_T - cried the UPC");
			underPassEdges.remove(0);
		}
	}
}
public boolean UPhasTrain (){// amíg van vonat addig nem szűnhet meg az alagút
	System.out.println("There's no one inside me ;) - complained the UPC");
	return false;
}
	public void Remove (){
		System.out.println("The underpass is being destroyed! It was hard to hold - says the UPC");
	}
}

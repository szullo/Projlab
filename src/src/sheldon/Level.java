package sheldon;

import java.util.ArrayList;

public class Level {
	public Level(){
	}
	public ArrayList<Rail> rails = new ArrayList<Rail>();
	public ArrayList<Carriage> carriges = new ArrayList<Carriage>();
	public ArrayList<Engine> engines = new ArrayList<Engine>();
	public UnderPassCreator u_p_c;
	
	public void Generate(){
		//Legenerálja a kódja alapján a pályát.
		Rail a = new Rail();
		rails.add(a);
		Rail b = new Rail();
		rails.add(b);
		Rail c = new Rail();
		rails.add(c);
		Engine k = new Engine();
		engines.add(k);
		Carriage v = new Carriage();
		carriges.add(v);
		Rail eh = new Switch();
		rails.add(eh);
		u_p_c = new UnderPassCreator();
		Rail h = new Station();
		rails.add(h);
		Rail sp2 = new SpecialRail();
		rails.add(sp2);
		Rail sp1 = new SpecialRail();
		rails.add(sp1);
		//szimpla összekötés most
		a.neighbours[0] = b;
		a.neighbours[1] = sp1;
		b.neighbours[0] = a;
		b.neighbours[1] = c;
		c.neighbours[0] = b;
		c.neighbours[1] = eh;
		c.neighbours[0] = b;
		c.neighbours[1] = eh;
		eh.neighbours[0] = c;
		eh.neighbours[1] = h;
		h.neighbours[0] = eh;
		h.neighbours[1] = sp2;
		sp2.neighbours[0] = h;
		sp2.neighbours[1] = sp1;
		sp1.neighbours[0] = a;
		sp1.neighbours[1] = sp2;
		k.behindMe = v;
		k.currentRail = a;
		k.hasPassengers = false;
		v.currentRail = b;
		v.hasPassengers = true;
		v.myColor = Color.RED;
		v.inFrontOfMe = k;
		h.changecolor(Color.RED);
	}
	
	public void Destroy(){
		System.out.println("Level has been destroyed!");
	}
	
	public void MoveEngines(){ // az összes mozdonynak meghívja a move függvényét ezzel mozgatja a vonatokat a sineken
		System.out.println("Engines are being moved");
		for(int i = 0; i < engines.size(); i++){
			engines.get(i).Move();
		}
	}
	
	public boolean emptyCheck (TrainPart a){
		System.out.println("TrainPart is empty!");
			return true;
		}
	
	public int GetEngineCount(){
		return engines.size();
	}
}

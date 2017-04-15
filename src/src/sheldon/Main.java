package sheldon;
import java.io.*;
import java.util.ArrayList;

enum Color
{
   RED,
   BLUE,
   WHITE,
   GREEN
};

/*
 * Change Switch
1.1 van a switchen vonat ? Y/N
Add Gate
2.1 van a special railen vonat ? Y/N
2.2 H�ny kapu van lerakva ? 0/1/2
3. Remove Gate
3.1 van akt�v alag�t ? Y/N
3.2 van vonat az alag�tban ? Y/N
4. Move Engine
4.1 van e �tk�z�s ? Y/N
5. Move Carriage
5.1 �llom�son �ll? Y/N
5.2 A kocsi sz�ne megegyezik az �llom�s sz�n�vel ?  Y/N
5.3 Lesz�lltak  m�r az el�z� kocsikr�l? Y/N 	
5.4 Van utas a kocsin ? Y/N
5.5 van m�g�tte kocsi ? Y/N
6. Start Game
7.Exit Game
7.1 Nyert a j�t�kos ? Y/N
8. Level Complete 
8.1 Van k�vetkez� p�lya? Y/N

 */

public class Main {
	static boolean gameHasStarted = false;
	public int LevelSzam = 1;
	public int currentLevel = 0;
	static int Emptytraincount = 0;
	public ArrayList<Level> levelList = new ArrayList<Level>();
	//public ArrayList<Level> levelList = new ArrayList<Level>();
	
	static public void main (String[] args){
		boolean Fourhaspressed = false;
		Main m = new Main();		
		m.Init();
		try {
			 InputStreamReader isr = new InputStreamReader(System.in);
			 BufferedReader br = new BufferedReader(isr);
		 while(true){
			 System.out.println("Choose an action : ");
			 if(gameHasStarted){
				 System.out.println("1 - Change Switch");
				 System.out.println("2 - Add Gate");
				 System.out.println("3 - Remove Gate");
				 System.out.println("4 - Change Gate");
				 System.out.println("5 - Move Engine and Move Carriage");
			 }
			 System.out.println("6 - Start Game");
			 System.out.println("7 - Exit Game");
			 System.out.println("8 - Level Complete(?)");
			 if(Fourhaspressed){
				 System.out.println("9 - Cheat2WIN");
			 }
			 	String line;
				line = br.readLine();
				if(line == null) break;				
				switch(line){
				case "1":
					if(gameHasStarted)
						m.levelList.get(m.currentLevel).rails.get(3).ChangeDirection();
					break;
				case "2":
					if(gameHasStarted)
						m.levelList.get(m.currentLevel).u_p_c.AddGate();
					break;
				case "3":
					if(gameHasStarted)
						m.levelList.get(m.currentLevel).u_p_c.RemoveGate();
					break;
				case "4":
					m.levelList.get(m.currentLevel).rails.get(5).ChangeGate();
					break;
				case "5":
					if(gameHasStarted){
						Fourhaspressed = true;
						m.levelList.get(m.currentLevel).MoveEngines();
					}
					break;
				case "6":
						m.StartGame();
					break;
				case "7":
						m.ExitGame();
					break;
				case "8":
					if(gameHasStarted)
						m.NextLevel();
					break;
				case "9":
					m.levelList.get(m.currentLevel).carriges.get(0).MoveToRail(m.levelList.get(m.currentLevel).rails.get(4));
					break;
				}
		 	}
		}
		catch(Exception e){
	
		}
	}
	
	public void Init (){
		//Pályák beolvasása
		try{
		Level mylevel = new Level();
		levelList.add(mylevel);
		}catch(Exception e){
		
		}
	}
	
	public void ExitGame (){
		int engCo = levelList.get(currentLevel).GetEngineCount();
		if(gameHasStarted && Emptytraincount == engCo){	//Ha j�t�kban vagyunk m�g / elindult-e a j�t�k
			System.out.println("You Won!");
		}else{
			System.out.println("You Lost");
		}
		System.out.println("Press enter to quit");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		System.exit(1);		//kilép
	}
	
	public void NextLevel (){
		int engCo = levelList.get(currentLevel).GetEngineCount();
		if(Emptytraincount == engCo){
			System.out.println("You have completed the level!!! ^_^");
			levelList.get(currentLevel).Destroy();
			currentLevel++;
			if(currentLevel == LevelSzam){
				System.out.println("You have completed all the levels! Well done!");
				System.out.println("Press any enter to quit!");
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				System.exit(1);		//kilép
			}else{
				StartGame();
			}
		}else{
			System.out.println("There are more trains to empty!");
		}
	}
	
	public void StartGame(){
		System.out.println("A new Level is being created!");
		levelList.get(currentLevel).Generate();
		gameHasStarted = true;
	}
	
	static public void GameOver (){
		 System.out.println("Game ended, loser");
		 gameHasStarted = false;
	}
	static public void EmptyTrainCounterPlusPlus (){
		 System.out.println("A whole train got empty!");
		 Emptytraincount++;
	}
}

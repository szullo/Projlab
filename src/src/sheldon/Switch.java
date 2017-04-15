package sheldon;

public class Switch extends Rail {
	public Switch(){
	}
	public void ChangeDirection(){
		boolean vane = this.HasTrain();
		if(!vane){
			System.out.println("The switch has been switched ;)"); // vált
		}else{
			System.out.println("The switch couldnt be switched :("); // nem tud váltaani mert állnak rajta
		}
	}
	
}

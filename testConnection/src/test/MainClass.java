package test;

class Number{
	int x = 10;
	static int y = 100;
}
public class MainClass {

	
	public static void main(String[] args) {
		Number n = new Number();
		n.x = 100;
		n.y = 20;
		Number.y = 20;
		
	}

}

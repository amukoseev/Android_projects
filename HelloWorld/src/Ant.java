
public class Ant {
public static int x,y;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void setPos(int xPos,int yPos) {
		x = xPos;
		y = yPos;
		printAntPos ();
	}
	public static void printAntPos () {
		System.out.println("Муравей в точке " + x + "-" + y);
	}
	public void moveUp (int stepsN) {
		y = y + stepsN;
		printAntPos ();
	}
	public void moveDown (int stepsN) {
		y = y - stepsN;
		printAntPos ();
	}
	public void moveLeft (int stepsN) {
		x = x - stepsN;
		printAntPos ();
	}
	public void moveRight (int stepsN) {
		x = x + stepsN;
		printAntPos ();
	}
}

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author <you>
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.
		Point anchor=new Point(mid,top);
		
		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)
		MiniFig bob=new MiniFig(g,scaleFactor, anchor);
		
		// TODO: 3. Create a new custom Color object. An example is shown below.
		Color torsoColor = new Color (218,169,245);
		
//**************************************************************************************************************************		
		
		
		//MY CODE FOR BACKGROUND
		
		
		
//***************************************************************************************************************************		
		//SHRUB
		
		g.setColor(Color.GREEN);
		int shrubX=bob.getRightHandCenterPoint().x- bob.getWidth();
		int shrubY = bob.getRightHandCenterPoint().y - bob.getFaceHeight()/2;
		int shrubWidth=bob.getWidth();
		int shrubHeight=bob.getHeight();
		g.fillOval(shrubX, shrubY, shrubWidth, shrubHeight);
		
		int shrubTwoX=bob.getRightHandCenterPoint().x- bob.getWidth()/2;
		int shrubTwoY = bob.getRightHandCenterPoint().y;
		int shrubTwoWidth=(int)(bob.getWidth()/1.5);
		int shrubTwoHeight=bob.getHeight()/2;
		g.fillOval(shrubTwoX, shrubTwoY, shrubTwoWidth, shrubTwoHeight);
		
//****************************************************************************************************************************
		//TREE
		
		Color treeTrunk=new Color(74,41,9);
		g.setColor(treeTrunk);
		int treeTrunkX=bob.getLeftHandCenterPoint().x + 3*bob.getWidth()/4;
		int treeTrunkY=bob.getBaseMidPoint().y-4*bob.getHeight()/5;
		int treeTrunkWidth=2*bob.getFaceWidth()/3;
		int treeTrunkHeight=bob.getHeight();
		g.fillRect(treeTrunkX, treeTrunkY, treeTrunkWidth, treeTrunkHeight);
		
		//middle
		g.setColor(Color.green);
		int treeX=bob.getLeftHandCenterPoint().x + 3*bob.getWidth()/8;
		int treeY=bob.getBaseMidPoint().y-bob.getHeight();
		int treeWidth=6*bob.getWidth()/8+2*bob.getFaceWidth()/3;
		int treeHeight=2*bob.getHeight()/5;
		g.fillOval(treeX, treeY, treeWidth, treeHeight);
		
		//top right
		int treeTwoX=bob.getLeftHandCenterPoint().x + 5*bob.getWidth()/8;
		int treeTwoY=bob.getBaseMidPoint().y-7*bob.getHeight()/6;
		int treeTwoWidth=6*bob.getWidth()/8;
		int treeTwoHeight=2*bob.getHeight()/6;
		g.fillOval(treeTwoX, treeTwoY, treeTwoWidth, treeTwoHeight);
		
		//top left
		int treeThreeX=bob.getLeftHandCenterPoint().x + bob.getWidth()/8;
		int treeThreeY=bob.getBaseMidPoint().y-7*bob.getHeight()/6;
		int treeThreeWidth=5*bob.getWidth()/8;
		int treeThreeHeight=2*bob.getHeight()/6;
		g.fillOval(treeThreeX, treeThreeY, treeThreeWidth, treeThreeHeight);
		
		//bottom left
		int treeFourX=bob.getLeftHandCenterPoint().x + 2*bob.getWidth()/8;
		int treeFourY=bob.getBaseMidPoint().y-10*bob.getHeight()/13;
		int treeFourWidth=2*bob.getWidth()/3;
		int treeFourHeight=bob.getHeight()/4;
		g.fillOval(treeFourX, treeFourY, treeFourWidth, treeFourHeight);
		
		//bottom right
		int treeFiveX=bob.getLeftHandCenterPoint().x + 10*bob.getWidth()/13;
		int treeFiveY=bob.getBaseMidPoint().y-11*bob.getHeight()/14;
		int treeFiveWidth=2*bob.getWidth()/3;
		int treeFiveHeight=bob.getHeight()/4;
		g.fillOval(treeFiveX, treeFiveY, treeFiveWidth, treeFiveHeight);
		
		
//**********************************************************************************************************************		
		//APPLES
		
		g.setColor(Color.RED);
		int appleX=bob.getLeftHandCenterPoint().x + 3*bob.getWidth()/8;
		int appleY=bob.getBaseMidPoint().y-bob.getHeight();
		int appleWidth=bob.getFaceWidth()/3;
		int appleHeight=bob.getFaceWidth()/3;
		g.fillOval(appleX, appleY, appleWidth, appleHeight);
		
		int appleTwoX=bob.getLeftHandCenterPoint().x + 5*bob.getWidth()/8;
		int appleTwoY=bob.getBaseMidPoint().y-11*bob.getHeight()/10;
		int appleTwoWidth=bob.getFaceWidth()/3;
		int appleTwoHeight=bob.getFaceWidth()/3;
		g.fillOval(appleTwoX, appleTwoY, appleTwoWidth, appleTwoHeight);
		
		int appleThreeX=bob.getLeftHandCenterPoint().x + 5*bob.getWidth()/8;
		int appleThreeY=bob.getBaseMidPoint().y-9*bob.getHeight()/10;
		int appleThreeWidth=bob.getFaceWidth()/3;
		int appleThreeHeight=bob.getFaceWidth()/3;
		g.fillOval(appleThreeX, appleThreeY, appleThreeWidth, appleThreeHeight);
		
		
		int appleFourX=bob.getLeftHandCenterPoint().x + 7*bob.getWidth()/8;
		int appleFourY=bob.getBaseMidPoint().y-7*bob.getHeight()/10;
		int appleFourWidth=bob.getFaceWidth()/3;
		int appleFourHeight=bob.getFaceWidth()/3;
		g.fillOval(appleFourX, appleFourY, appleFourWidth, appleFourHeight);
		
		int appleFiveX=bob.getLeftHandCenterPoint().x + 3*bob.getWidth()/8;
		int appleFiveY=bob.getBaseMidPoint().y-7*bob.getHeight()/10;
		int appleFiveWidth=bob.getFaceWidth()/3;
		int appleFiveHeight=bob.getFaceWidth()/3;
		g.fillOval(appleFiveX, appleFiveY, appleFiveWidth, appleFiveHeight);
		
		int appleSixX=bob.getLeftHandCenterPoint().x + bob.getWidth();
		int appleSixY=bob.getBaseMidPoint().y-12*bob.getHeight()/11;
		int appleSixWidth=bob.getFaceWidth()/3;
		int appleSixHeight=bob.getFaceWidth()/3;
		g.fillOval(appleSixX, appleSixY, appleSixWidth, appleSixHeight);
		
		int appleSevenX=bob.getLeftHandCenterPoint().x + 14*bob.getWidth()/13;
		int appleSevenY=bob.getBaseMidPoint().y-11*bob.getHeight()/13;
		int appleSevenWidth=bob.getFaceWidth()/3;
		int appleSevenHeight=bob.getFaceWidth()/3;
		g.fillOval(appleSevenX, appleSevenY, appleSevenWidth, appleSevenHeight);
		
		int appleEightX=bob.getLeftHandCenterPoint().x + 9*bob.getWidth()/8;
		int appleEightY=bob.getBaseMidPoint().y-bob.getFaceWidth()/3;
		int appleEightWidth=bob.getFaceWidth()/3;
		int appleEightHeight=bob.getFaceWidth()/3;
		g.fillOval(appleEightX, appleEightY, appleEightWidth, appleEightHeight);
		
		
//**************************************************************************************************************************		
		
		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)
		
		bob.setTorsoColor(torsoColor);
		
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.
		//bob.draw();
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value
		//       of the returned point.
		
		Point baseMidpoint=bob.getBaseMidPoint();
		int grassYOffset = baseMidpoint.y;
		
		
		Color grassGreen = new Color (60,80,38);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);

		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:

		
		MiniFig robert = bob;
		robert.setTorsoColor(Color.RED);

		
	    // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" is would simply be the following:
		
		bob.setLegColor(Color.BLUE);
		bob.setArmColor(Color.RED);
		bob.draw();
		
		//or
		//robert.draw();
		
		
		//       What color is Bob's Shirt?  Why?
		//It created an alias, so the assignment statement created a copy of the object's address that was 
		//stored in the variable bob. Therefore they both contain the same address and refer to the object bob.
		//Thus, when robert's torso color is changed, so is Bob's.
		
//****************************************************************************************************************************		
		//HAT
		
		//Hat Brim
		Color hatColor =new Color(99,76,60);
		g.setColor(hatColor);
		int hatBrimX=bob.getCapPoint().x- bob.getFaceWidth();
		int hatBrimY = bob.getTopMidPoint().y;
		int hatBrimWidth=bob.getFaceWidth()*2;
		int hatBrimHeight=bob.getCapPoint().y-bob.getTopMidPoint().y;
		g.fillRect(hatBrimX, hatBrimY, hatBrimWidth, hatBrimHeight);
		
		//Hat Top
		int hatTopX=bob.getTopMidPoint().x-bob.getFaceWidth()/2;
		int hatTopY=bob.getTopMidPoint().y-bob.getFaceHeight()/2;
		int hatTopWidth=bob.getFaceWidth();
		int hatTopHeight=bob.getFaceHeight()/2;
		g.fillRect(hatTopX,hatTopY,hatTopWidth,hatTopHeight);

		
//****************************************************************************************************************************		
		//PAIL
		
		//Pail Body
    	Color pailColor=new Color(192,192,192);
     	g.setColor(pailColor);
     	
     	
//		int bagX=bob.getLeftHandCenterPoint().x-bob.getWidth()/5;
//		int bagY=bob.getLeftHandCenterPoint().y+bob.getFaceHeight()/2;
//		int bagWidth=bob.getWidth()*2/5;
//		int bagHeight=(bob.getBaseMidPoint().y-(bob.getLeftHandCenterPoint().y+bob.getFaceHeight()/2));
//		g.fillRect(bagX, bagY, bagWidth, bagHeight);
     	
     	
		int coordinateX1= bob.getLeftHandCenterPoint().x-bob.getWidth()/4;
		int coordinateX2=bob.getLeftHandCenterPoint().x+bob.getWidth()/4;
		int coordinateX3= bob.getLeftHandCenterPoint().x-bob.getWidth()/5;
		int coordinateX4= bob.getLeftHandCenterPoint().x+bob.getWidth()/5;
		
		int coordinateY1=bob.getLeftHandCenterPoint().y+bob.getFaceHeight()/2;
		int coordinateY2=bob.getBaseMidPoint().y;
		
		int[] XCoordinates= {coordinateX1,coordinateX3,coordinateX4,coordinateX2};
		int[] YCoordinates= {coordinateY1,coordinateY2,coordinateY2,coordinateY1};
		
		g.fillPolygon(XCoordinates,YCoordinates, 4);
		
		//Pail Handle
		int handleX=bob.getLeftHandCenterPoint().x-bob.getWidth()/5;
		int handleY=bob.getLeftHandCenterPoint().y;
		int handleWidth=2*bob.getWidth()/5;
		int handleHeight=bob.getFaceHeight();
		int handleStartAngle=0;
		int handleArcAngle=360;
		g.drawArc(handleX, handleY, handleWidth, handleHeight, handleStartAngle, handleArcAngle);
		}

//*************************************************************************************************************************
	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}

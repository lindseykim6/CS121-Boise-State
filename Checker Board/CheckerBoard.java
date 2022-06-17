import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Lesson 11: Activity - for Loops
 * 
 * @author CS121 Instructors
 * @version [Summer 2020] 
 * @author [Lindsey Kim]  
 */
@SuppressWarnings("serial")
public class CheckerBoard extends JPanel
{
	private static final int NUM_ROWS = 8;
	private static final int NUM_COLS = 8;

	/**
	 * Sets the initial dimensions of the panel. 
	 */
	public CheckerBoard()
	{
		setPreferredSize(new Dimension(500, 500));
	}

	/**
	 *  Draws the checker board.
	 *  @param page Graphics context
	 */
	public void paintComponent(Graphics page)
	{
		int width = getWidth();
		int height = getHeight();

		int boxWidth = (int) Math.ceil((double) width/NUM_COLS);
		int boxHeight = (int) Math.ceil((double) height/NUM_ROWS);



		page.setColor(Color.RED);
		page.fillRect(0, 0, boxWidth, boxHeight);

		for (int row=0;row<NUM_ROWS;row++) {
			for (int column=0;column<NUM_COLS;column++) {
				if ((row%2 != 0 && column%2 == 0)||(row%2 == 0 && column%2 != 0)) {
					page.setColor(Color.BLACK);
				}
				else {
					page.setColor(Color.RED);
				}
				page.fillRect(column*boxWidth, row*boxHeight, boxWidth, boxHeight);
			}
		}	
	}


	/**
	 * Creates the main frame of the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Checker Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerBoard panel = new CheckerBoard();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}

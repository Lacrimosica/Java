import java.awt.Dimension;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.*;
import java.awt.ActionEvent;
import javax.swing.*;

public class World extends JPanel{
	
	private final AtomicInteger generation;


	static final int WIDTH =800;
	static final int HEIGHT =600;
	
	private World() {
		setBackground(Color.BLACK);
		this.generation = new AtomicInteger(0);
		setPreferredSize(new Dimension(WIDTH , HEIGHT));
		final Timer timer = new Timer(5, (ActionEvent e) -> {
			repaint();
		});
		
		timer.start();
	}
	
	
	@Override public void paintComponent(final Graphics graphics) {
		super.paintComponent(graphics);
		final Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.CYAN);
		g.ge
	}
}

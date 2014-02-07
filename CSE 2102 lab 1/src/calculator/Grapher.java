package calculator;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Code source: 
 * http://www.java-forums.org/new-java/7995-how-plot-graph-java-given-samples.html
 */
public class Grapher extends JPanel {

	private static final long serialVersionUID = -1869152501730337382L;
	int[] data = {
	        2, 5, 8, 11, 14, 17, 20, 23, 26, 29
	    };
	final int PAD = 20;
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        double xInc = (double)(w - 2*PAD)/(data.length-1);
        double scale = (double)(h - 2*PAD)/getMax();
        // Mark data points.
        g2.setPaint(Color.blue);
        g2.setBackground(Color.yellow);
        g2.drawString("homework vs time", 290, 30);
        g2.drawString("time", 80, 568);
        g2.drawString("homework completed", 5, 40);
        for(int i = 0; i < data.length; i++) {
            double x = PAD + i*xInc;
            double y = h - PAD - scale*data[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
            if(data[i] > max)
                max = data[i];
        }
        return max;
    }
}
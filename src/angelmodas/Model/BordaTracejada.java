package angelmodas.Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.border.AbstractBorder;

public class BordaTracejada extends AbstractBorder {
    
    private Color color;
    private int thickness;
    private int dashLength;

    public BordaTracejada(Color color, int thickness, int dashLength) {
        this.color = color;
        this.thickness = thickness;
        this.dashLength = dashLength;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, dashLength, new float[]{dashLength}, 0));
        g2d.drawRect(x, y, width - 1, height - 1);
        g2d.dispose();
    }
    
}

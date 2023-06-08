package angelmodas.Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder {
    private Color borderColor;
    private int borderRadius;
    private int borderThickness;

    public RoundBorder(Color borderColor, int borderRadius, int borderThickness) {
        this.borderColor = borderColor;
        this.borderRadius = borderRadius;
        this.borderThickness = borderThickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(borderThickness));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(x, y, width - 1, height - 1, borderRadius, borderRadius);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int borderWidth = Math.max(borderThickness, borderRadius / 2);
        return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.bottom = insets.top = Math.max(borderThickness, borderRadius / 2);
        return insets;
    }
}
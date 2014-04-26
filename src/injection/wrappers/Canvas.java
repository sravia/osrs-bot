
package injection.wrappers;

import environment.Data;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends java.awt.Canvas {
    private static final BufferedImage gameImage = new BufferedImage(764, 553, BufferedImage.TYPE_INT_ARGB);

    @Override
    public Graphics getGraphics() {
        Graphics g = gameImage.getGraphics();
        g.setColor(Color.CYAN);
        g.drawString("Welcome to Dynamac v1.02 BETA", 5, 15);

        if(Data.currentScript!=null){
            Data.currentScript.repaint(g);
        }
        super.getGraphics().drawImage(gameImage, 0, 0, null);
        return g;
    }
}

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapScreen extends JPanel
{
    private BufferedImage[][] tiles;
    private BufferedImage[][] other;
    private EngMap curr;
    
    public MapScreen(EngMap map)
    {
        curr = map;
        tiles = new BufferedImage[19][15];
        other = new BufferedImage[19][15];
        String[][] layout = map.getLayout();
        for(int i = 0; i < layout.length; i++)
        {
            for(int j = 0; j < layout[i].length; j++)
            {
                try {
                    tiles[i][j] = ImageIO.read(new File("src/"+layout[i][j]+".jpg"));
                } catch (IOException e) {
                }
                
            }
        }
        update();
    }
    public void update()
    {
        other[EngMain.chara.getlastx()][EngMain.chara.getlasty()] = null;
        String sex = "female";
        if(EngMain.chara.getSex())
        {
            sex = "male";
        }
        
        try {
            other[EngMain.chara.getx()][EngMain.chara.gety()] = ImageIO.read(new File("src/"+sex+EngMain.chara.facing()+".png"));
        } catch (IOException e) {
        }
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[i].length; j++)
            {
                int x, y;
                x = 0 + (i*64);
                y = 0 + (j*64);
                g.drawImage(tiles[i][j], x, y, 64, 64, null);
            }
        }
        for(int i = 0; i < other.length; i++)
        {
            for(int j = 0; j < other[i].length; j++)
            {
                int x, y;
                x = 0 + (i*64);
                y = 0 + (j*64);
                g.drawImage(other[i][j], x, y, 64, 64, null);
            }
        }
    }
    public void go(EngMap map)
    {
        curr = map;
        tiles = new BufferedImage[19][15];
        other = new BufferedImage[19][15];
        String[][] layout = map.getLayout();
        for(int i = 0; i < layout.length; i++)
        {
            for(int j = 0; j < layout[i].length; j++)
            {
                try {
                    tiles[i][j] = ImageIO.read(new File("src/"+layout[i][j]+".jpg"));
                } catch (IOException e) {
                }
                
            }
        }
        update();
    }
    public void interact(int x, int y)
    {
        curr.interact(x, y);
    }
}

package game;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class EngMain
{
    public static EngMapArr maps;
    public static EngPanelHolder panels;
    public static CharWalker chara;
    public static void main(String[] args)
    {
        chara = new CharWalker(7, 9);
        maps = new EngMapArr();
        Listener list = new Listener(maps.getHome());
        BufferedImage icon = null;
        panels = new EngPanelHolder(); 
        maps.go('*');
        panels.create(maps.getHome());
        try {
            icon = ImageIO.read(new File("src/icon.jpg"));
        } catch (IOException e) {
            System.out.println("UHOH!");
        }
        JFrame win = new JFrame("Cave In", null);
        win.setVisible(true);
        win.setDefaultCloseOperation(win.EXIT_ON_CLOSE);
        win.setSize(1222, 1000);
        win.setResizable(false);
        win.setIconImage(icon);
        win.addKeyListener(list);
        win.setContentPane(panels.Map());
        while(true)
        {
            
        }
    }

}

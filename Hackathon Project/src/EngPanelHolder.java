import javax.swing.JPanel;

public class EngPanelHolder
{
    private JPanel[] panels;

    public EngPanelHolder()
    {
    }
    public void create(EngMap map)
    {
        panels = new JPanel[5];
        panels[0] = new MainMenu();
        panels[1] = new MapScreen(map);
        panels[2] = new Pause();
        panels[3] = new GameOver();
        panels[4] = new CutScene();
    }

    public void mapChange(EngMap map)
    {
        panels[1] = new MapScreen(map);
    }

    public JPanel Menu()
    {
        return panels[0];
    }

    public JPanel Map()
    {
        return panels[1];
    }

    public JPanel Pause()
    {
        return panels[2];
    }

    public JPanel GOver()
    {
        return panels[3];
    }

    public JPanel Scene()
    {
        return panels[4];
    }

}

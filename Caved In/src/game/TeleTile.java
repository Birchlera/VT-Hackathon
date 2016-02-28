package game;

public class TeleTile extends Tile
{
    private String location;
    public TeleTile(int dir)
    {
        super(false, "icon");
        if (dir == 0)
        {
            location = "top";
        }
        if (dir == 1)
        {
            location = "bottom";
        }
        if (dir == 2)
        {
            location = "left";
        }
        if (dir == 3)
        {
            location = "right";
        }
    }
    public int location()
    {
        return -1;
    }
    @Override
    protected void onStep()
    {
  
    }
    @Override
    protected void onInteract()
    {
        // TODO Auto-generated method stub
        
        if(location.equals("top")){
            EngMain.maps.go('n');
        }
        else if(location.equals("bottom")){
            EngMain.maps.go('s');
        }
        else if(location.equals("left")){
            EngMain.maps.go('w');
        }
        else if(location.equals("right")){
            EngMain.maps.go('e');
        }
    }

}

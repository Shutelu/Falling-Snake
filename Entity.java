

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {
    
    protected int entity_position_x, entity_position_y;
    protected int entity_width, entity_height;
    protected int entity_move_x, entity_move_y;
    protected boolean entityIsAlive;
    protected Color entity_color;

    public abstract int move();
    public abstract void draw(Graphics g);
}

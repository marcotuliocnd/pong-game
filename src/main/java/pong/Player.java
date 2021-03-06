package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
  
  public boolean right;
  public boolean left;
  
  public int x;
  public int y;

  public int width;
  public int height;

  public Player(int x, int y) {
    this.x = x;
    this.y = y;
    this.width = 40;
    this.height = 5;
  }

  public void tick() {
    if (right) {
      this.x++;
    } else if (left) {
      this.x--;
    }

    if (this.x + this.width > Game.WIDTH) {
      this.x = Game.WIDTH - width;
    } else if (this.x < 0) {
      this.x = 0;
    }
  }

  public void render(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);
  }
}
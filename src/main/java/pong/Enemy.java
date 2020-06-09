package pong;

import java.awt.Graphics;
import java.awt.Color;

public class Enemy {

  public double x;
  public double y;

  public int width;
  public int height;

  public Enemy(double x, double y) {
    this.x = x;
    this.y = y;
    this.width = 40;
    this.height = 5;
  }
  
  public void tick() {
    this.x += (Game.ball.x - this.x - 6);
  }

  public void render(Graphics g) {
    g.setColor(Color.red);
    g.fillRect((int) this.x, (int) this.y, this.width, this.height);
  }
}
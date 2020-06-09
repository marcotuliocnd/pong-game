package pong;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;
import java.awt.Color;

public class Ball {

  public double x;
  public double y;
  public double directionX;
  public double directionY;

  public double speed;

  public int width;
  public int height;

  public Ball(int y, int x) {
    this.x = x;
    this.y = y;
    this.width = 4;
    this.height = 4;
    this.speed = 1.7;

    int angle = new Random().nextInt(75) + 45;
    this.directionX = Math.cos(Math.toRadians(angle));
    this.directionY = Math.sin(Math.toRadians(angle));
  }
  
  public void tick() {
    if (this.x + (this.directionX * this.speed) + width >= Game.WIDTH || this.x + (this.directionX * this.speed) < 0) {
      this.directionX *= -1;
    }

    if (this.y >= Game.HEIGHT) {
      System.out.println("Enemy point!");
      new Game();
    } else if (this.y < 0) {
      System.out.println("Player point!");
      new Game();
    }

    Rectangle bounds = new Rectangle((int) (this.x + (this.directionX*this.speed)), (int) (this.y + (this.directionY * this.speed)), this.width, this.height);
    Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
    Rectangle boundsEnemy = new Rectangle((int) Game.playerSecond.x, (int) Game.playerSecond.y, Game.playerSecond.width, Game.playerSecond.height);

    if (bounds.intersects(boundsPlayer)) {
      int angle = new Random().nextInt(75) + 45;
      this.directionX = Math.cos(Math.toRadians(angle));
      this.directionY = Math.sin(Math.toRadians(angle));
      if (this.directionY > 0) {
        this.directionY *= -1;
      }
    } else if (bounds.intersects(boundsEnemy)) {
      int angle = new Random().nextInt(75) + 45;
      this.directionX = Math.cos(Math.toRadians(angle));
      this.directionY = Math.sin(Math.toRadians(angle));
      if (this.directionY < 0) {
        this.directionY *= -1;
      }
    }

    this.x += this.directionX * this.speed;
    this.y += this.directionY * this.speed;
  }

  public void render(Graphics g) {
    g.setColor(Color.white);
    g.fillRect((int) this.x, (int) this.y, this.width, this.height);
  }
}
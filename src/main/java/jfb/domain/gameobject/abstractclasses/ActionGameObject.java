package jfb.domain.gameobject.abstractclasses;


import jfb.domain.gameobject.interfaces.Animatable;
import jfb.domain.gameobject.interfaces.Movable;

public class ActionGameObject extends AbstractGameObject implements Animatable, Movable {

    private int speedX;
    private int speedY;

    public ActionGameObject(int x, int y, int width, int height, int speedX, int speedY) {
        super(x, y, width, height);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void move() {
        setPosition(getX() + speedX, getY() + speedY);
    }

    @Override
    public void setSpeed(int speedX, int speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void startAnimation() {

    }

    @Override
    public void stopAnimation() {

    }

    @Override
    public void updateAnimation() {

    }
}
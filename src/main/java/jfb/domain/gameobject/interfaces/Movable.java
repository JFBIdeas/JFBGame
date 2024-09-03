package jfb.domain.gameobject.interfaces;

/**
 * Интерфейс для объектов, которые могут перемещаться по карте.
 */

public interface Movable {
    void move();
    void setSpeed(int speedX, int speedY);
}
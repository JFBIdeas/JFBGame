package jfb.domain.gameobject.interfaces;

/**
 * Интерфейс для объектов, которые имеют анимацию.
 */

public interface Animatable {
    void startAnimation();
    void stopAnimation();
    void updateAnimation();
}
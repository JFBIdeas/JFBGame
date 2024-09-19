package jfb.domain.gameobject.abstractclasses;

import jfb.domain.gameobject.interfaces.Animatable;

public class StaticGameObject extends AbstractGameObject implements Animatable {

    public StaticGameObject(int x, int y, int width, int height) {
        super(x, y, width, height);
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
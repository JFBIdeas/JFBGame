package jfb.domain.gameobject.abstractclasses;

import jfb.domain.entity.player.Player;
import jfb.domain.gameobject.interfaces.Animatable;
import jfb.domain.gameobject.interfaces.Interactable;

public class StaticGameObject extends AbstractGameObject implements Animatable, Interactable {

    public StaticGameObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void interact(Player player) {

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
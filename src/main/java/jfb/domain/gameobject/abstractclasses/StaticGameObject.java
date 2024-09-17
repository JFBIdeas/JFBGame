package jfb.domain.gameobject.abstractclasses;

public class StaticGameObject extends AbstractGameObject{

    public StaticGameObject(int x, int y, int width, int height) {
        super(x, y, width, height);
        setPosition(16,16);
    }
}
package jfb.domain.entity;

public interface EntityAction {
    Integer[][] move();
    void attack();
    boolean isDead();
}

package jfb.domain.gameobject.interfaces;

/**
 * Интерфейс для объектов, которые могут получать урон и иметь здоровье.
 */

public interface Damageable {
    int getHealth();
    void takeDamage(int damage);
    void heal(int amount);
}
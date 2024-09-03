package jfb.domain.gameobject.interfaces;

import jfb.domain.entity.player.Player;

/**
 * Интерфейс для объектов, с которыми может взаимодействовать игрок.
 */

public interface Interactable {
    void interact(Player player);
}

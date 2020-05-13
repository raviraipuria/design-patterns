package com.example.bridge;

/**
 * Weapon.
 */
public interface Weapon {
    void wield();
    void swing();
    void unwield();
    Enchantment getEnchantment();
}

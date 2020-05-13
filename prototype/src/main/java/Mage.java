/**
 * Mage.
 */
public abstract class Mage implements Prototype {

    public Mage() {
    }

    public Mage(Mage source) {
    }

    @Override
    public abstract Mage copy();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

}
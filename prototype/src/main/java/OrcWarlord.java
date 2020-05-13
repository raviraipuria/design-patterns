/**
 * OrcWarlord.
 */
public class OrcWarlord extends Warlord {

    private String weapon;

    public OrcWarlord(String weapon) {
        this.weapon = weapon;
    }

    public OrcWarlord(OrcWarlord orcWarlord) {
        super(orcWarlord);
        this.weapon = orcWarlord.weapon;
    }

    @Override
    public OrcWarlord copy() {
        return new OrcWarlord(this);
    }

    @Override
    public String toString() {
        return "Orcish warlord attacks with " + weapon;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        var other = (OrcWarlord) obj;
        if (weapon == null) {
            return other.weapon == null;
        }
        return weapon.equals(other.weapon);
    }
}
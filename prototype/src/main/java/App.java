import lombok.extern.slf4j.Slf4j;

/**
 * The Prototype pattern is a creational design pattern in software development. It is used when the
 * type of objects to create is determined by a prototypical instance, which is cloned to produce
 * new objects. This pattern is used to: - avoid subclasses of an object creator in the client
 * application, like the abstract factory pattern does. - avoid the inherent cost of creating a new
 * object in the standard way (e.g., using the 'new' keyword)
 *
 * <p>In this example we have a factory class ({@link HeroFactoryImpl}) producing objects by
 * cloning the existing ones. The factory's prototype objects are given as constructor parameters.
 */
@Slf4j
public class App {
    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        var factory = new HeroFactoryImpl(
                new ElfMage("cooking"),
                new ElfWarlord("cleaning"),
                new ElfBeast("protecting")
        );
        var mage = factory.createMage();
        var warlord = factory.createWarlord();
        var beast = factory.createBeast();
        log.info(mage.toString());
        log.info(warlord.toString());
        log.info(beast.toString());

        factory = new HeroFactoryImpl(
                new OrcMage("axe"),
                new OrcWarlord("sword"),
                new OrcBeast("laser")
        );
        mage = factory.createMage();
        warlord = factory.createWarlord();
        beast = factory.createBeast();
        log.info(mage.toString());
        log.info(warlord.toString());
        log.info(beast.toString());
    }
}

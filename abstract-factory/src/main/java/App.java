import lombok.extern.slf4j.Slf4j;

/**
 * The Abstract Factory pattern provides a way to encapsulate a group of individual factories that
 * have a common theme without specifying their concrete classes. In normal usage, the client
 * software creates a concrete implementation of the abstract factory and then uses the generic
 * interface of the factory to create the concrete objects that are part of the theme. The client
 * does not know (or care) which concrete objects it gets from each of these internal factories,
 * since it uses only the generic interfaces of their products. This pattern separates the details
 * of implementation of a set of objects from their general usage and relies on object composition,
 * as object creation is implemented in methods exposed in the factory interface.
 *
 * <p>The essence of the Abstract Factory pattern is a factory interface ({@link KingdomFactory})
 * and its implementations ( {@link ElfKingdomFactory}, {@link OrcKingdomFactory}). The example uses
 * both concrete implementations to create a king, a castle and an army.
 */
@Slf4j
public class App {
    private King king;
    private Castle castle;
    private Army army;

    /**
     * Creates kingdom.
     */
    public void createKingdom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setCastle(factory.createCastle());
        setArmy(factory.createArmy());
    }

    King getKing(final KingdomFactory factory) {
        return factory.createKing();
    }

    public King getKing() {
        return king;
    }

    private void setKing(final King king) {
        this.king = king;
    }

    Castle getCastle(final KingdomFactory factory) {
        return factory.createCastle();
    }

    public Castle getCastle() {
        return castle;
    }

    private void setCastle(final Castle castle) {
        this.castle = castle;
    }

    Army getArmy(final KingdomFactory factory) {
        return factory.createArmy();
    }

    public Army getArmy() {
        return army;
    }

    private void setArmy(final Army army) {
        this.army = army;
    }

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        var app = new App();

        log.info("Elf Kingdom");
        app.createKingdom(FactoryMaker.makeFactory(KingdomType.ELF));
        log.info(app.getArmy().getDescription());
        log.info(app.getCastle().getDescription());
        log.info(app.getKing().getDescription());

        log.info("Orc Kingdom");
        app.createKingdom(FactoryMaker.makeFactory(KingdomType.ORC));
        log.info(app.getArmy().getDescription());
        log.info(app.getCastle().getDescription());
        log.info(app.getKing().getDescription());
    }
}

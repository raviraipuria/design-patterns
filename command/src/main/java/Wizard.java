import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Wizard is the invoker of the commands.
 */
@Slf4j
public class Wizard {
    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public Wizard() {
        // comment to ignore sonar issue: LEVEL critical
    }

    /**
     * Cast spell.
     */
    public void castSpell(Command command, Target target) {
        log.info("{} casts {} at {}", this, command, target);
        command.execute(target);
        undoStack.offerLast(command);
    }

    /**
     * Undo last spell.
     */
    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            var previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            log.info("{} undoes {}", this, previousSpell);
            previousSpell.undo();
        }
    }

    /**
     * Redo last spell.
     */
    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            var previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            log.info("{} redoes {}", this, previousSpell);
            previousSpell.redo();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}

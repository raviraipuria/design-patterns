import lombok.extern.slf4j.Slf4j;

/**
 * Base class for spell targets.
 */
@Slf4j
public abstract class Target {
    private Size size;
    private Visibility visibility;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public abstract String toString();

    /**
     * Print status.
     */
    public void printStatus() {
        log.info("{}, [size={}] [visibility={}]", this, getSize(), getVisibility());
    }
}
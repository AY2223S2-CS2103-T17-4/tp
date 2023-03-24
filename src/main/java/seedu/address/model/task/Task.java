package seedu.address.model.task;

import java.util.Objects;

import seedu.address.model.tank.Tank;
import seedu.address.model.task.exceptions.TaskHasNoTankException;

/**
 *  Represents a Task of the user
 */
public class Task {
    private final Description description;
    private final boolean isTankRelatedTask;
    private Tank tank;

    /**
     * Constructor for a Task
     * @param description Description of task
     * @param tank Tank (if applicable) tied to this task
     */
    public Task(Description description, Tank tank) {
        this.description = description;
        this.tank = tank;
        this.isTankRelatedTask = this.tank != null;
    }

    public Description getDescription() {
        return this.description;
    }

    public Tank getTank() {
        if (!isTankRelatedTask) {
            throw new TaskHasNoTankException(this);
        }
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public boolean isTankRelatedTask() {
        return isTankRelatedTask;
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getDescription().equals(description);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription());

        return builder.toString();
    }
}

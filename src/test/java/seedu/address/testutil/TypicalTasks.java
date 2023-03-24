package seedu.address.testutil;

import static seedu.address.testutil.TypicalTanks.TYPICAL_TANK_1_STRING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.TaskList;
import seedu.address.model.tank.Tank;
import seedu.address.model.tank.TankName;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task TASK_ONE = new Task(new Description("clean tank"),
            new Tank(new TankName(TYPICAL_TANK_1_STRING), new AddressBook()));
    public static final Task TASK_TWO = new Task(new Description("feed fish"), null);

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskList} with all the typical tasks.
     */
    public static TaskList getTypicalTaskList() {
        TaskList tl = new TaskList();
        for (Task task : getTypicalTasks()) {
            tl.addTask(task);
        }
        return tl;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(TASK_ONE, TASK_TWO));
    }
}

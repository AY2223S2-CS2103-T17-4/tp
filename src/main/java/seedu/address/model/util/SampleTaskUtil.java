package seedu.address.model.util;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyTaskList;
import seedu.address.model.TaskList;
import seedu.address.model.tank.Tank;
import seedu.address.model.tank.TankName;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;

/**
 * Contains utility methods for populating Fish Ahoy! with sample data.
 */
public class SampleTaskUtil {
    public static Task[] getSampleTasks() {

        return new Task[] {
            new Task(new Description("clean tank"), new Tank(new TankName("freshwater tank"), new AddressBook())),
            new Task(new Description("feed fish"), null)
        };
    }

    public static ReadOnlyTaskList getSampleTaskList() {
        TaskList sampleTaskList = new TaskList();
        for (Task sampleTask : getSampleTasks()) {
            sampleTaskList.addTask(sampleTask);
        }
        return sampleTaskList;
    }
}

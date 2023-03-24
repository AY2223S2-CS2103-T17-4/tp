package seedu.address.logic.commands.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.fish.FishAddCommand.MESSAGE_MISSING_TANK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TANK;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tank.Tank;
import seedu.address.model.task.Task;

/**
 * Parses input arguments and creates a new TaskAddCommand object
 */
public class TaskAddCommand extends TaskCommand {
    public static final String TASK_COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + TASK_COMMAND_WORD
            + ": Adds a Task to Fish Ahoy!. \n"
            + "Parameters: "
            + PREFIX_DESCRIPTION + "DESCRIPTION "
            + PREFIX_TANK + "<optional> TANK INDEX "
            + "Example: " + COMMAND_WORD + " " + TASK_COMMAND_WORD + " "
            + PREFIX_DESCRIPTION + "Clean fresh water tank "
            + PREFIX_TANK + "1 ";

    public static final String MESSAGE_SUCCESS = "New Task added: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This Task already exists in Fish Ahoy!";

    private final Task toAdd;
    private final Index tankIndex;

    /**
     * Constructs a {@code TaskAddCommand} with the {@code Task} to be added to the {@code TaskList}.
     */
    public TaskAddCommand(Task task, Index tankIndex) {
        requireNonNull(task);
        toAdd = task;
        this.tankIndex = tankIndex;
    }

    public Tank getTaskTank(Index ind, Model model) throws CommandException {
        if (ind == null) {
            return null;
        }
        Tank tank;
        try {
            tank = model.getFilteredTankList().get(tankIndex.getZeroBased());
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(MESSAGE_MISSING_TANK);
        }
        return tank;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasTask(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        Tank tank = getTaskTank(tankIndex, model);
        toAdd.setTank(tank);

        model.addTask(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TaskAddCommand // instanceof handles nulls
                && toAdd.equals(((TaskAddCommand) other).toAdd));
    }
}

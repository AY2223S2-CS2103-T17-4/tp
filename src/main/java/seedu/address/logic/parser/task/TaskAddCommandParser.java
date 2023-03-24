package seedu.address.logic.parser.task;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TANK;

import java.util.stream.Stream;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.task.TaskAddCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tank.UnassignedTank;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;


/**
 * Parses input arguments and creates a new TaskAddCommand object
 */
public class TaskAddCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code TaskAddCommand}
     * and returns a {@code TaskAddCommand} object for execution.
     *
     * @throws ParseException If the user input does not conform with the expected format.
     */
    public TaskAddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DESCRIPTION, PREFIX_TANK);

        if (!arePrefixesPresent(argMultimap, PREFIX_DESCRIPTION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT,
                    TaskAddCommand.MESSAGE_USAGE));
        }
        //tanks are optional. If no tank, index = -1 fromZeroBased
        Index index = getTankIndex(argMultimap);
        Description description = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());

        //if user did not input a tank index, Task will have null for tank
        UnassignedTank tank = index == null ? null : new UnassignedTank(null, null);
        Task task = new Task(description, tank);

        return new TaskAddCommand(task, index);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    private Index getTankIndex(ArgumentMultimap argMap) throws ParseException {
        boolean hasTank = arePrefixesPresent(argMap, PREFIX_TANK);
        if (!hasTank) {
            return null;
        }
        Index tankIndex = ParserUtil.parseIndex(argMap.getValue(PREFIX_TANK).get());
        return tankIndex;
    }
}

package seedu.address.logic.commands.tank;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.date.DateUtil;
import seedu.address.model.tank.Tank;

/**
 * Feeds a {@code Tank} identified using it's displayed index from the {@code TankList}.
 */
public class TankFeedCommand extends TankCommand {

    public static final String TANK_COMMAND_WORD = "feed";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + TANK_COMMAND_WORD
            + ": Feeds all fishes in the Tank identified by the index number used in the displayed Tank List.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " " + TANK_COMMAND_WORD + " 1";

    public static final String MESSAGE_FEED_TANK_SUCCESS = "Fed Tank: %1$s";

    private final Index targetIndex;

    /**
     * Constructs an {@code TankFeedCommand} to feed all fishes in an existing {@code Tank}.
     *
     * @param targetIndex The index of the {@code Tank} to feed.
     */
    public TankFeedCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Tank> lastShownList = model.getFilteredTankList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TANK_DISPLAYED_INDEX);
        }

        Tank tankToFeed = lastShownList.get(targetIndex.getZeroBased());
        //FEED ALL FISHES IN THIS TANK
        String formattedDate = DateUtil.getCurrentDate();

        model.setLastFedDateFishes(tankToFeed, formattedDate);

        return new CommandResult(String.format(MESSAGE_FEED_TANK_SUCCESS, tankToFeed));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TankFeedCommand // instanceof handles nulls
                && targetIndex.equals(((TankFeedCommand) other).targetIndex)); // state check
    }
}



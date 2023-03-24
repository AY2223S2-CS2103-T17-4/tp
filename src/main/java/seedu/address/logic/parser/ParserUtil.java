package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AddressBook;
import seedu.address.model.fish.FeedingInterval;
import seedu.address.model.fish.LastFedDate;
import seedu.address.model.fish.Name;
import seedu.address.model.fish.Species;
import seedu.address.model.tag.Tag;
import seedu.address.model.tank.Tank;
import seedu.address.model.tank.TankName;
import seedu.address.model.task.Description;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String lastFedDate} into a {@code LastFedDate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code lastFedDate} is invalid.
     */
    public static LastFedDate parseLastFedDate(String lastFedDate) throws ParseException {
        requireNonNull(lastFedDate);
        String trimmedLastFedDate = lastFedDate.trim();
        if (!LastFedDate.isValidLastFedDate(trimmedLastFedDate)) {
            throw new ParseException(LastFedDate.MESSAGE_CONSTRAINTS);
        }
        return new LastFedDate(trimmedLastFedDate);
    }

    /**
     * Parses a {@code String feedingInterval} into an {@code FeedingInterval}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code feedingInterval} is invalid.
     */
    public static FeedingInterval parseFeedingInterval(String feedingInterval) throws ParseException {
        requireNonNull(feedingInterval);
        String trimmedFeedingInterval = feedingInterval.trim();
        if (!FeedingInterval.isValidFeedingInterval(trimmedFeedingInterval)) {
            throw new ParseException(FeedingInterval.MESSAGE_CONSTRAINTS);
        }
        return new FeedingInterval(trimmedFeedingInterval);
    }

    /**
     * Parses a {@code String species} into an {@code Species}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code species} is invalid.
     */
    public static Species parseSpecies(String species) throws ParseException {
        requireNonNull(species);
        String trimmedSpecies = species.trim();
        if (!Species.isValidSpecies(trimmedSpecies)) {
            throw new ParseException(Species.MESSAGE_CONSTRAINTS);
        }
        return new Species(trimmedSpecies);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String} into an {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException If the given {@code description} is invalid.
     */
    public static Description parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }

    /**
     * Parses a {@code String} into an {@code TankName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException If the given {@code fullTankName} is invalid.
     */
    public static TankName parseTankName(String fullTankName) throws ParseException {
        requireNonNull(fullTankName);
        String trimmedDescription = fullTankName.trim();
        if (!Description.isValidDescription(fullTankName)) {
            throw new ParseException(TankName.MESSAGE_CONSTRAINTS);
        }
        return new TankName(trimmedDescription);
    }

    /**
     * Parses a {@code String} into an {@code Tank}.
     * Leading and trailing whitespaces will be trimmed.
     *
     *
     * @throws ParseException If the given {@code tank} is invalid.
     */
    public static Tank parseTank(String tank) throws ParseException {
        requireNonNull(tank);
        String trimmedTank = tank.trim();
        if (!TankName.isValidTankName(trimmedTank)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Tank(new TankName(trimmedTank), new AddressBook());

    }
}

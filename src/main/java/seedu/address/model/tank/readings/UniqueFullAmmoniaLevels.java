package seedu.address.model.tank.readings;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.tank.readings.exceptions.DuplicateReadingException;
import seedu.address.model.tank.readings.exceptions.ReadingNotFoundException;

/**
 * A list of Ammonia Readings of all tanks
 *
 * Supports a minimal set of list operations.
 */
public class UniqueFullAmmoniaLevels implements Iterable<UniqueIndividualAmmoniaLevels> {
    public final ObservableList<UniqueIndividualAmmoniaLevels> internalList = FXCollections.observableArrayList();

    private final ObservableList<UniqueIndividualAmmoniaLevels> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent reading as the given argument.
     */
    public boolean containsSameDayReading(UniqueIndividualAmmoniaLevels toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    /**
     * Adds a reading to the list.
     * If a reading of the same day
     */
    public void add(UniqueIndividualAmmoniaLevels toAdd) {
        requireNonNull(toAdd);
        if (containsSameDayReading(toAdd)) {
            internalList.remove(toAdd);
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces a {@code UniqueIndividualAmmoniaLevels} in the list with
     * {@code editedUniqueIndividualAmmoniaLevels}.
     * {@code target} must exist in the list.
     */
    public void setUniqueIndividualAmmoniaLevelList(
            UniqueIndividualAmmoniaLevels target,
            UniqueIndividualAmmoniaLevels editedUniqueIndividualAmmoniaLevels) {
        requireAllNonNull(target, editedUniqueIndividualAmmoniaLevels);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new ReadingNotFoundException();
        }

        internalList.set(index, editedUniqueIndividualAmmoniaLevels);
    }

    /**
     * Removes the equivalent reading from the list.
     * The reading must exist in the list.
     */
    public void remove(UniqueIndividualAmmoniaLevels toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new ReadingNotFoundException();
        }
    }

    public void setAmmoniaLevelLists(UniqueFullAmmoniaLevels replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code UniqueIndividualAmmoniaLevelLists}.
     * {@code UniqueIndividualAmmoniaLevelLists} must not contain duplicate UniqueIndividualAmmoniaLevelLists.
     */
    public void setAmmoniaLevelLists(List<UniqueIndividualAmmoniaLevels> uniqueIndividualAmmoniaLevels) {
        requireAllNonNull(uniqueIndividualAmmoniaLevels);
        if (!ammoniaLevelListsAreUnique(uniqueIndividualAmmoniaLevels)) {
            throw new DuplicateReadingException();
        }

        internalList.setAll(uniqueIndividualAmmoniaLevels);
    }

    /**
     * Returns true if {@code Readings} contains only unique Readings.
     */
    private boolean ammoniaLevelListsAreUnique(List<UniqueIndividualAmmoniaLevels> ammoniaLevelLists) {
        for (int i = 0; i < ammoniaLevelLists.size() - 1; i++) {
            for (int j = i + 1; j < ammoniaLevelLists.size(); j++) {
                if (ammoniaLevelLists.get(i).equals(ammoniaLevelLists.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<UniqueIndividualAmmoniaLevels> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<UniqueIndividualAmmoniaLevels> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueFullAmmoniaLevels // instanceof handles nulls
                && internalList.equals(((UniqueFullAmmoniaLevels) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    public int size() {
        return internalList.size();
    }
}

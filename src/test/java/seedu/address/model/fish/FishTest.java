package seedu.address.model.fish;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalFishes.ALICE;
import static seedu.address.testutil.TypicalFishes.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.FishBuilder;

public class FishTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Fish fish = new FishBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> fish.getTags().remove(0));
    }

    @Test
    public void isSameFish() {
        // same object -> returns true
        assertTrue(ALICE.isSameFish(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameFish(null));

        // same name, all other attributes different -> returns true
        Fish editedAlice = new FishBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameFish(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new FishBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameFish(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Fish editedBob = new FishBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(BOB.isSameFish(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new FishBuilder(BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSameFish(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Fish aliceCopy = new FishBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different fish -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Fish editedAlice = new FishBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new FishBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new FishBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new FishBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new FishBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}

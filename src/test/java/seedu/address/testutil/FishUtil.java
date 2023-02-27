package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditFishDescriptor;
import seedu.address.model.fish.Fish;
import seedu.address.model.tag.Tag;

/**
 * A utility class for Fish.
 */
public class FishUtil {

    /**
     * Returns an add command string for adding the {@code fish}.
     */
    public static String getAddCommand(Fish fish) {
        return AddCommand.COMMAND_WORD + " " + getFishDetails(fish);
    }

    /**
     * Returns the part of command string for the given {@code fish}'s details.
     */
    public static String getFishDetails(Fish fish) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + fish.getName().fullName + " ");
        sb.append(PREFIX_PHONE + fish.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + fish.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + fish.getAddress().value + " ");
        fish.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditFishDescriptor}'s details.
     */
    public static String getEditFishDescriptorDetails(EditFishDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getAddress().ifPresent(address -> sb.append(PREFIX_ADDRESS).append(address.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_TAG);
            } else {
                tags.forEach(s -> sb.append(PREFIX_TAG).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}

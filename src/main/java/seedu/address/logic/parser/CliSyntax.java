package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_LAST_FED_DATE = new Prefix("lfd/");
    public static final Prefix PREFIX_SPECIES = new Prefix("s/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* Task prefixes */
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("d/");
}

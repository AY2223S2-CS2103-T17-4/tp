package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Fish prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_LAST_FED_DATE = new Prefix("lfd/");
    public static final Prefix PREFIX_SPECIES = new Prefix("s/");
    public static final Prefix PREFIX_FEEDING_INTERVAL = new Prefix("fi/");
    public static final Prefix PREFIX_TAG = new Prefix("tg/");
    public static final Prefix PREFIX_TANK = new Prefix("tk/");

    /* Task prefixes */
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("d/");
}

package seedu.address.model.tank.readings;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.LocalDateTime;

import seedu.address.model.date.DateUtil;
import seedu.address.model.tank.Tank;

/**
 * abstract class for Readings
 */
abstract class Reading {

    public static final String MESSAGE_CONSTRAINTS =
            "Last Fed Date is a date time in the format of dd/mm/yyyy";
    public static final String VALIDATION_REGEX = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    public final String dateString;
    public final LocalDate localDate;
    public final String alphaNumericDate;
    public final String timeString;
    public final LocalDateTime localTime;
    public final String alphaNumericTime;
    public final Tank tank;

    /**
     * Constructor for reading
     * @param date date reading was recorded
     * @param tank the tank this reading belongs to
     */
    public Reading(String date, String time, Tank tank) {
        requireNonNull(date);
        checkArgument(isValidReading(date), MESSAGE_CONSTRAINTS);
        dateString = date;
        localDate = DateUtil.parseStringToDate(date);
        alphaNumericDate = DateUtil.getTaskDescriptionDateFormat(localDate);
        timeString = time;
        localTime = DateUtil.parseStringToTime(time);
        alphaNumericTime = DateUtil.getTimeFormat(localTime);
        this.tank = tank;
    }

    public boolean isValidReading(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    public abstract boolean equals(Object other);

    public abstract int hashcode();

    @Override
    public String toString() {
        return dateString;
    }

}

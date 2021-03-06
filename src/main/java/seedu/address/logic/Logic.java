package seedu.address.logic;

import java.nio.file.Path;

import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.InvalidCommandModeException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.activity.Activity;
import seedu.address.model.person.Person;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException, InvalidCommandModeException;

    /**
     * Returns the AddressBook.
     *
     * @see seedu.address.model.Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /** Returns an unmodifiable view of the filtered list of activities */
    ObservableList<Activity> getFilteredActivityList();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Person> getFilteredPersonList();


    /**
     * Returns an unmodifiable view of the list of commands entered by the user.
     * The list is ordered from the least recent command to the most recent command.
     */
    ObservableList<String> getHistory();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Selected person in the filtered person list.
     * null if no person is selected.
     *
     * @see seedu.address.model.Model#selectedPersonProperty()
     */
    ReadOnlyProperty<Person> selectedPersonProperty();

    /**
     * Sets the selected person in the filtered person list.
     *
     * @see seedu.address.model.Model#setSelectedPerson(Person)
     */
    void setSelectedPerson(Person person);

    /**
     * Selected activity in the filtered activity list.
     * null if no activity is selected.
     *
     * @see seedu.address.model.Model#selectedActivityProperty()
     */
    ReadOnlyProperty<Activity> selectedActivityProperty();

    /**
     * Sets the selected activity in the filtered person list.
     *
     * @see seedu.address.model.Model#setSelectedActivity(Activity)
     */
    void setSelectedActivity(Activity activity);

    /**
     * Reset all lists.
     */
    void callAllListFn();

    /**
     * Check if current mode is Member
     * Assuming mode has changed
     */
    boolean modeHasChange_isCurrModeMember();

    /**
     * Check if current mode is Activity
     * Assuming mode has changed
     */
    boolean modeHasChange_isCurrModeActivity();

    /**
     * Returns a list of person attending the activity
     */
    ObservableList<Person> getAttendingOfSelectedActivity();

    /**
     * Returns list of Persons not attending the activity
     */
    ObservableList<Person> getPersonNotInSelectedActivity();

    /**
     * Returns list of activities attended by Person
     */
    ObservableList<Activity> getActivitiesOfPerson();

    /**
     * Returns the number of activities attended by the member.
     */
    int getAttendedActivitiesCounter(Person person);

    /**
     * Return participation rate of the member.
     */
    int getParticipationRate(Person person);
}

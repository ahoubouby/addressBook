package com.ahoubouby.utils;
/*
 * ahoubouby created on 10/10/20
 * E-MAIL: ahoubouby@gmail.com
 */


import com.ahoubouby.configs.FileDataSource;
import com.ahoubouby.dao.AddressBookDAO;
import com.ahoubouby.model.Contact;
import com.ahoubouby.model.ContactBuilder;
import com.ahoubouby.model.PhoneNumber;
import com.sun.org.apache.xerces.internal.impl.dv.xs.AbstractDateTimeDV;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.ahoubouby.configs.PropertiesLoader.*;
import static com.ahoubouby.utils.Commands.*;
import static com.ahoubouby.utils.Messages.*;

public class CommandLineHelper {

    //********** messages **********// 
    private static final String DIVIDER = "===================================================";
    private static final int DIVIDER_SIZE = DIVIDER.length();
    private static final String VERSION = "AddessBook Level 1 - Version 1.0";


    private static final char INPUT_INIT_PAST_MODE = '>';
    private static final char INPUT_FINISH_PAST_MODE = '<';
    private static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format: %1$s " + LS + "%2$s";


    private static final String PERSON_DATA_PREFIX_PHONE = "p/";
    private static final String PERSON_DATA_PREFIX_EMAIL = "e/";
    private static final String COMMAND_ADD_PARAMETERS = "NAME "
            + PERSON_DATA_PREFIX_PHONE + "PHONE_NUMBER "
            + PERSON_DATA_PREFIX_EMAIL + "EMAIL";
    private static final String COMMAND_ADD_EXAMPLE = COMMAND_ADD_WORD + "John Doe p/98765432 e/johnd@gmail.com";


    //********** end of messages **********//

    private static String storageFilePath;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static FileDataSource fileDataSource = null;
    private static AddressBookDAO addressBookDAO = null ;

    public static void showWelcomeMessage() {
        showToUser(DIVIDER, DIVIDER, VERSION, MESSAGE_WELCOME, DIVIDER);
    }

    public static void showToUser(String... message) {
        Stream.of(message)
                .forEach(msg ->
                        System.out.println(LINE_PREFIX + msg
                                + StringUtils.leftPad(" ", DIVIDER_SIZE - msg.length() + 1)
                                + LINE_PREFIX));
    }

    public static void showFieldName (String filedName) {
        System.out.println(filedName +"#");
    }
    public static void exitProgram() {
        showToUser(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
        System.exit(0);
    }

    private static void createFileIfMissing(String filePath) {
        try {
            final File storageFile = new File(filePath);
            fileDataSource = FileDataSource.getInstance(storageFile);
            addressBookDAO = AddressBookDAO.getInstance(fileDataSource);
            if (storageFile.exists()) {
                return;
            }
            //TODO: change message 
            showToUser(String.format(MESSAGE_ERROR_MISSING_STORAGE_FILE, filePath));
            if (storageFile.createNewFile()) {
                showToUser(String.format(MESSAGE_STORAGE_FILE_CREATED, filePath));
            }
        } catch (IOException ioe) {
            showToUser(String.format(MESSAGE_ERROR_CREATING_STORAGE_FILE, filePath));
            exitProgram();
        }
    }


    private static void setupDefaultFileForStorage() {
        //TODO change string 
        showToUser(MESSAGE_USING_DEFAULT_FILE);
        storageFilePath = getConfigInstance().get(FILE_PATH) + File.separator + getConfigInstance().get(FILE_NAME);
        createFileIfMissing(storageFilePath);
    }


    public static void processProgramArgs(String[] args) {
        if (args.length > 2) {
            showToUser(MESSAGE_INVALID_PROGRAM_ARGS);
            exitProgram();
        }
        if (args.length == 2) {
            setupGivenFileForStorage(args[0], args[1]);
        }
        if (args.length == 0) {
            setupDefaultFileForStorage();
        }
    }

    private static boolean hasValidParentDirectory(Path filePath) {
        Path parentDirectory = filePath.getParent();
        return parentDirectory == null || Files.isDirectory(parentDirectory);
    }

    private static boolean hasValidFileName(Path filePath) {
        return filePath.getFileName().toString().lastIndexOf('.') > 0
                && (!Files.exists(filePath) || Files.isRegularFile(filePath));
    }

    public static boolean isValidFilePath(String filePath) {
        if (null == filePath) {
            return false;
        }
        Path filePathToValidate;
        try {
            filePathToValidate = Paths.get(filePath);
        } catch (InvalidPathException ipe) {
            return false;
        }
        return hasValidParentDirectory(filePathToValidate) && hasValidFileName(filePathToValidate);
    }


    public static void setupGivenFileForStorage(String path, String fileName) {
        storageFilePath = path + File.separator + fileName;
        if (!isValidFilePath(storageFilePath)) {
            showToUser(String.format(MESSAGE_INVALID_FILE, storageFilePath));
            exitProgram();
        }
        createFileIfMissing(storageFilePath);
    }

    public static String getUserInput() {
        System.out.print(LINE_PREFIX + "Enter command: ");
        String next = SCANNER.nextLine();
        StringBuffer inputLine = new StringBuffer(next);

        boolean isPasteModeOn = next.trim().charAt(0) == INPUT_INIT_PAST_MODE;
        // silently consume all blank and comment lines
        while (isPasteModeOn) {
            next = SCANNER.nextLine();
            inputLine.append(next);
            inputLine.append(System.lineSeparator());
            isPasteModeOn = !(next.trim().charAt(0) == INPUT_FINISH_PAST_MODE);
        }
        return inputLine.toString();
    }

    public static void echoUserCommand(String userCommand) {
        showToUser("[Command entered:" + userCommand + "]");
    }


    private static String getMessageForInvalidCommandInput(String userCommand, String correctUsageInfo) {
        return String.format(MESSAGE_INVALID_COMMAND_FORMAT, userCommand, correctUsageInfo);
    }

    /**
     * plits raw user input into command word and command arguments string
     *
     * @param rawUserInput
     * @return
     */
    private static String[] splitCommandWordAndArgs(String rawUserInput) {
        final String[] split = rawUserInput.trim().split("\\s+", 2);
        return split.length == 2 ? split : new String[]{split[0], ""}; // else case: no parameters
    }


    private static String getUsageInfoForAddCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_ADD_WORD, COMMAND_ADD_DESC) + LS
                + String.format(MESSAGE_COMMAND_HELP_PARAMETERS, COMMAND_ADD_PARAMETERS) + LS
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_ADD_EXAMPLE) + LS;
    }

    /**
     * Returns the string for showing 'find' command usage instruction
     */
    private static String getUsageInfoForFindCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_FIND_WORD, COMMAND_FIND_DESC) + LS
                + String.format(MESSAGE_COMMAND_HELP_PARAMETERS, COMMAND_FIND_PARAMETERS) + LS
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_FIND_EXAMPLE) + LS;
    }

    /**
     * Returns the string for showing 'delete' command usage instruction
     */
    private static String getUsageInfoForDeleteCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_DELETE_WORD, COMMAND_DELETE_DESC) + LS
                + String.format(MESSAGE_COMMAND_HELP_PARAMETERS, COMMAND_DELETE_PARAMETER) + LS
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_DELETE_EXAMPLE) + LS;
    }

    /**
     * Returns string for showing 'clear' command usage instruction
     */
    private static String getUsageInfoForClearCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_CLEAR_WORD, COMMAND_CLEAR_DESC) + LS
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_CLEAR_EXAMPLE) + LS;
    }

    /**
     * Returns the string for showing 'view' command usage instruction
     */
    private static String getUsageInfoForViewCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_LIST_WORD, COMMAND_LIST_DESC) + LS
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_LIST_EXAMPLE) + LS;
    }

    /**
     * Returns string for showing 'help' command usage instruction
     */
    private static String getUsageInfoForHelpCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_HELP_WORD, COMMAND_HELP_DESC)
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_HELP_EXAMPLE);
    }

    /**
     * Returns the string for showing 'exit' command usage instruction
     */
    private static String getUsageInfoForExitCommand() {
        return String.format(MESSAGE_COMMAND_HELP, COMMAND_EXIT_WORD, COMMAND_EXIT_DESC)
                + String.format(MESSAGE_COMMAND_HELP_EXAMPLE, COMMAND_EXIT_EXAMPLE);
    }


    private static String getUsageInfoForAllCommands() {
        return getUsageInfoForAddCommand() + LS
                + getUsageInfoForFindCommand() + LS
                + getUsageInfoForViewCommand() + LS
                + getUsageInfoForDeleteCommand() + LS
                + getUsageInfoForClearCommand() + LS
                + getUsageInfoForExitCommand() + LS
                + getUsageInfoForHelpCommand();
    }

    private static String executeAddContact(String surName ) {
        ContactBuilder contactBuilder = ContactBuilder.builder();

        showFieldName("name");
        contactBuilder.withName(SCANNER.nextLine());
        showFieldName("surname");
        contactBuilder.withSurname(SCANNER.nextLine());
        showFieldName("PhoneNumber");
        contactBuilder.withPhoneNumber(new PhoneNumber(SCANNER.nextLine()));
        return contactBuilder.build().toString() ;
    }

    public static String executeCommand(String userInputString) {
        final String[] commandTypeAndParams = splitCommandWordAndArgs(userInputString);
        final String commandType = commandTypeAndParams[0];
        final String commandArgs = commandTypeAndParams[1];
        switch (commandType) {
            case COMMAND_ADD_WORD:
                return executeAddContact(commandArgs);

//            case COMMAND_FIND_WORD:
//                return executeFindPersons(commandArgs);
//            case COMMAND_LIST_WORD:
//                return executeListAllPersonsInAddressBook();
//            case COMMAND_DELETE_WORD:
//                return executeDeletePerson(commandArgs);
//            case COMMAND_CLEAR_WORD:
//                return executeClearAddressBook();
//            case COMMAND_HELP_WORD:
//                return getUsageInfoForAllCommands();
//            case COMMAND_EXIT_WORD:
//                executeExitProgramRequest();
            // Fallthrough
            default:
                return getMessageForInvalidCommandInput(commandType, getUsageInfoForAllCommands());
        }
    }


}

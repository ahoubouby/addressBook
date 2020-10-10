package com.ahoubouby.utils;
/*
 * ahoubouby created on 10/10/20
 * E-MAIL: ahoubouby@gmail.com
 */

 interface Messages {
     String LINE_PREFIX = "|| ";
     String LS = System.lineSeparator() + LINE_PREFIX;
     String MESSAGE_INVALID_PROGRAM_ARGS = "Too many parameters! Correct program argument format:"
            + LS + "\tjava AddressBook"
            + LS + "\tjava AddressBook [custom storage file path]";

     String MESSAGE_GOODBYE = "Exiting Address Book... Good bye!";
     String MESSAGE_INVALID_FILE = "The given file name [%1$s] is not a valid file name!";
     String DEFAULT_STORAGE_FILEPATH = "contacts.txt";
     String MESSAGE_USING_DEFAULT_FILE = "Using default storage file : " + DEFAULT_STORAGE_FILEPATH;
     String MESSAGE_WELCOME = "Welcome to your Address Book!";
     String MESSAGE_ERROR_MISSING_STORAGE_FILE = "Storage file missing: %1$s";
     String MESSAGE_STORAGE_FILE_CREATED = "Created new empty storage file: %1$s";
     String MESSAGE_ERROR_CREATING_STORAGE_FILE = "Error: unable to create file: %1$s";
     String MESSAGE_COMMAND_HELP = "%1$s: %2$s";
     String MESSAGE_COMMAND_HELP_PARAMETERS = "\tParameters: %1$s";
     String MESSAGE_COMMAND_HELP_EXAMPLE = "\tExample: %1$s";

}

package com.ahoubouby.utils;
/*
 * ahoubouby created on 10/10/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.ahoubouby.model.Contact;

public interface Commands {


     String COMMAND_ADD_WORD = "add";
     String COMMAND_ADD_DESC = "Adds a person to the address book.";
     
     String COMMAND_FIND_WORD = "find";
     String COMMAND_FIND_DESC = "Finds all persons whose names contain any of the specified "
            + "keywords (case-sensitive) and displays them as a list with index numbers.";
     
     
     String COMMAND_FIND_PARAMETERS = "KEYWORD [MORE_KEYWORDS]";
     String COMMAND_FIND_EXAMPLE = COMMAND_FIND_WORD + " alice bob charlie";

     String COMMAND_DELETE_WORD = "delete";
     String COMMAND_DELETE_DESC = "Deletes a person identified by surname";
     String COMMAND_DELETE_PARAMETER = "INDEX";
     String COMMAND_DELETE_EXAMPLE = COMMAND_DELETE_WORD + " 1";


     String COMMAND_CLEAR_WORD = "clear";
     String COMMAND_CLEAR_DESC = "Clears address book permanently.";
     String COMMAND_CLEAR_EXAMPLE = COMMAND_CLEAR_WORD;

     String COMMAND_HELP_WORD = "help";
     String COMMAND_HELP_DESC = "Shows program usage instructions.";
     String COMMAND_HELP_EXAMPLE = COMMAND_HELP_WORD;

     String COMMAND_LIST_WORD = "list";
     String COMMAND_LIST_DESC = "Displays all persons as a list with index numbers.";
     String COMMAND_LIST_EXAMPLE = COMMAND_LIST_WORD;

     String COMMAND_EXIT_WORD = "exit";
     String COMMAND_EXIT_DESC = "Exits the program.";
     String COMMAND_EXIT_EXAMPLE = COMMAND_EXIT_WORD;
}

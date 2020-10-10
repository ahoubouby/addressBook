package com.ahoubouby;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */


import com.ahoubouby.model.*;
import com.google.common.base.Optional;

import java.io.*;

import static com.ahoubouby.utils.CommandLineHelper.*;

public class AddressBook {

    public static void main(String[] args) {
        showWelcomeMessage();
        processProgramArgs(args);
        while (true) {
            String userCommand = getUserInput();
            echoUserCommand(userCommand);
            String feedback = executeCommand(userCommand);
            System.out.println(feedback);
            // showResultToUser(feedback);*/
        }

    }
}

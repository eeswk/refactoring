package com.swan.ee.extractmethod.qna;

public class QnaRefactoring {
    private String name;
    private static final int RETRY = 3;

    public void processUserRequest() throws InvalidInputException {
        String hostname = getStringWithPrompt("Host");
        String username = getStringWithPrompt("User");
        postRequest(hostname, username);
    }

    private String getStringWithPrompt(String prompt) throws InvalidInputException {
        for (int i = 0; i < RETRY; i++) {
            showPrompt(prompt);
            String input = getString();
            if (input != null) {
                return input;
            }
        }
        throw new InvalidInputException();
    }


    private void postRequest(String hostname, String username) {
        System.out.println("hostname : " + hostname  + ", username : " + username);
    }

    private void showPrompt(String input) {
        name = input;
    }

    private String getString() {
        if (name.equals("Host")) {
            return "ee.swan.com";
        } else {
            return "eeswan";
        }
    }
}

package com.swan.ee.extractmethod.qna;

public class Qna {
    private String name;

    public void processUserRequest() throws InvalidInputException {
        boolean flag;

        //hostname 얻기
        String hostname = null;
        flag = true;

        for (int i = 0; flag && i < 3; i++) {
            showPrompt("Host");
            hostname = getString();
            if (hostname != null){
                flag = false;
            }
        }
        if (flag) {
            throw new InvalidInputException();
        }

        //username 얻기
        String username = null;
        flag = true;

        for (int i = 0; flag && i < 3; i++) {
            showPrompt("User");
            username = getString();
            if (username != null){
                flag = false;
            }
        }
        if (flag) {
            throw new InvalidInputException();
        }

        postRequest(hostname, username);
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

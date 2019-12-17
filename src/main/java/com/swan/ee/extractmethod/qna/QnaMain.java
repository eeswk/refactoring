package com.swan.ee.extractmethod.qna;

public class QnaMain {
    public static void main(String[] args) {
        Qna qna = new Qna();
        try {
            qna.processUserRequest();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

        QnaRefactoring qnaRefactoring = new QnaRefactoring();
        try {
            qnaRefactoring.processUserRequest();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

    }
}

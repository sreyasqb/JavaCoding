/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws4;

/**
 *
 * @author 20pt33
 */
abstract class Question {

    private String myText;

    Question(String s) {
        myText = s;
    }

    public String getText() {
        return myText;
    }

    public abstract String getQuestion();

    public abstract String getAnswer();

    public abstract boolean checkAnswer(String answer);
}

class ShortAnswerQuestion extends Question {

    String myAnswer;

    ShortAnswerQuestion(String text) {
        super(text);
    }

    @Override
    public String getQuestion() {
        String text = getText();
        return text;
    }

    @Override
    public String getAnswer() {
        return myAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return getAnswer().equalsIgnoreCase(answer);
    }

}

class FilInBlankQuestion extends Question {

    String myAnswer;

    FilInBlankQuestion(String text) {
        super(text);
    }

    @Override
    public String getQuestion() {
        String text = getText()+"\nFill in the blank.";
        return text;
    }

    @Override
    public String getAnswer() {
        return myAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return getAnswer().equalsIgnoreCase(answer);
    }

    class TrueFalseQuestion extends Question {

        boolean myAnswer;

        TrueFalseQuestion(String text, boolean ans) {
            super(text);
            myAnswer = ans;
        }

        @Override
        public String getQuestion() {
            String text = getText()+"\nIs this statement true or false?";
            return text;
        }
        @Override
        public String getAnswer(){
           return new Boolean(myAnswer).toString();
        }
        @Override
        public boolean checkAnswer(String answer){
            return getAnswer().equalsIgnoreCase(answer);
        }
        
    }

}

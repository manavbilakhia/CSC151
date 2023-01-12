package assignment;

import java.util.Hashtable;

public class QuizHashTable {
    private Hashtable<String, QA> quiz;

    /**
     * Constructs a QuizHashTable from a string of questions
     *
     * @param quizStr A string of "-" seperated questions
     */
    public QuizHashTable(String quizStr) {


        this.quiz = new Hashtable<>();
        String[] questions = quizStr.split("-");

        for (String question : questions) {
            QA qa = new QA(question);
            quiz.put(qa.getQid(), qa);
        }
    }

    public String ask(String qid, String answerSequence) {
        String res = new String();
        QA currentQuestion = quiz.get(qid);
        for (Character answer : answerSequence.toCharArray()) {
            res += currentQuestion.getText();

            if (answer == 'Y') {
                res += answer;
                currentQuestion = quiz.get(currentQuestion.getYesQID());
            } else if (answer == 'N') {
                res += answer;
                currentQuestion = quiz.get(currentQuestion.getNoQID());
            }

            res += "\n";
        }

        res += currentQuestion.getText();

        return res;
    }

    @Override
    public String toString() {
        String res = new String();
        for ( QA qa : quiz.values()) {
            res += qa.toString();
        }

        return res;
    }

    public static void main(String[] args) {
        //All questions are given in rawQ String
        final String rawQ = "Q1,Is it big?,Q2,Q5-Q2,Is it white?,Q3,Q4-Q3,Whale, ,-Q4,Cat, ,-Q5,Is it an animal?,Q6,Q7-Q6,Ant, ,-Q7,Dust, ,";
        //Possible answers from the user
        final String ans1 = "YY";
        final String ans2 = "YN";
        final String ans3 = "NY";
        final String ans4 = "NN";
        //First get all questions and in the constructor split them.
        //Use - as the separator.
        //Store the parts that correspond to single questions in the array
        // For each question(array element) call the constructor of QA and create a QA object.
        // QA constructor gets a String parameter and splits it into parts by using , as the separator
        //Insert these QA objects into Hashtable quiz by using the qid field as the key and QA object as the value
        QuizHashTable qz = new QuizHashTable(rawQ);
        //res is the output you will generate and return from the ask method
        String res;
        // ask method gets a question id to start and an answer sequence
        //For the following start from question whose id is Q1 and answer sequence is ans1 i.e. YY
        res = qz.ask("Q1", ans1);
        System.out.println(res);
        // Q1 is Is it big?
        // and first answer is Y
        //So ask the question Is it an animal?
        //and the second answer is Y
        //Since there is no more question stop and give the answer as the text of the current QA object whichis Ant
        //Output res will be
        /*
        Is it big?Y
        Is it an animal?Y
        Ant
        */
        res = qz.ask("Q1", ans2);
        System.out.println(res);
        // See the explanations above for details. This time we start again from Q1 but answer sequence ans2 is YN
        //Output is
        /*
        Is it big?Y
        Is it white?N
        Cat
        */
        res = qz.ask("Q1", ans3);
        System.out.println(res);
        // See the explanations above for details. This time we start again from Q1 but answer sequence ans3 is NY
        //Output is
        /*
        Is it big?N
        Is it an animal?Y
        Ant
        */
        res = qz.ask("Q1", ans4);
        System.out.println(res);
        // See the explanations above for details. This time we start again from Q1 but answer sequence ans4is NN
        //Output is
        /*
        Is it big?N
        Is it an animal?N
        Dust
        */

    }
}

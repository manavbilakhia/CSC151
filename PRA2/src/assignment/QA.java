package assignment;

public class QA {

    private String qid;
    private String text;
    private String yesQID;
    private String noQID;

    /**
     * Default constructor, initializes QA with default calues
     */
    public QA() {
        this.qid = "";
        this.text = "";
        this.yesQID = "";
        this.noQID = "";
    }

    /**
     * Parameterized Constructor
     * @param qid the question ID
     * @param text the text of the question
     * @param yesQID the question to go to when the user answers yes to this question
     * @param noQID the question to go to when the user answers no to this question
     */
    public QA(String qid, String text, String yesQID, String noQID) {
        this.qid = qid;
        this.text = text;
        this.yesQID = yesQID;
        this.noQID = noQID;
    }

    /**
     * A constructor that parses a string representation of the question
     * @param qString a string in the format of qid,text,yesQID,noQID (e.g. Q1,Is it big?,Q2,Q5)
     */
    public QA(String qString) {
        String[] parts = qString.split(",", 4);
        if (parts.length != 4) {
            return;
        }

        this.qid = parts[0];
        this.text = parts[1];
        this.yesQID = parts[2];
        this.noQID = parts[3];
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getYesQID() {
        return yesQID;
    }

    public void setYesQID(String yesQID) {
        this.yesQID = yesQID;
    }

    public String getNoQID() {
        return noQID;
    }

    public void setNoQID(String noQID) {
        this.noQID = noQID;
    }

    @Override
    public String toString() {
        return "qid=" + getQid() + "\ntext=" + getText() + "\nYesQID=" + getYesQID() + "\nNoQID=" + getNoQID() + "\n";
    }

    public static void main(String[] args) {

    }
}

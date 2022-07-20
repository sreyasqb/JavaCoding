import java.util.ArrayList;
import java.util.List;

class Student {
    String name;

    List<Integer> scores=new ArrayList();

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addQuiz(int s) {
        scores.add(s);
    }

    public int getTotalScore() {
        int t = 0;
        for (int i : scores) {
            t += i;
        }
        return t;
    }
    public double averageScore(){
        int t = 0;
        for (int i : scores) {
            t += i;
        }
        return (double) t/scores.size();
    }

    public static void main(String argv[]) {
        Student s = new Student("sreyas");
        s.addQuiz(5);
        s.addQuiz(20);
        System.out.println(s.getTotalScore());
        System.out.println(s.averageScore());

    }
}

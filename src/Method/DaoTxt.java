package Method;

import java.io.FileWriter;
import java.io.IOException;

public class DaoTxt {
	private static String answerPath = "D:\\answerfile.txt";
	private static String correctPath = "D:\\Grade.txt";
	private static String tiPath = "D:\\exercisefile.txt";
    private static void saveAsFileWriter(String content,String path) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(path, true);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void clear(String path) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(path, false);
            fwriter.write("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void saveAnswer(String content) {
    	saveAsFileWriter(content,answerPath);
    }
    public void saveGrade(String content) {
    	saveAsFileWriter(content,correctPath);
    }
    public void saveExercise(String content) {
    	saveAsFileWriter(content,tiPath);
    }
    public void clearAll() {
    	clear(answerPath);
    	clear(correctPath);
    	clear(tiPath);
    }
}

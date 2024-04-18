package File_write_44;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/File_write_44/testFile");
        PrintWriter pw = new PrintWriter(file);

        pw.println("Sosi poka dayout");
        pw.println("Test row 2");

        pw.close();
    }
}

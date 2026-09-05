import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        for (int i = 1; i <= 6; i++) {
            X = i;
            if (X % 2 != 0) {
                System.out.println(X);
            }
        }
    }
}

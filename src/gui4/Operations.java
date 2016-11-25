package gui4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Operations {

    public boolean checkPesel(String peselNr) {
        int wages[] = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;
        int number = 0;
        int peselCalculatedValue = 0;

        for (int i = 0; i < peselNr.length() - 1; i++) {
            number = Character.getNumericValue(peselNr.charAt(i));
            sum += (number * wages[i]);
        }

        peselCalculatedValue = 10 - (sum % 10);
        if (peselCalculatedValue == 10) {
            peselCalculatedValue = 0;
        }

        if (peselCalculatedValue == Character.getNumericValue(peselNr.charAt(10))) {
            return true;
        } else {
            return false;
        }
    }

    public void writeToFile(String peselNr) {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Poprawne numery PESEL.txt", true)));
            printWriter.write(peselNr);
            printWriter.write(System.getProperty("line.separator"));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

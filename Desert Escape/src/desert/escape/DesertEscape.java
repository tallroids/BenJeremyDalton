package desert.escape;

import byui.cit260.desertEscape.model.Game;
import byui.cit260.desertEscape.model.Player;
import byui.cit260.desertEscape.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy, Dalton, Ben
 */
public class DesertEscape {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    public static void main(String[] args) {

        try {

            // open stream for input and output
            inFile = new BufferedReader(new InputStreamReader(System.in));
            outFile = new PrintWriter(System.out, true);

            // open log file
            String filePath = "log.txt";
            logFile = new PrintWriter(filePath);

            StartProgramView startProgramView = new StartProgramView();

            startProgramView.display();
            startProgramView.display();
        } catch (Throwable te) {
            outFile.println("Exception: " + te.toString()
                            + "\nCause: " + te.getCause()
                            + "\nMessage: " + te.getMessage());
            te.printStackTrace();
            
        } finally {
            try {
                if (inFile != null) {
                    inFile.close();
                }

                if (outFile != null) {
                    outFile.close();
                }

                if (logFile != null) {
                    logFile.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }

        }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        DesertEscape.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        DesertEscape.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        DesertEscape.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        DesertEscape.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        DesertEscape.logFile = logFile;
    }

}

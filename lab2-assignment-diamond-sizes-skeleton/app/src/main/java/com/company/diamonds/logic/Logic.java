package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int n) {

        // TODO -- add your code here
        for (int i = -n; i <= n; i++) {
            for (int j = -n - 1; j <= n + 1; j++)
                // skip middle vertical
                if (j == 0) mOut.print("");
                    // borders:
                    // vertical borders
                else if (Math.abs(j) == n + 1) {
                    if (Math.abs(i) == n) mOut.print("+");
                    else mOut.print("|");
                }
                    // horizontal borders
                else if (Math.abs(i) == n) {
                    mOut.print("-");
                }
                    // rhombus:
                    // left middle horizontal ending
                else if (i == 0 && j == -n) {
                    mOut.print("<");
                }
                    // right middle horizontal ending
                else if (i == 0 && j == n) mOut.print(">");
                    // upper right and lower left borders
                else if (Math.abs(i - j) == n) mOut.print("\\");
                    // upper left and lower right borders
                else if (Math.abs(i + j) == n) mOut.print("/");
                    // inner rhombus lines
                else if (Math.abs(i) + Math.abs(j) < n) {
                    // double central line for odd n
                    if ((n - i) % 2 != 0) mOut.print("=");
                    else mOut.print("-");
                }
                    // whitespace
                else mOut.print(" ");
            // new line
            mOut.println("");
        }
    }
}

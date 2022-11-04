package configurations;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Robot {

    public static void uploadFile(String path) {

        toolkit(path);
        java.awt.Robot robot = null;

        try {
            robot = new java.awt.Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.delay(500);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void toolkit(String file) {
        StringSelection selection = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
    }
}
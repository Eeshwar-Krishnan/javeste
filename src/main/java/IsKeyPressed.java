
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class IsKeyPressed {
    private static volatile boolean wPressed = false;
    public static boolean isWPressed() {
        synchronized (IsKeyPressed.class) {
            return wPressed;
        }
    }

    public static void start() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(ke -> {
            synchronized (IsKeyPressed.class) {
                System.out.println(ke.getID());
                switch (ke.getID()) {
                case KeyEvent.KEY_PRESSED:
                    if (ke.getKeyCode() == KeyEvent.VK_W) {
                        wPressed = true;
                    }
                    break;

                case KeyEvent.KEY_RELEASED:
                    if (ke.getKeyCode() == KeyEvent.VK_W) {
                        wPressed = false;
                    }
                    break;
                }
                return false;
            }
        });
    }
}

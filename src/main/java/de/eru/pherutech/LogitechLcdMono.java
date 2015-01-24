package de.eru.pherutech;

import de.eru.pherutech.exceptions.NoKeyboardConnectedException;
import de.eru.pherutech.exceptions.PixelsOutOfLcdSizeException;

/**
 *
 * @author Philipp Bruckner
 */
public class LogitechLcdMono {

    public static final int LCD_PIXEL_SIZE = 160 * 43;

    public enum LineNumber {
        ONE, TWO, THREE, FOUR
    }

    private static native boolean supportsApplet();
    private static native boolean startApplet();
    private static native boolean stopApplet();
    private static native void paintPixels(byte[] pixels);
    private static native void writeLine(int lineNumber, String text);

    private static String libraryPath = "LogitechLCD.dll"; //TODO mit ins Jar packen?
    
    public static boolean isSupported() {
        return supportsApplet();
    }

    public static void start() throws NoKeyboardConnectedException, UnsatisfiedLinkError { //TODO falls im Jar, ULE unnötig
        System.load(libraryPath);
        if (!startApplet()) {
            throw new NoKeyboardConnectedException("No Logitech-Keyboard connected!");
        }
    }

    public static boolean stop() { //TODO kann stoppen schiefgehen?
        return stopApplet();
    }

    public static void paint(byte[] pixels) throws PixelsOutOfLcdSizeException {
        if (pixels.length <= LCD_PIXEL_SIZE) {
            paintPixels(pixels);
        } else {
            throw new PixelsOutOfLcdSizeException("Pixel-Array out of size! Maximum-size: " + LCD_PIXEL_SIZE + ".");
        }
    }

    public static void write(LineNumber lineNumber, String text) {
        writeLine(lineNumber.ordinal() + 1, text);
    }

    public static String getLibraryPath() {
        return libraryPath;
    }

    public static void setLibraryPath(String libraryPath) {
        LogitechLcdMono.libraryPath = libraryPath;
    }
}

package de.eru.pherutech;

import de.eru.pherutech.exceptions.NoKeyboardConnectedException;
import de.eru.pherutech.exceptions.PixelsOutOfLcdSizeException;

/**
 *
 * @author Philipp Bruckner
 */
public class LogitechLcdMono {

    private native boolean startApplet();
    private native boolean stopApplet();

    private native void paintPixels(byte[] pixels);

    public void start() throws NoKeyboardConnectedException {
        if (!startApplet()) {
            throw new NoKeyboardConnectedException("TODO");//TODO
        }
    }

    public void paint(byte[] pixels) throws PixelsOutOfLcdSizeException {
        if (pixels.length <= 160 * 43) {
            paintPixels(pixels);
        } else {
            throw new PixelsOutOfLcdSizeException("Zu viele Pixel!!11elf");
        }
    }

    public boolean stop() {
        return stopApplet();
    }
}

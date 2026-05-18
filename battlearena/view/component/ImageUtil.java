package battlearena.view.component;

import javax.swing.ImageIcon;
import java.awt.Image;

public class ImageUtil {
    public static Image loadImage(String percorso) {
        if (percorso == null || percorso.trim().isEmpty()) {
            return null;
        }
        return new ImageIcon(percorso).getImage();
    }

    public static ImageIcon loadIcon(String percorso, int size) {
        Image image = loadImage(percorso);
        if (image == null) {
            return null;
        }
        Image scaled = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}

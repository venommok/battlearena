package battlearena.view.component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

public class BackgroundLabel extends JLabel {
    public BackgroundLabel(String percorso, int width, int height) {
        Image bgImage = ImageUtil.loadImage(percorso);
        if (bgImage != null) {
            Image scaled = bgImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaled));
        }
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout(10, 10));
    }
}

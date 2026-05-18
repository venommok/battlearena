package battlearena.view.component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class CenterPanel extends JPanel {
    public CenterPanel(String nomeP1, String percorsoImgP1, String nomeP2, String percorsoImgP2, Font titleFont, int iconSize) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 10, 40));

        add(Box.createHorizontalGlue());
        add(creaEtichettaPersonaggio(nomeP1, percorsoImgP1, titleFont, iconSize));
        add(Box.createHorizontalGlue());
        add(creaEtichettaPersonaggio(nomeP2, percorsoImgP2, titleFont, iconSize));
        add(Box.createHorizontalGlue());
    }

    private JLabel creaEtichettaPersonaggio(String nome, String percorsoImg, Font titleFont, int iconSize) {
        JLabel label = new JLabel(nome, ImageUtil.loadIcon(percorsoImg, iconSize), JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setIconTextGap(10);
        label.setFont(titleFont);
        return label;
    }
}

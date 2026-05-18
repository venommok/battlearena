package battlearena.view.component;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class HpPanel extends JPanel {
    private final JProgressBar hpBarP1;
    private final JProgressBar hpBarP2;

    public HpPanel(String nomeP1, String nomeP2, Font barFont) {
        hpBarP1 = creaBarraHpBase(nomeP1, barFont);
        hpBarP2 = creaBarraHpBase(nomeP2, barFont);

        setOpaque(false);
        setLayout(new GridLayout(1, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
        add(hpBarP1);
        add(hpBarP2);
    }

    private JProgressBar creaBarraHpBase(String nome, Font barFont) {
        JProgressBar barra = new JProgressBar();
        barra.setStringPainted(true);
        barra.setBorder(BorderFactory.createTitledBorder(nome));
        barra.setFont(barFont);
        barra.setPreferredSize(new Dimension(520, 36));
        return barra;
    }

    public JProgressBar getHpBarP1() {
        return hpBarP1;
    }

    public JProgressBar getHpBarP2() {
        return hpBarP2;
    }
}

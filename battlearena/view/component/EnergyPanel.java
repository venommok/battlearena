package battlearena.view.component;

import javax.swing.*;
import java.awt.*;

public class EnergyPanel extends JPanel {
    private final JProgressBar energyBarP1;
    private final JProgressBar energyBarP2;

    public EnergyPanel(String nomeP1, String nomeP2, Font barFont) {
        energyBarP1 = creaBarraEnergiaBase(nomeP1 + " (Energia)", barFont);
        energyBarP2 = creaBarraEnergiaBase(nomeP2 + " (Energia)", barFont);

        setOpaque(false);
        setLayout(new GridLayout(1, 2, 10, 10));
        // Ridotto il padding top da 100 a 5 per stare sotto gli HP senza sovrapporsi
        setBorder(BorderFactory.createEmptyBorder(5, 20, 0, 20));
        add(energyBarP1);
        add(energyBarP2);
    }

    private JProgressBar creaBarraEnergiaBase(String nome, Font barFont) {
        JProgressBar barra = new JProgressBar();
        barra.setStringPainted(true);
        barra.setBorder(BorderFactory.createTitledBorder(nome));
        barra.setFont(barFont);
        barra.setPreferredSize(new Dimension(520, 36));
        barra.setForeground(Color.BLUE); // Colore blu distintivo per l'energia
        return barra;
    }

    // CORRETTO: Nome sistemato
    public JProgressBar getEnergyBarP1() {
        return energyBarP1;
    }

    public JProgressBar getEnergyBarP2() {
        return energyBarP2;
    }
}
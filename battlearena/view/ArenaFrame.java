package battlearena.view;

import battlearena.model.Mossa;
import battlearena.view.component.BackgroundLabel;
import battlearena.view.component.CenterPanel;
import battlearena.view.component.HpPanel;
import battlearena.view.component.EnergyPanel; // Importato correttamente
import battlearena.view.component.LogPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ArenaFrame extends JFrame implements ArenaView {
    private static final int ICON_SIZE = 220;
    private static final int FRAME_WIDTH = 1440;
    private static final int FRAME_HEIGHT = 900;
    private static final Font TITLE_FONT = new Font("Dialog", Font.BOLD, 22);
    private static final Font BAR_FONT = new Font("Dialog", Font.BOLD, 16);
    private static final Font LOG_FONT = new Font("Dialog", Font.PLAIN, 15);
    private static final Font BUTTON_FONT = new Font("Dialog", Font.BOLD, 16);
    private final JProgressBar hpBarP1;
    private final JProgressBar hpBarP2;
    private final JProgressBar energyBarP1;
    private final JProgressBar energyBarP2;
    private final JTextArea logArea;
    private final JButton turnoButton;

    public ArenaFrame(String nomeP1, String percorsoImgP1, String nomeP2, String percorsoImgP2) {
        super("Battle Arena");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel backgroundLabel = new BackgroundLabel("assets/arena_bg.png", FRAME_WIDTH, FRAME_HEIGHT);
        setContentPane(backgroundLabel);

        // Creazione dei pannelli delle statistiche
        HpPanel hpPanel = new HpPanel(nomeP1 + " (HP)", nomeP2 + " (HP)", BAR_FONT);
        EnergyPanel energyPanel = new EnergyPanel(nomeP1, nomeP2, BAR_FONT);

        // CORREZIONE: Assegnazione corretta delle rispettive barre
        hpBarP1 = hpPanel.getHpBarP1();
        hpBarP2 = hpPanel.getHpBarP2();
        energyBarP1 = energyPanel.getEnergyBarP1();
        energyBarP2 = energyPanel.getEnergyBarP2();

        // Contenitore per mettere HpPanel sopra EnergyPanel a Nord
        JPanel pannelloNord = new JPanel();
        pannelloNord.setOpaque(false);
        pannelloNord.setLayout(new BoxLayout(pannelloNord, BoxLayout.Y_AXIS));
        pannelloNord.add(hpPanel);
        pannelloNord.add(energyPanel);

        CenterPanel centerPanel = new CenterPanel(nomeP1, percorsoImgP1, nomeP2, percorsoImgP2, TITLE_FONT, ICON_SIZE);

        LogPanel bottomPanel = new LogPanel(LOG_FONT, BUTTON_FONT);
        logArea = bottomPanel.getLogArea();
        turnoButton = bottomPanel.getTurnoButton();

        // Inserimento dei componenti principali nel BorderLayout del frame
        add(pannelloNord, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void impostaAzioneTurno(final TurnoListener listener) {
        turnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event) {
                listener.onTurno();
            }
        });
    }

    @Override
    public void aggiornaHpP1(int hpAttuale, int hpMax) {
        hpBarP1.setMaximum(hpMax);
        hpBarP1.setValue(hpAttuale);
    }

    @Override
    public void aggiornaHpP2(int hpAttuale, int hpMax) {
        hpBarP2.setMaximum(hpMax);
        hpBarP2.setValue(hpAttuale);
    }

    // CORREZIONE: Ora modificano le barre dell'energia, non quelle degli HP
    public void aggiornaEnergyP1(int energiaAttuale, int energiaMax) {
        energyBarP1.setMaximum(energiaMax);
        energyBarP1.setValue(energiaAttuale);
    }

    public void aggiornaEnergyP2(int energiaAttuale, int energiaMax) {
        energyBarP2.setMaximum(energiaMax);
        energyBarP2.setValue(energiaAttuale);
    }

    @Override
    public void aggiungiTestoLog(String testo) {
        logArea.append(testo + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    @Override
    public void disabilitaBottoneTurno() {
        turnoButton.setEnabled(false);
    }

    @Override
    public int scegliMossa(String nomeAttaccante, Mossa[] nomiMosse) {
        return JOptionPane.showOptionDialog(this,
                "Scegli la mossa per " + nomeAttaccante,
                "Scelta mossa",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                nomiMosse,
                nomiMosse[0]);
    }

    @Override
    public void mostraSchermataFinePartita(String vincitore) {
        JOptionPane.showMessageDialog(this,
                "Partita terminata! Vincitore: " + vincitore,
                "Fine partita",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostra() {
        setVisible(true);
    }
}
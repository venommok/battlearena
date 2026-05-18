package battlearena.view.component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class LogPanel extends JPanel {
    private final JTextArea logArea;
    private final JButton turnoButton;

    public LogPanel(Font logFont, Font buttonFont) {
        logArea = new JTextArea(9, 50);
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);
        logArea.setFont(logFont);

        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setPreferredSize(new Dimension(1200, 180));

        turnoButton = new JButton("Prossimo Turno");
        turnoButton.setFont(buttonFont);

        setOpaque(false);
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        add(scrollPane, BorderLayout.CENTER);
        add(turnoButton, BorderLayout.SOUTH);
    }

    public JTextArea getLogArea() {
        return logArea;
    }

    public JButton getTurnoButton() {
        return turnoButton;
    }
}

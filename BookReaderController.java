package L3;

import javax.swing.*;
import java.awt.*;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int widht, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        //pane är en behållarkomponent....

        frame.pack();
        frame.setVisible(true);
    }
}

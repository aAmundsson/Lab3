package L3;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int widht, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        SortedListModel<Map.Entry<String, Integer>> sortedList =
                new SortedListModel<>(counter.getWordList());
        JList<Map.Entry<String, Integer>> list = new JList<>(sortedList);
        pane.setLayout(new BorderLayout());
        pane.add(list);
        JScrollPane scrollpane = new JScrollPane(list);
        pane.add(scrollpane);

        JButton button1 = new JButton("Alphabetic");
        //button1.addActionListener();
        JButton button2 = new JButton("Frequency");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        pane.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

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
        
        ButtonGroup sortButton = new ButtonGroup();
        JRadioButton button1 = new JRadioButton("Alphabetic");
        //button1.addActionListener();
        JRadioButton button2 = new JRadioButton("Frequency");
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        sortButton.add(button1);
        sortButton.add(button2);
        
        pane.add(buttonPanel, BorderLayout.SOUTH);
        
        button1.addActionListener(e -> {
        	
        	sortedList.sort((a,b) -> a.getKey().compareTo(b.getKey()));
        	
        	System.out.println("Haha");
        
        });
        button2.addActionListener(e -> {
        	
        	sortedList.sort((a,b) -> b.getValue() - a.getValue());
        	
        	System.out.println("Haha");
        
        });
        
        JTextField search = new JTextField(9);
        JButton searchButton = new JButton("Find");
        JPanel searchPanel = new JPanel(); 
        
        searchPanel.add(searchButton);
        searchPanel.add(search);
        
        pane.add(searchPanel,BorderLayout.NORTH);
        
        searchButton.addActionListener(e -> { 
        	boolean check = false; 
        	list.clearSelection();
        	String string = search.getText().toLowerCase().trim();
        	for(int i=0; i < sortedList.getSize(); i++) {
        		if(sortedList.getElementAt(i).getKey().equals(string)) {
        			list.ensureIndexIsVisible(i);
        			list.setSelectedIndex(i);
        			check = true; 
        			
        			break;
        		}
        	}
    		if(check == false) {	
			JOptionPane.showMessageDialog(null,
	        "Word does not exist",
	        "Error",
	        JOptionPane.QUESTION_MESSAGE);
    		}
            		
        	});
        		
        	
        
        
  
        
        
        frame.pack();
        frame.setVisible(true);
    }
    
    

}

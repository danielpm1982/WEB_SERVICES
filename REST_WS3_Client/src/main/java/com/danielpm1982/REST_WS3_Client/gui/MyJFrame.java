package com.danielpm1982.REST_WS3_Client.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.danielpm1982.REST_WS3_Client.model.ResourcesList;

public class MyJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public MyJFrame(String threadName, ResourcesList resourcesListToShow) {
		super("ResultPanel "+threadName);
	    setLayout(new BorderLayout());
	    JPanel myOnlyPanel = new JPanel(new BorderLayout(0, 10));
	    myOnlyPanel.setBackground(Color.BLACK);
	    JLabel[] JLabelArray = prepareThreeLableResultArray(resourcesListToShow);
	    myOnlyPanel.add(JLabelArray[0], BorderLayout.NORTH);
	    myOnlyPanel.add(JLabelArray[1], BorderLayout.CENTER);
	    myOnlyPanel.add(JLabelArray[2], BorderLayout.SOUTH);
	    this.add(myOnlyPanel,BorderLayout.CENTER);
	}
	private JLabel[] prepareThreeLableResultArray(ResourcesList resourcesList) {
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		label1.setText(resourcesList.getResourcesList().get(0).toString());
		label2.setText(resourcesList.getResourcesList().get(1).toString());
		label3.setText(resourcesList.getResourcesList().get(2).toString());
	    label1.setForeground(Color.GREEN);
	    label2.setForeground(Color.CYAN);
	    label3.setForeground(Color.MAGENTA);
		return new JLabel[]{label1, label2, label3};
	}
}

package shopGUI;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import shopModel.Cart;

import java.math.*;


public class CartFrame extends JFrame{
	
	Cart cart = MenuFrame.cart;
	GoodsTable studentTable;
	
	public CartFrame() {
		// TODO Auto-generated constructor stub
		super("���ﳵ");
		init();
	}
	
	void init(){
		setLocation(200, 200);
		setSize(600, 500);
	       
		setLayout(new FlowLayout(FlowLayout.LEFT));
		initSortPanel();
		
		validate();
		setVisible(true);
	}
	
	
	void initSortPanel(){
		studentTable = new GoodsTable(cart.getgoods());

		JButton deleteButton = new JButton("ɾ��");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.print(studentTable.getsrid());
				cart.removebyID(studentTable.getsrid());
				updatetable();
			}
	    });
		
		
		JButton clearButton = new JButton("���");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "����չ��ﳵ", "����ȷ��", JOptionPane.YES_NO_OPTION)==1) 
					return;
				cart.clearALL();
				updatetable();
				JOptionPane.showMessageDialog(null, "���ﳵ�����");
			}
	    });
		
		JButton inButton = new JButton("����");
		inButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File aFile=new File("./output/cart.txt");
				if (JOptionPane.showConfirmDialog(null, "����"+aFile+"����"+"\nע�⣺��ǰ����Ʒ��Ϣ����ʧ��", "ȷ�ϵ��룿", JOptionPane.YES_NO_OPTION)==1) 
					return; 
				try {
					FileInputStream fileInputStream=new FileInputStream(aFile);
					ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
					Cart newcart=(Cart)objectInputStream.readObject();
					MenuFrame.cart=newcart;
					MenuFrame.buyframe.cart=newcart;
					MenuFrame.cartframe.cart=newcart;
					MenuFrame.qryframe.cart=newcart;
					JOptionPane.showMessageDialog(null, "����ɹ�");
				} catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "����ʧ��");
				} 
				updatetable();
				
			}
	    });
		
		JButton outButton = new JButton("����");
		outButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				File file = new File("./output/cart.txt");
//				try (PrintWriter output = new PrintWriter(file);) {
//					output.print("John T Smith ");
//					output.println(90);
//					output.print("Eric K Jones ");
//					output.println(85);
//				} catch (FileNotFoundException e1) {
//					e1.printStackTrace();
//				}
				File aFile=new File("./output/cart.txt");
				if (JOptionPane.showConfirmDialog(null, "��������"+aFile, "ȷ�ϵ�����", JOptionPane.YES_NO_OPTION)==1) 
					return; 
		        FileOutputStream fileOutputStream=null;
		        try {
		            fileOutputStream = new FileOutputStream(aFile);
		            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		            objectOutputStream.writeObject(cart);
		            objectOutputStream.flush();
		            objectOutputStream.close();
		            JOptionPane.showMessageDialog(null, "�����ɹ�");
		        } catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "����ʧ��");
		    	} 
		        
			}
	    });
		
		add(studentTable);
		JPanel panel0 = new JPanel(new GridLayout(4, 1));
		panel0.add(deleteButton);
		panel0.add(clearButton);
		panel0.add(inButton);
		panel0.add(outButton);
		add(panel0);
	}
	
	public void updatetable(){
		studentTable.update(cart.getgoods());
		studentTable.repaint();
		studentTable.validate();
	}
}

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
		super("购物车");
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

		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.print(studentTable.getsrid());
				cart.removebyID(studentTable.getsrid());
				updatetable();
			}
	    });
		
		
		JButton clearButton = new JButton("清空");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "将清空购物车", "重置确认", JOptionPane.YES_NO_OPTION)==1) 
					return;
				cart.clearALL();
				updatetable();
				JOptionPane.showMessageDialog(null, "购物车已清空");
			}
	    });
		
		JButton inButton = new JButton("导入");
		inButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File aFile=new File("./output/cart.txt");
				if (JOptionPane.showConfirmDialog(null, "将从"+aFile+"导入"+"\n注意：当前的商品信息将丢失！", "确认导入？", JOptionPane.YES_NO_OPTION)==1) 
					return; 
				try {
					FileInputStream fileInputStream=new FileInputStream(aFile);
					ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
					Cart newcart=(Cart)objectInputStream.readObject();
					MenuFrame.cart=newcart;
					MenuFrame.buyframe.cart=newcart;
					MenuFrame.cartframe.cart=newcart;
					MenuFrame.qryframe.cart=newcart;
					JOptionPane.showMessageDialog(null, "导入成功");
				} catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "导入失败");
				} 
				updatetable();
				
			}
	    });
		
		JButton outButton = new JButton("导出");
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
				if (JOptionPane.showConfirmDialog(null, "将导出至"+aFile, "确认导出？", JOptionPane.YES_NO_OPTION)==1) 
					return; 
		        FileOutputStream fileOutputStream=null;
		        try {
		            fileOutputStream = new FileOutputStream(aFile);
		            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		            objectOutputStream.writeObject(cart);
		            objectOutputStream.flush();
		            objectOutputStream.close();
		            JOptionPane.showMessageDialog(null, "导出成功");
		        } catch (Exception ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "导出失败");
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

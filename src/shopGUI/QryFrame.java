package shopGUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import shopModel.Cart;
import shopModel.Good;


public class QryFrame extends JFrame{
	
	Cart cart = MenuFrame.cart;
	CartFrame cartframe = MenuFrame.cartframe;
	
	public QryFrame() {
		// TODO Auto-generated constructor stub
		super("在购物车内查找");
		init();
	}
	
	void init(){
		setLocation(200, 200);
		setSize(400, 300);
	       
		setLayout(new FlowLayout());
		initSortPanel();
		
		validate();
		setVisible(true);
	}
	
	
	void initSortPanel(){
		JLabel idLabel = new JLabel("ID");
		final JTextField idTextField = new JTextField(10);
		JLabel nameLabel = new JLabel("商品名称：");
		final JLabel nameTextField = new JLabel("待查询"); 
		JLabel priceLabel = new JLabel("价格：");
		final JLabel priceTextField = new JLabel("待查询"); 
		JLabel numLabel = new JLabel("数量：");
		final JLabel numTextField = new JLabel("待查询"); 
		//scoreTextField.setEnabled(false);
		JButton SearchButton = new JButton("查询");
		SearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String idStr = idTextField.getText().trim();
					int id = Integer.parseInt(idStr);
					Good good= cart.getGoodbyID(id);
					idTextField.setText(good.getId().toString());
					nameTextField.setText(good.getName());
					priceTextField.setText(good.getPrice().toString());
					numTextField.setText(good.getNum().toString());
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "查询无结果");
//					ee.printStackTrace();
				} 
			}
		});
		
		JButton FirstButton = new JButton("查找第一个");
		FirstButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Good good= cart.getfirst();
					idTextField.setText(good.getId().toString());
					nameTextField.setText(good.getName());
					priceTextField.setText(good.getPrice().toString());
					numTextField.setText(good.getNum().toString());
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "查询无结果");
//					ee.printStackTrace();
				} 
			}
		});
		
		JButton LastButton = new JButton("查找最后一个");
		LastButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Good good= cart.getlast();
					idTextField.setText(good.getId().toString());
					nameTextField.setText(good.getName());
					priceTextField.setText(good.getPrice().toString());
					numTextField.setText(good.getNum().toString());
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "查询无结果");
//					ee.printStackTrace();
				} 
			}
		});
		
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createHorizontalBox();
		Box box5 = Box.createHorizontalBox();
		Box box7 = Box.createHorizontalBox();
		
		box7.add(FirstButton);
		box7.add(Box.createHorizontalStrut(20));
		box7.add(LastButton);
		
		box2.add(idLabel);
		box2.add(Box.createHorizontalStrut(20));
		box2.add(idTextField);
		box2.add(Box.createHorizontalStrut(20));
		box2.add(SearchButton);
		
		box3.add(nameLabel);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(nameTextField);
		
		box4.add(priceLabel);
		box4.add(Box.createHorizontalStrut(20));
		box4.add(priceTextField);
		
		box5.add(numLabel);
		box5.add(Box.createHorizontalStrut(20));
		box5.add(numTextField);
		
		box1.add(box2);
		box1.add(Box.createVerticalStrut(20));
		box1.add(box3);
		box1.add(Box.createVerticalStrut(20));
		box1.add(box4);
		box1.add(Box.createVerticalStrut(20));
		box1.add(box5);
		box1.add(Box.createVerticalStrut(20));
		box1.add(box7);
		
		
		add(box1);
	}
}

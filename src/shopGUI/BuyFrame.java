package shopGUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import shopModel.Cart;
import shopModel.Good;


public class BuyFrame extends JFrame{
	
	Cart cart = MenuFrame.cart;
	CartFrame cartframe = MenuFrame.cartframe;
	
	public BuyFrame() {
		// TODO Auto-generated constructor stub
		super("买入新商品");
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
		JLabel nameLabel = new JLabel("商品名称");
		final JTextField nameTextField = new JTextField(10); 
		JLabel scoreLabel = new JLabel("价格");
		final JTextField scoreTextField = new JTextField(10); 
		JLabel numLabel = new JLabel("数量");
		final JTextField numTextField = new JTextField(10); 
		
		JButton inputButton = new JButton("买入");
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = cart.getid();
				String nameStr = nameTextField.getText().trim();	
				String scoreStr = scoreTextField.getText().trim();		
				String numStr = numTextField.getText().trim();		
				try {
					Good good = new Good();
					good.setId(id);
					good.setName(nameStr);
					good.setPrice(Double.parseDouble(scoreStr));
					good.setNum(Integer.parseInt(numStr));
					
					if (JOptionPane.showConfirmDialog(null, "商品名称："+nameStr+"\n价格："+scoreStr+"\n数量："+numStr, "确认添加？", JOptionPane.YES_NO_OPTION)==1) 
						return; 
					cart.addgood(good);
					cartframe.updatetable();
					JOptionPane.showMessageDialog(null, "添加成功!");
					nameTextField.setText("");
					scoreTextField.setText("");
					numTextField.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "数据格式错误!");
				}
			}
		});
		
		Box box1 = Box.createVerticalBox();
		Box box2 = Box.createVerticalBox();
		Box box3 = Box.createHorizontalBox();
		Box box4 = Box.createVerticalBox();

		box1.add(nameLabel);
		box1.add(Box.createVerticalStrut(20));
		box1.add(scoreLabel);
		box1.add(Box.createVerticalStrut(20));
		box1.add(numLabel);

		box2.add(nameTextField);
		box2.add(Box.createVerticalStrut(20));
		box2.add(scoreTextField);
		box2.add(Box.createVerticalStrut(20));
		box2.add(numTextField);
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(box2);
		box3.add(Box.createHorizontalStrut(10));
		
		box4.add(box3);
		box4.add(Box.createVerticalStrut(20));
		box4.add(inputButton);
		
		add(box4);
	}
}

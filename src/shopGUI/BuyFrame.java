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
		super("��������Ʒ");
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
		JLabel nameLabel = new JLabel("��Ʒ����");
		final JTextField nameTextField = new JTextField(10); 
		JLabel scoreLabel = new JLabel("�۸�");
		final JTextField scoreTextField = new JTextField(10); 
		JLabel numLabel = new JLabel("����");
		final JTextField numTextField = new JTextField(10); 
		
		JButton inputButton = new JButton("����");
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
					
					if (JOptionPane.showConfirmDialog(null, "��Ʒ���ƣ�"+nameStr+"\n�۸�"+scoreStr+"\n������"+numStr, "ȷ����ӣ�", JOptionPane.YES_NO_OPTION)==1) 
						return; 
					cart.addgood(good);
					cartframe.updatetable();
					JOptionPane.showMessageDialog(null, "��ӳɹ�!");
					nameTextField.setText("");
					scoreTextField.setText("");
					numTextField.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "���ݸ�ʽ����!");
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

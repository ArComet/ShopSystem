package shopGUI;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import shopModel.Cart;


public class MenuFrame extends JFrame{
	static Cart cart = new Cart();
	static CartFrame cartframe;
	static BuyFrame buyframe;
	static QryFrame qryframe;
	
	public MenuFrame() {
		// TODO Auto-generated constructor stub
		super("商城");
		init();
		
		cartframe = new CartFrame();
		cartframe.setVisible(false);
		buyframe = new BuyFrame();
		buyframe.setVisible(false);
		qryframe = new QryFrame();
		qryframe.setVisible(false);
	}
	
	void init(){
		setLocation(200, 200);
		setSize(300, 250);
		
		setLayout(new FlowLayout());
		initGUI();
		
		validate();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	void initGUI(){
		JButton buyButton = new JButton("购买");
		buyButton.setIcon(new ImageIcon("icon/buy.png"));
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buyframe.setVisible(true);
			}
		});
		
		
		JButton cartButton = new JButton("购物车");
		cartButton.setIcon(new ImageIcon("icon/cart.png"));
		cartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cartframe.setVisible(true);
			}
		});
		
		JButton qryButton = new JButton("查询");
		qryButton.setIcon(new ImageIcon("icon/qry.png"));
		qryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				qryframe.setVisible(true);
			}
		});
		
		JButton billButton = new JButton("账单");
		billButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JButton exitButton = new JButton("退出");
		exitButton.setIcon(new ImageIcon("icon/quit.png"));
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		buyButton.setFont(new java.awt.Font("华康雅宋体W9(P)", 0, 18));
		billButton.setFont(new java.awt.Font("华康雅宋体W9(P)", 0, 18));
		cartButton.setFont(new java.awt.Font("华康雅宋体W9(P)", 0, 18));
		qryButton.setFont(new java.awt.Font("华康雅宋体W9(P)", 0, 18));
		exitButton.setFont(new java.awt.Font("华康雅宋体W9(P)", 0, 18));
		
		JPanel panel0 = new JPanel(new GridLayout(5, 1));
		panel0.add(buyButton);
		panel0.add(cartButton);
		panel0.add(qryButton);
//		panel0.add(billButton);
		panel0.add(exitButton);
		add(panel0);
	}
	
}

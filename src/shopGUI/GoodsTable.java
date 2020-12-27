package shopGUI;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;

import shopModel.Good;

public class GoodsTable extends JPanel
{
	ArrayList<Good> goods = null;
	JTable table ;
	Object tableData[][];
	Object names[] =  {"ID", "商品", "单价", "数量", "合计"};
	
	private int sr=-1;
	
	public GoodsTable(ArrayList<Good> goods) {
		// TODO Auto-generated constructor stub
		this.goods = goods;
		
		Init();
		setVisible(true);
		validate();
	}

	private void Init() {
		// TODO Auto-generated method stub
		int rows = goods.size();
		tableData = new Object[rows+1][5];
		
		double sum = 0.0;
		for (int i = 0; i < rows; i++) {
			tableData[i][0] = goods.get(i).getId();
			tableData[i][1] = goods.get(i).getName();
			tableData[i][2] = goods.get(i).getPrice();
			tableData[i][3] = goods.get(i).getNum();
			tableData[i][4] = goods.get(i).getPrice()*goods.get(i).getNum();
			sum += goods.get(i).getPrice()*goods.get(i).getNum();
		}
		tableData[rows][3] = "总计";
		tableData[rows][4] = sum;
		table = new JTable(tableData, names);
		table.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                sr= table.getSelectedRow();
                System.out.print(sr);
            }
        });
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void update(ArrayList<Good> goods_new) {
		removeAll();
		tableData = new Object[goods_new.size()+1][5];
		table = new JTable(tableData, names);
		table.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
                sr= table.getSelectedRow();
                System.out.print(sr);
            }
        });
		double sum = 0.0;
		for (int i = 0; i < goods_new.size(); i++)
		{
			tableData[i][0] = goods_new.get(i).getId();
			tableData[i][1] = goods_new.get(i).getName();
			tableData[i][2] = goods_new.get(i).getPrice();
			tableData[i][3] = goods_new.get(i).getNum();
			tableData[i][4] = goods_new.get(i).getPrice()*goods_new.get(i).getNum();
			sum += goods_new.get(i).getPrice()*goods_new.get(i).getNum();
		}
		tableData[goods_new.size()][3] = "总计";
		tableData[goods_new.size()][4] = sum;
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		repaint();
	}
	
	public int getsrid() {
		return (int) tableData[sr][0];
	}
}

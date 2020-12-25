package shopModel;
import java.io.Serializable;
import java.math.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;


public class Cart implements Serializable
{
	private ArrayList<Good> goods;
	
	public Cart() {
		this.goods = new ArrayList<Good>();
	}
	
	public void setgoods(ArrayList<Good> goods) {
		this.goods=goods;
	}
	
	public ArrayList<Good> getgoods() {
		return this.goods;
	}
	
	public Good getGoodbyID(int id) {
		for (Good it:goods) {
			if (it.getId()==id) {
				return it;
			}
		}
		return null;
	}
	
	public Good getfirst() {
		return goods.get(0);
	}
	
	public Good getlast() {
		return goods.get(goods.size()-1);
	}
	
	public void addgood(Good good) {
		goods.add(good);
	}
	
	public void clearALL() {
		goods.clear();
	}
	
	public int getid() {
		int id = 0;
		for (Good it:goods) {
			id = Math.max(id, it.getId());
		}
		id++;
		return id;
	}
	
	public void removebyID(int id) {
		for (int i=0; i<goods.size(); i++) {
			if (goods.get(i).getId()==id) {
				goods.remove(i);
				return;
			}
		}
	}
}
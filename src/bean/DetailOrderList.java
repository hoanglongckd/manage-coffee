package bean;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class DetailOrderList {
	private ArrayList<DetailBill> detaiBill;
	
	private float sumMoney;

	public ArrayList<DetailBill> getDetaiBill() {
		return detaiBill;
	}
	@XmlElement
	public void setDetaiBill(ArrayList<DetailBill> detaiBill) {
		this.detaiBill = detaiBill;
	}

	
	
	
	public float getSumMoney() {
		return sumMoney;
	}
	@XmlElement
	public void setSumMoney(float sumMoney) {
		this.sumMoney = sumMoney;
	}
	public DetailOrderList(ArrayList<DetailBill> arrayList, float sumMoney) {
		super();
		this.detaiBill = arrayList;
		this.sumMoney = sumMoney;
	}
	
	
}

package chapter1;

import java.math.BigDecimal;
import java.util.Date;

public class Sales {

	//取引番号
	private int tranNo;

	//取引日
	private Date tranDate;

	//明細番号
	private int detailNo;

	//商品コード
	private String itemCd;

	//商品名
	private String itemName;

	//数量
	private BigDecimal qty;

	//単価
	private BigDecimal price;

	//金額
	private BigDecimal amount;

	//取引番号を取得
	public int getTranNo() {
		return tranNo;
	}

	//取引番号を設定
	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}

	//取引日を取得
	public Date getTranDate() {
		return tranDate;
	}

	//取引日を設定
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	//明細番号を取得
	public int getDetailNo() {
		return detailNo;
	}

	//明細番号を設定
	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	//商品コードを取得
	public String getItemCd() {
		return itemCd;
	}

	//商品コードを設定
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	//商品名を取得
	public String getItemName() {
		return itemName;
	}

	//商品名を設定
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//数量を取得
	public BigDecimal getQty() {
		return qty;
	}

	//数量を設定
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	//単価を取得
	public BigDecimal getPrice() {
		return price;
	}

	//単価を設定
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	//金額を取得
	public BigDecimal getAmount() {
		return amount;
	}

	//金額を設定
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Sales [tranNo=" + tranNo + ", tranDate=" + tranDate + ", detailNo=" + detailNo + ", itemCd=" + itemCd
				+ ", itemName=" + itemName + ", qty=" + qty + ", price=" + price + ", amount=" + amount + "]\n";
	}

}


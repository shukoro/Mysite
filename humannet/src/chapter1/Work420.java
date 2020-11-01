package chapter1;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import jp.co.app.hearts.lesson.work410.Sales;

public class Work420 {

	private static final BigDecimal ZERO = null;

	public List<Sales> calcAmount(List<Sales> salesList)
			throws IllegalArgumentException {

		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}
		List<Sales> resultSalesList = new ArrayList<Sales>();
		for (int i = 0; i < salesList.size(); i++) {

			Sales s = salesList.get(i);

			BigDecimal amount = s.getAmount();
			amount = s.getQty().multiply(s.getPrice());
			s.setAmount(amount);

			resultSalesList.add(s);
		}

		return resultSalesList;
	}

	public BigDecimal sumAmount(List<Sales> salesList)
			throws IllegalArgumentException {
		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}
		int sum = 0;
		for (int j = 0; j < salesList.size(); j++) {

			Sales sales = salesList.get(j);
			BigDecimal amount = sales.getAmount();
			amount = sales.getQty().multiply(sales.getPrice());

			int i = amount.intValue();
			sum += i;

		}
		BigDecimal totalAmount = BigDecimal.valueOf(sum);

		return totalAmount;

	}

	public BigDecimal sumQtyByItemCd(List<Sales> salesList, String itemCd)
			throws IllegalArgumentException {
		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}
		int sum = 0;
		Sales sales = null;
		for (int n = 0; n < salesList.size(); n++) {
			if (salesList.get(n).getItemCd().equals(itemCd)) {
				sales = salesList.get(n);
				BigDecimal qty = sales.getQty();
				int m = qty.intValue();
				sum += m;
			}
		}
		BigDecimal totalQuantity = BigDecimal.valueOf(sum);
		return totalQuantity;
	}

	public List<Sales> sumAmountGroupByTranDate(List<Sales> salesList)
			throws IllegalArgumentException, ParseException {

		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}
		List<Sales> resultSalesList = new ArrayList<Sales>();

		//mapの宣言
		Map<Date, Sales> map = new HashMap<Date, Sales>();
		BigDecimal b = BigDecimal.ZERO;
		for (Sales sales : salesList) {
			//
			Date key = sales.getTranDate();
			//一番最初の日付の比較(mapにキーが入ってるかどうか)
			if (!map.containsKey(key)) {
				Sales s = new Sales();
				//初期化(初期化しないと値を比較するときにおかしくなる)
				s.setTranDate(key);
				s.setAmount(b);

				//mapにキーと値を追加(keyは日付、sは１回目のループの時点では日付のみ)
				map.put(key, s);
			}
			//ココから2回目以降の処理

			//salesの合計金額のみをamountに入れる
			BigDecimal amount = sales.getAmount();
			//mapのキーに入っている日付を取り出す
			Sales sss = map.get(key);
			//合計金額に次の合計金額を足す
			BigDecimal amount2 = amount.add(sss.getAmount());
			//salesインスタンスに合計金額をセット
			sss.setAmount(amount2);
			//mapにキーと値を追加
			map.put(key, sss);

			resultSalesList = new ArrayList<Sales>(map.values());
		}

		// 日付順にソート
		Collections.sort(resultSalesList, new Comparator<Sales>() {
			@Override
			public int compare(Sales o1, Sales o2) {

				Date date1 = o1.getTranDate();
				Date date2 = o2.getTranDate();

				return date1.compareTo(date2);
			}
		});
		return resultSalesList;
	}

	public List<Sales> sumAmountGroupByTranDateAndItemCd(List<Sales> salesList)
			throws IllegalArgumentException, ParseException {
		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}

		List<Sales> resultSalesList = new ArrayList<Sales>();

		//mapの宣言
		Map<String, Sales> map = new HashMap<String, Sales>();
		BigDecimal b = BigDecimal.ZERO;
		for (Sales sales : salesList) {
			String key = sales.getTranDate() + (sales.getItemCd());
			//mapに同じ取引日＋商品コードがないかどうか
			if (!map.containsKey(key)) {
				Sales sales2 = new Sales();
				sales2.setTranDate(sales.getTranDate());
				sales2.setItemCd(sales.getItemCd());
				sales2.setAmount(b);
				map.put(key, sales2);

			}
			//ココから2回目以降の処理

			//salesの合計金額のみをamountに入れる
			BigDecimal amount = sales.getAmount();

			//mapのキーに入っている日付＋商品コードを取り出す
			Sales sss = map.get(key);

			//合計金額に次の合計金額を足す
			BigDecimal amount2 = amount.add(sss.getAmount());

			//salesインスタンスに合計金額をセット
			sss.setAmount(amount2);
			//mapにキーと値を追加
			map.put(key, sss);

			resultSalesList = new ArrayList<Sales>(map.values());
		}
		// 日付順にソート
		Collections.sort(resultSalesList, new Comparator<Sales>() {
			@Override
			public int compare(Sales o1, Sales o2) {

				Date date1 = o1.getTranDate();
				Date date2 = o2.getTranDate();

				return date1.compareTo(date2);
			}
		});
		return resultSalesList;

	}

}

 package chapter1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Work410 {
	public Sales selectByKey(List<Sales> salesList, int transactionNum, int detailNum) throws IllegalArgumentException {

		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}

		Sales resultSales = null;
		for (int i = 0; i < salesList.size(); i++) {

			if (salesList.get(i).getTranNo() == transactionNum
					&& salesList.get(i).getDetailNo() == detailNum) {

				resultSales = salesList.get(i);
			}
		}
		return resultSales;

	}

	public List<Sales> selectByTranDate(List<Sales> salesList, Date tranDateFrom, Date tranDateTo)
			throws IllegalArgumentException {

		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}
		//例外パターン②
		if (tranDateFrom == null) {
			throw new IllegalArgumentException("引数のtranDateFromがNullです。");
		}
		//例外パターン③
		if (tranDateTo == null) {
			throw new IllegalArgumentException("引数のtranDateToがNullです。");
		}
		List<Sales> resultSalesList = new ArrayList<Sales>();
		for (int j = 0; j < salesList.size(); j++) {
			//例外パターン④
			if (tranDateFrom.after(tranDateTo)) {
				throw new IllegalArgumentException("引数のtranDateFromがtranDateToよりも大きい値です。");
			} else if (tranDateFrom.before(salesList.get(j).getTranDate())
					&& tranDateTo.after(salesList.get(j).getTranDate())
					|| tranDateFrom.equals(salesList.get(j).getTranDate())
					|| tranDateTo.equals(salesList.get(j).getTranDate())) {
				resultSalesList.add(salesList.get(j));

			}
		}
		return resultSalesList;

	}

	public List<Sales> addItemName(List<Sales> salesList, Map<String, String> productNameMap)
			throws IllegalArgumentException {

		//例外パターン①
		if (salesList == null) {
			throw new IllegalArgumentException("引数のsalesListがNullです。");
		}
		//例外パターン①
		if (productNameMap == null) {
			throw new IllegalArgumentException("引数のproductNameMapがNullです。");
		}

		List<Sales> resultSalesList = new ArrayList<Sales>();

		for (int n = 0; n < salesList.size(); n++) {
			Sales s = salesList.get(n);
			String itemcode = s.getItemCd();
			String itemname = productNameMap.get(itemcode);

			s.setItemName(itemname);

			resultSalesList.add(s);
		}

		return resultSalesList;

	}

}
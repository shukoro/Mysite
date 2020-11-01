package chapter1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//import jp.co.app.hearts.lesson.work410.Sales;

public class Work420Test {
	public static void main(String[] args) throws ParseException {

		Work420 work420 = new Work420();

		// ファイルのパスを指定する
		File file = new File("C:\\Users\\shuko\\Desktop\\s.csv");
		// ファイルが存在しない場合に例外が発生するので確認
		if (!file.exists()) {

			System.out.print("ファイルが存在しません");
			return;
		}

		// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示
		try (
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			//リストの生成
			List<Sales> list = new ArrayList<Sales>();
			List<Sales> list1 = new ArrayList<Sales>();

			String line;

			// データ分だけ回す
			while ((line = reader.readLine()) != null) {

				//Salesクラスのインスタンス生成
				Sales sales = new Sales();
				//一行ずつ読み込んだファイルを一つずつ格納するための配列　
				String[] s = line.split(",", -1);
				try {
					//取り出した配列を１つずつSalesのインスタンスに入れる
					sales.setTranNo(Integer.parseInt(s[0]));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					sales.setTranDate(sdf.parse(s[1]));
					sales.setDetailNo(Integer.parseInt(s[2]));
					sales.setItemCd(s[3]);
					sales.setQty(new BigDecimal(s[4]));
					sales.setPrice(new BigDecimal(s[5]));
					//listにadd
					list.add(sales);
				} catch (ClassCastException e) {
					System.out.println("キャストに失敗です");

				}

			}
			System.out.println("■calcAmount");

			System.out.println("ケースNo.1");
			try {

				List<Sales> resultSalesList = work420.calcAmount(null);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				List<Sales> resultSalesList = work420.calcAmount(list1);
				System.out.println(resultSalesList);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {

				List<Sales> resultSalesList = work420.calcAmount(list);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("■sumAmount");

			System.out.println("ケースNo.1");
			try {

				BigDecimal totalAmount = work420.sumAmount(null);
				System.out.println(totalAmount);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				BigDecimal totalAmount = work420.sumAmount(list1);
				System.out.println(totalAmount);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {

				BigDecimal totalAmount = work420.sumAmount(list);
				System.out.println(totalAmount);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("■sumQtyByItemCd");

			System.out.println("ケースNo.1");
			try {

				BigDecimal totalQuantity = work420.sumQtyByItemCd(null, null);
				System.out.println(totalQuantity);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				BigDecimal totalQuantity = work420.sumQtyByItemCd(list1, "F001");
				System.out.println(totalQuantity);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {
				BigDecimal totalQuantity = work420.sumQtyByItemCd(list, "F001");
				System.out.println(totalQuantity);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("■sumAmountGroupByTranDate");

			//合計金額を計算するcalcAmountメソッド呼び出し、戻り値をlistに入れる
			List<Sales> sumAmountlist = work420.calcAmount(list);

			System.out.println("ケースNo.1");
			try {

				List<Sales> resultSalesList = work420.sumAmountGroupByTranDate(null);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				List<Sales> resultSalesList = work420.sumAmountGroupByTranDate(list1);
				System.out.println(resultSalesList);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {
				List<Sales> resultSalesList = work420.sumAmountGroupByTranDate(sumAmountlist);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("■sumAmountGroupByTranDateAndItemCd");

			System.out.println("ケースNo.1");
			try {

				List<Sales> resultSalesList = work420.sumAmountGroupByTranDateAndItemCd(null);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				List<Sales> resultSalesList = work420.sumAmountGroupByTranDateAndItemCd(list1);
				System.out.println(resultSalesList);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {
				List<Sales> resultSalesList = work420.sumAmountGroupByTranDateAndItemCd(sumAmountlist);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			// 最後にファイルを閉じてリソースを開放する
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

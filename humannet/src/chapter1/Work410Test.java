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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Work410Test {

	public static void main(String[] args) throws ParseException {

		Work410 work410 = new Work410();

		// ファイルのパスを指定する
		File file = new File("C:\\Users\\shuko\\Desktop\\s.csv");
		// ファイルが存在しない場合に例外が発生するので確認
		if (!file.exists()) {

			System.out.print("ファイルが存在しません");
			return;
		}

		// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			//リストの生成
			List<Sales> list = new ArrayList<Sales>();
			List<Sales> list1 = new ArrayList<Sales>();

			String line = reader.readLine();

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

			System.out.println("■selectByKey");

			System.out.println("ケースNo.1");
			try {

				Sales resultSales = work410.selectByKey(null, 10000003, 1);
				System.out.println(resultSales);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				Sales resultSales = work410.selectByKey(list, 10000003, 1);
				System.out.println(resultSales);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {

				Sales resultSales = work410.selectByKey(list1, 10000005, 3);

				System.out.println(resultSales);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.4");
			try {

				Sales resultSales = work410.selectByKey(list, 9999, 1);
				System.out.println(resultSales);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.5");
			try {

				Sales resultSales = work410.selectByKey(list, 10000001, 99);
				System.out.println(resultSales);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("■selectByTranDate");

			System.out.println("ケースNo.1");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/1");
				Date d1 = sdf.parse("2012/4/30");
				List<Sales> resultSalesList = work410.selectByTranDate(null, d, d1);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/30");

				List<Sales> resultSalesList = work410.selectByTranDate(list, null, d);
				System.out.println(resultSalesList);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/1");

				List<Sales> resultSalesList = work410.selectByTranDate(list, d, null);

				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.4");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/2");
				Date d1 = sdf.parse("2012/4/1");

				List<Sales> resultSalesList = work410.selectByTranDate(list, d, d1);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.5");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/2");
				Date d1 = sdf.parse("2012/4/2");
				List<Sales> resultSalesList = work410.selectByTranDate(list, d, d1);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.6");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/2");
				Date d1 = sdf.parse("2012/4/4");

				List<Sales> resultSalesList = work410.selectByTranDate(list, d, d1);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.7");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/1");
				Date d1 = sdf.parse("2012/4/30");

				List<Sales> resultSalesList = work410.selectByTranDate(list1, d, d1);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.8");
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date d = sdf.parse("2012/4/1");
				Date d1 = sdf.parse("2012/4/30");

				List<Sales> resultSalesList = work410.selectByTranDate(list, d, d1);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("");
			System.out.println("■addItemName");

			Map<String, String> map = new HashMap<>();
			Map<String, String> map2 = new HashMap<>();

			map.put("F001", "アボカド");
			map.put("F002", "いちご");
			map.put("F003", "キウイ");
			map.put("F004", "八朔");
			map.put("F005", "バナナ");
			map.put("F006", "りんご");

			System.out.println("ケースNo.1");
			try {

				List<Sales> resultSalesList = work410.addItemName(null, map);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {

				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.2");
			try {
				List<Sales> resultSalesList = work410.addItemName(list, null);
				System.out.println(resultSalesList);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.3");
			try {

				List<Sales> resultSalesList = work410.addItemName(list, map);

				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.4");
			try {

				List<Sales> resultSalesList = work410.addItemName(list1, map);
				System.out.println(resultSalesList);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("");
			System.out.println("ケースNo.5");
			try {

				List<Sales> resultSalesList = work410.addItemName(list, map2);
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

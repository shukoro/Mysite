package kadai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//実行クラスで使用するメソッドなどを集めたクラス

public class SetSet {

	//質問項目メソッド
	public void question() {

		//各国情報をCountryクラスのインスタンスで保持
		//アメリカ
		Country america = new Country();
		america.setName("アメリカ");
		america.setCity("ロサンゼルス");
		america.setNationalmentality("気さくで自己主張ははっきりしている。様々な人種の人々がいる、世界のトップを走る経済大国");
		america.setCrimate("年中暖かくビーチもありカラッとした気候");
		america.setFeature("多くの人種が集う多国籍国家。世界最先端のテクノロジーを持つ実力主義の社会で実力があればそれに見合った報酬が得られる。\nまたLAは健康志向の人々が多く食生活も充実。");
		america.setNotice("医療費が高く、銃社会でもある。");

		//ドイツ
		Country germany = new Country();
		germany.setName("ドイツ");
		germany.setCity("ミュンヘン");
		germany.setNationalmentality("真面目で日本人と気質が似ている。ライフワークバランスを重視。");
		germany.setCrimate("気候：砂漠性の気候で５月～１０月は長い夏季が続き、気温は４０℃を超すこともしばしば。");
		germany.setFeature("税金は安くはないが社会保障が充実。芸術や音楽が生活に根付いている。豊かな自然に恵まれ、周辺ヨーロッパへも気軽に行き来しやすい");
		germany.setNotice("税金が高い治安が悪い地域もある。");

		//エジプト
		Country egypt = new Country();
		egypt.setName("エジプト");
		egypt.setCity("カイロ");
		egypt.setNationalmentality("イスラムの信仰心が強く、少しルーズな性格でもあるが人懐っこい。");
		egypt.setCrimate("四季があり冬は寒いが夏は爽やかな気候");
		egypt.setFeature("無数の遺跡があり、遺跡マニアにはたまらない環境");
		egypt.setNotice("テロ発生など治安が悪い地域がある。");

		//スイス
		Country swizerland = new Country();
		swizerland.setName("スイス");
		swizerland.setCity("ジュネーヴ");
		swizerland.setNationalmentality("フレンドリーで仕事にも熱心。家族との時間をとても大切にする");
		swizerland.setCrimate("四季があり冬は寒いが夏は爽やかな気候雄大な山々に囲まれ、季節ごとの自然が楽しめる");
		swizerland.setFeature("コンピューターサイエンス分野は世界トップクラス。社会保障も充実し、治安も良く清潔。");
		swizerland.setNotice("世界で一番物価が高い、外国人移住者に対してあまり歓迎的ではない傾向がある。");

		//チェコ
		Country czech = new Country();
		czech.setName("チェコ");
		czech.setCity("プラハ");
		czech.setNationalmentality("シャイだけど人情味がある。自由を好む。");
		czech.setCrimate("四季があり冬は寒いが夏は爽やかな気候。雄大な山々に囲まれ、季節ごとの自然が楽しめる");
		czech.setFeature("美しい歴史あふれる街並みが魅力。郊外へ出れば自然を楽しめる。\n物価が安く治安も良い。チェコ料理も日本人の口に合いやすい");
		czech.setNotice("首都は家賃が年々高沸している。");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("あなたにぴったりの移住先はどこでしょう？？↩");
		try {
			reader.readLine();
		} catch (IOException e2) {

			e2.printStackTrace();
		}
		System.out.println("質問の答えに当てはまる番号を入力してください。↩");
		while (true) {
			try {

				reader.readLine();

				//質問項目用の配列
				String[] Chooses;
				Chooses = new String[7];
				Chooses[0] = "あなたの性格を教えてください。\n0:社交的\n1:内気\n2:真面目\n";
				Chooses[1] = "あなたの住みたい環境は？\n0:ビーチが近くにある環境\n1:森が近くにある自然がいっぱいの環境\n2:歴史や伝統が感じられる街\n";
				Chooses[2] = "あなたは食べ物にこだわりがある？\n0:あまりない\n1:好き嫌いが多い\n2:和食命";
				Chooses[3] = "あなたが人生で大切にしたいものは？\n0:家族\n1:仕事\n2:旅行して世界を知る";
				Chooses[4] = "あなたはどんな気候が好き？\n0:四季が感じられる方がいい\n1:暑いのは苦手、涼しい気候がいい\n2:年中暖かい気候がいい";
				Chooses[5] = "あなたにとってどれが重要？\n0:税金や物価が安い\n1:税金が高くても社会保障がしっかりしている\n2:色んな人種が住んでいる";
				Chooses[6] = "どんな仕事をしたい？\n0:IT業界でバリバリ仕事\n1:美容やファッション,芸術関係\n2:発掘";

				//選択肢による獲得点数用の配列
				int[][] Number = {
						{ 10, 0, 0 },
						{ 10, 0, 0 },
						{ 10, 2, 0 },
						{ 0, 10, 3 },
						{ 0, 200, 10 },
						{ 500, 1000, 10 },
						{ 10, 0, 100000 },
				};

				//sumで選択した回答毎の点数をカウント
				int sum;
				sum = 0;
				int j = 0;
				while (j < Chooses.length) {
					System.out.println(Chooses[j]);
					try {
						String line = reader.readLine();

						if (line.length() > 0) {
							int m = Integer.parseInt(line);
							sum += Number[j][m];
							j++;
						} else {
							line = "p";
							int m = Integer.parseInt(line);
						}
					} catch (Exception e) {
						System.out.println("数字を正しく入力してください");
						continue;
					}
				}
				if (sum == 70) {

					System.out.println("国名(地名):" + america.getName() + "(" + america.getCity() + ")");
					System.out.println("国民性：" + america.getNationalmentality());
					System.out.println("気候：" + america.getCrimate());
					System.out.println("国の特徴：" + america.getFeature());
					System.out.println("移住に当たる注意点：" + america.getNotice());

				} else if (sum > 700 && sum < 900) {
					System.out.println("国名(地名):" + germany.getName() + "(" + germany.getCity() + ")");
					System.out.println("国民性：" + germany.getNationalmentality());
					System.out.println("気候：" + germany.getCrimate());
					System.out.println("国の特徴：" + germany.getFeature());
					System.out.println("移住に当たる注意点：" + germany.getNotice());

				} else if (sum > 99999) {
					System.out.println("国名(地名):" + egypt.getName() + "(" + egypt.getCity() + ")");
					System.out.println("国民性：" + egypt.getNationalmentality());
					System.out.println("気候：" + egypt.getCrimate());
					System.out.println("国の特徴：" + egypt.getFeature());
					System.out.println("移住に当たる注意点：" + egypt.getNotice());

				} else if (sum > 999) {
					System.out.println("国名(地名):" + swizerland.getName() + "(" + swizerland.getCity() + ")");
					System.out.println("国民性：" + swizerland.getNationalmentality());
					System.out.println("気候：" + swizerland.getCrimate());
					System.out.println("国の特徴：" + swizerland.getFeature());
					System.out.println("移住に当たる注意点：" + swizerland.getNotice());

				} else if (sum > 500 || sum < 700) {
					System.out.println("国名(地名):(" + czech.getName() + "(" + czech.getCity() + ")");
					System.out.println("国民性：" + czech.getNationalmentality());
					System.out.println("気候：" + czech.getCrimate());
					System.out.println("国の特徴：" + czech.getFeature());
					System.out.println("移住に当たる注意点：" + czech.getNotice());
				}

			} catch (IOException e1) {

				e1.printStackTrace();

				//			} catch (NumberFormatException e) {
				//				System.out.println("数字を正しく入力してください");
				//				continue;
				//			}

				break;

			}

		}
	}
}
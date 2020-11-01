package chapter1;

//不機嫌な彼女の機嫌をとりまくるプログラムです。選択肢によって得られる星の数が違い、運命が変わります。
//最後に集めた星の合計数で結末が変わります。

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fukigen {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("朝起きると珍しく彼女が不機嫌です。一体どうしたのでしょう？");
			reader.readLine();
			System.out.println("僕：（なんだ？何かしたっけ？…もしかして…？）");
			reader.readLine();
			System.out.println("思い当たることを選んでください。白状するまで先に進めません。");
			System.out.println("1 へそくりを貯めていたのがバレた。");
			System.out.println("2 禁煙したと言って隠れて吸っていたのがバレた。");
			System.out.println("3 お弁当に入っている嫌いなピーマンを捨てていたのがバレた。");
			System.out.println("4 最近愛してるよと言っていない。");
			System.out.println("5 全部。");

			String line;
			int n = 0;
			//4が選択されるまで繰り返し
			while (n != 4) {
				line = reader.readLine();
				n = Integer.parseInt(line);

				if (n == 4) {
					System.out.println("彼女：よくわかってるじゃない。ふん。");
					break;
				}
				System.out.println("彼女：自分の胸に手を当てて聞いてみなさい。");
			}
			reader.readLine();
			System.out.println("僕：（まいったな…何とかして彼女の機嫌を直さないと…そうだ！彼女をデートに連れて行こう)");
			reader.readLine();
			System.out.println("僕：今からデートに行こう！僕がエスコートするよ！");
			reader.readLine();
			System.out.println("彼女:…仕方ないわね。");
			reader.readLine();
			System.out.println("！！！！さあここからミッションの始まりだ！！彼女が喜ぶチョイスをして、\n☆をゲットしろ！集めた☆の数で運命が決まるぞ！しくじるなよ！?");
			reader.readLine();
			System.out.println("～デートに出かける二人～まずはランチを食べに行くことに。");
			reader.readLine();
			System.out.println("僕:何が食べたい？君の好きなもの食べに行こう！");
			reader.readLine();
			System.out.println("彼女:何でもいいわ。あなたが決めて。");
			reader.readLine();
			System.out.println("さあどうする！？デートは始めが肝心だぞ！?");

			//ミッションを選択する配列
			String[] Chooses;
			Chooses = new String[5];
			Chooses[0] = "彼女が喜びそうなお店を選べ。\n0: 超おしゃれなイタリアンレストラン\n1: 初デートで行ったお好み焼き屋 \n2：吉野家";
			Chooses[1] = "試着をして出てきた彼女へなんて言う！？\n0: 思ったよりパツパツだね！！\n1: 最高に似合ってる！僕にプレゼントさせて\n2: 似合ってるよ";
			Chooses[2] = "なんの花束をプレゼントする？ \n0: 菊の花束 \n1: 真っ赤なバラの花束 \n2: 繊細なかすみ草";
			Chooses[3] = "セリフを選べ。 \n0: そうだっけ？忘れた \n1: 綺麗な女性には花を贈らずにはいられないよ。\n2: 覚えててくれたんだね";
			Chooses[4] = "何て答える？ \n0: やばい！綺麗すぎて震える…サインもらってくる \n1: 今日は大切な君とのデートだから。家に帰ろう。 \n2: 僕には君しか見えないよ";

			//ゲットする星の数を保管する配列
			String[][] Star = {
					{ "☆☆☆", "☆☆☆☆", "☆" },
					{ "☆", "☆☆☆☆", "☆☆" },
					{ "☆", "☆☆", "☆☆☆☆" },
					{ "☆", "☆☆", "☆☆☆" },
					{ "☆", "☆☆☆☆☆☆☆☆", "☆☆☆☆☆" }
			};
			//ゲットする星の数を数字で保管する配列
			int[][] Number = {
					{ 3, 4, 1 },
					{ 1, 4, 2 },
					{ 1, 2, 4 },
					{ 1, 2, 3 },
					{ 1, 8, 5 }
			};
			//ストーリーを表示するための配列
			String[] Story;
			Story = new String[5];
			Story[0] = "食事を終えて、街中へ。おしゃれな服屋さんを発見。\n僕:あのディスプレイのワンピース、君に似合いそう！試着してみようよ！\n彼女:そこまで言うなら…";
			Story[1] = "ワンピースを購入して少しうれしそうな彼女。いい感じだ！！歩いていると、花屋さんを発見。\n彼女に花束のプレゼントだ！！";
			Story[2] = "花束を抱えて嬉しそうな彼女。\n彼女:初めてのデートの時も、お花をくれたわよね。";
			Story[3] = "大通りを歩いていると、超絶大ファンの石〇さとみを発見！！！プライベートで買い物中のようだ。\n彼女：えっあれってもしかして？あなた大ファンだよね。";
			Story[4] = "デートもそろそろおしまいだ。え？？疲れた？？甘いぞ！！！！女心は複雑なんだよ！！。\nさあ！集めた☆と共に、彼女に愛を伝えるんだ";

			String sum;
			sum = "";
			int sum1;
			sum1 = 0;
			for (int j = 0; j < Chooses.length; j++) {
				System.out.println(Chooses[j]);

				String line2 = reader.readLine();
				int m = Integer.parseInt(line2);


				if (Star[j][m].equals("☆☆")) {
					System.out.println("星を" + "☆☆" + "つゲットだ！！まずまずだ！！");
					System.out.println("");

				} else if (Star[j][m].equals("☆☆☆")) {
					System.out.println("星を" + "☆☆☆" + "つゲットだ！！やるな！！");
					System.out.println("");

				} else if (Star[j][m].equals("☆")) {
					System.out.println("星を" + "☆" + "つゲットだ！！女心がわかってないな！！ダメダメだ！！");
					System.out.println("");

				} else if (Star[j][m].equals("☆☆☆☆☆☆☆☆")) {
					System.out.println("星を" + "☆☆☆☆☆☆☆☆" + "つゲットだ！！彼女のハートを鷲掴みだぜ！！");
					System.out.println("");

				} else if (Star[j][m].equals("☆☆☆☆")) {
					System.out.println("星を" + "☆☆☆☆" + "つゲットだ！！いいぞ！！");
					System.out.println("");

				} else {
					System.out.println("星を" + "☆☆☆☆☆" + "つゲットだ！！その調子だ！！");
					System.out.println("");
				}

				System.out.println(Story[j]);
				sum += Star[j][m]; //☆をカウント
				sum1 += Number[j][m];//星を数字でカウント
			}

			System.out.println("");
			System.out.println("ゲットした星の数は" + sum + "個だ！！");
			System.out.println("僕：星のようにキラキラと輝く君に、僕が集めた星を贈るよ。僕の気持ちだ！！受け取ってくれ！！");
			System.out.println("");
			//集めた星の合計 Max23個
			if (sum1 > 22) {
				System.out.println("彼女：あなたの愛は伝わったわ。これからもずっと一緒にいてね。");
				System.out.println("おしまい。");

			} else {
				System.out.println("彼女：ごめんなさい。もう連絡しないで。");
				System.out.println("おしまい。");
			}
		} catch (IOException e) {
			System.out.println("e");
		} catch (NumberFormatException e) {
			System.out.println("彼女：真剣にやりなさいよ");

		}
	}
}

package ProjectUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmotionUtils {

	public void checkSO(ArrayList<News> news) throws IOException {
		ArrayList<String> posArray = importPos();
		ArrayList<String> negArray = importNeg();
		CalcTotalPos(posArray,negArray, news);
	}

	public void checkNewsEmotion(News news) {

		int happyrate = checkHappy(news);
		int sadrate = checkSad(news);

	}

	private int checkHappy(News news) {
		return 1;
	}

	private int checkSad(News news) {
		return 1;
	}

	private ArrayList<String> importPos() throws IOException {

		ArrayList<String> posArray = new ArrayList<String>();
		FileReader fr = new FileReader("/Users/apple/Documents/workspace/graduateProject/src/ntusd-positive.txt");
		BufferedReader br = new BufferedReader(fr);

		while (br.readLine() != null) {
			posArray.add(br.readLine());
		}

		fr.close();
		return posArray;
	}

	private ArrayList<String> importNeg() throws IOException {

		ArrayList<String> negArray = new ArrayList<String>();
		FileReader fr = new FileReader("/Users/apple/Documents/workspace/graduateProject/src/ntusd-negative.txt");
		BufferedReader br = new BufferedReader(fr);

		while (br.readLine() != null) {
			negArray.add(br.readLine());
		}

		fr.close();
		return negArray;
	}

	private void CalcTotalPos(ArrayList<String> posArray, ArrayList<String> negArray, ArrayList<News> newsArray)
			throws IOException {
		
		
		
		for (int i = 0; i < newsArray.size(); i++) {
			int pos = 0;
			int neg = 0;
			News temp = new News();
			temp = newsArray.get(i);
			
		
			
			
			for (SplitWords sw : temp.getAll_split_word()) {
				if (posArray.contains(sw.word_content)) {
					pos++;
					//System.out.println(sw.word_content+"正面分數增加為"+neg);
					
				} else if (negArray.contains(sw.word_content)) {
					neg++;
					//System.out.println(sw.word_content+"負面分數增加為"+neg);
					
				}
			}
			newsArray.get(i).setPositiveEmotion(pos);
			newsArray.get(i).setNegativeEmotion(neg);
			newsArray.get(i).setTotalEmotion(pos - neg);
			System.out.println(pos-neg);
			
		}

	}

}

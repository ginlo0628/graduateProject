package ProjectUtils;

import java.util.ArrayList;

public class SplitUtils {

	public  ArrayList<News> getSplitArray( ArrayList<News> News_to_get_emotion) {
		
		for(int i =0;i<News_to_get_emotion.size();i++)
		{
			News temp = new News();
			
			ArrayList<SplitWords> news_split_words = new ArrayList<SplitWords>();
			
			temp = News_to_get_emotion.get(i);
			String[] cutArray= temp.Split_content.split(",");
			
			for(int j=0;j<cutArray.length;j++)
			{
				String[] cutFLAG= cutArray[j].split(":");
				SplitWords temp_sp = new SplitWords();
				temp_sp.setWord_content(cutFLAG[0]);
				temp_sp.setKind((cutFLAG[1]));
				news_split_words.add(temp_sp);
			}
			
			News_to_get_emotion.get(i).setAll_split_word(news_split_words);
		}
		
		
		
		
		
	return  News_to_get_emotion;
	}

}

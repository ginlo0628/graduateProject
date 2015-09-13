package ProjectUtils;

import java.util.ArrayList;

public class News {

	String time;
	String title;
	String Url;
	String Content;
	String Split_content;
	ArrayList<SplitWords> all_split_word = new ArrayList<SplitWords>();
	public int getPositiveEmotion() {
		return positiveEmotion;
	}

	public void setPositiveEmotion(int positiveEmotion) {
		this.positiveEmotion = positiveEmotion;
	}

	public int getNegativeEmotion() {
		return negativeEmotion;
	}

	public void setNegativeEmotion(int negativeEmotion) {
		this.negativeEmotion = negativeEmotion;
	}

	public int getTotalEmotion() {
		return totalEmotion;
	}

	public void setTotalEmotion(int totalEmotion) {
		this.totalEmotion = totalEmotion;
	}

	int positiveEmotion;
	int negativeEmotion;
	int totalEmotion;
			
			
	public ArrayList<SplitWords> getAll_split_word() {
		return all_split_word;
	}

	public void setAll_split_word(ArrayList<SplitWords> all_split_word) {
		this.all_split_word = all_split_word;
	}

	public News() {

	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getSplit_content() {
		return Split_content;
	}

	public void setSplit_content(String split_content) {
		Split_content = split_content;
	}

}

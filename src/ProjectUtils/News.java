package ProjectUtils;

public class News {

	String time;
	String title;
	String Url;

	String Content;
	String Split_content;

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

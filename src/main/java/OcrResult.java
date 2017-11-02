import java.util.List;

public class OcrResult {
	private Long log_id;
	private List<WordsResult> words_result;
	private int words_result_num;
	public Long getLog_id() {
		return log_id;
	}
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}
	public List<WordsResult> getWords_result() {
		return words_result;
	}
	public void setWords_result(List<WordsResult> words_result) {
		this.words_result = words_result;
	}
	public int getWords_result_num() {
		return words_result_num;
	}
	public void setWords_result_num(int words_result_num) {
		this.words_result_num = words_result_num;
	}


}

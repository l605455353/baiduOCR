import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;


import net.sf.json.JSONArray;


public class _ocrUtil {

	public static final String APP_ID = "10268277";
	public static final String API_KEY = "uw6V53whpPtlweXrzcpIsLvv";
	public static final String SECRET_KEY = "QOfNlkfFrcrv7VKMlEeXcccrAuUgo4Fv";


	public static void main(String[] args) {

		System.out.println("新建分支");
		System.out.println("我还是slave分支");
		
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		String genFilePath = "C:\\WorkData\\test\\4.png";
		//        String genFilePath = "D://1.jpg";
		JSONObject genRes = client.basicGeneral(genFilePath, new HashMap<String, String>());
//		net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(genRes.toString(2));
		net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(genRes.toString());
		OcrResult api = (OcrResult)net.sf.json.JSONObject.toBean(obj,OcrResult.class);
		List<WordsResult> apiList = api.getWords_result();
		net.sf.json.JSONObject jsonObject ;
		JSONArray resultJson = JSONArray.fromObject(apiList);
		List<WordsResult> resultList = new ArrayList<WordsResult>();
		Map<String, Class> classMap = new HashMap<String, Class>();  
		WordsResult menu = new WordsResult();
		for (int i = 0; i < resultJson.size(); i++) {
			jsonObject = resultJson.getJSONObject(i);
			menu =  (WordsResult)  net.sf.json.JSONObject.toBean(jsonObject, WordsResult.class , classMap);
			resultList.add(menu);
		}
		for(WordsResult words : resultList){
			System.out.println(words.getWords());
		}
	}
}

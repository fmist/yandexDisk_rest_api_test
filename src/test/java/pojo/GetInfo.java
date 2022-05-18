package pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetInfo {

	@SerializedName("Response")
	private List<ResponseItem> response;

	public List<ResponseItem> getResponse(){
		return response;
	}
}
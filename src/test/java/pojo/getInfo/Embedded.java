package pojo.getInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Embedded{

	@SerializedName("path")
	private String path;

	@SerializedName("total")
	private int total;

	@SerializedName("offset")
	private int offset;

	@SerializedName("limit")
	private int limit;

	@SerializedName("sort")
	private String sort;

	@SerializedName("items")
	private List<ItemsItem> items;

	public String getPath(){
		return path;
	}

	public int getTotal(){
		return total;
	}

	public int getOffset(){
		return offset;
	}

	public int getLimit(){
		return limit;
	}

	public String getSort(){
		return sort;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}
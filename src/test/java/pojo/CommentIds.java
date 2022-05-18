package pojo;

import com.google.gson.annotations.SerializedName;

public class CommentIds{

	@SerializedName("private_resource")
	private String privateResource;

	@SerializedName("public_resource")
	private String publicResource;

	public String getPrivateResource(){
		return privateResource;
	}

	public String getPublicResource(){
		return publicResource;
	}
}
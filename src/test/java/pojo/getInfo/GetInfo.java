package pojo.getInfo;

import com.google.gson.annotations.SerializedName;

public class GetInfo {

	@SerializedName("path")
	private String path;

	@SerializedName("_embedded")
	private Embedded embedded;

	@SerializedName("created")
	private String created;

	@SerializedName("name")
	private String name;

	@SerializedName("resource_id")
	private String resourceId;

	@SerializedName("modified")
	private String modified;

	@SerializedName("type")
	private String type;

	@SerializedName("comment_ids")
	private CommentIds commentIds;

	@SerializedName("exif")
	private Exif exif;

	@SerializedName("revision")
	private long revision;

	public String getPath(){
		return path;
	}

	public Embedded getEmbedded(){
		return embedded;
	}

	public String getCreated(){
		return created;
	}

	public String getName(){
		return name;
	}

	public String getResourceId(){
		return resourceId;
	}

	public String getModified(){
		return modified;
	}

	public String getType(){
		return type;
	}

	public CommentIds getCommentIds(){
		return commentIds;
	}

	public Exif getExif(){
		return exif;
	}

	public long getRevision(){
		return revision;
	}
}
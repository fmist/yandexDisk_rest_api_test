package pojo;

import com.google.gson.annotations.SerializedName;

public class ResponseItem{

	@SerializedName("preview")
	private String preview;

	@SerializedName("sha256")
	private String sha256;

	@SerializedName("created")
	private String created;

	@SerializedName("type")
	private String type;

	@SerializedName("antivirus_status")
	private String antivirusStatus;

	@SerializedName("revision")
	private long revision;

	@SerializedName("path")
	private String path;

	@SerializedName("file")
	private String file;

	@SerializedName("size")
	private int size;

	@SerializedName("mime_type")
	private String mimeType;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("name")
	private String name;

	@SerializedName("resource_id")
	private String resourceId;

	@SerializedName("modified")
	private String modified;

	@SerializedName("comment_ids")
	private CommentIds commentIds;

	@SerializedName("exif")
	private Exif exif;

	@SerializedName("md5")
	private String md5;

	public String getPreview(){
		return preview;
	}

	public String getSha256(){
		return sha256;
	}

	public String getCreated(){
		return created;
	}

	public String getType(){
		return type;
	}

	public String getAntivirusStatus(){
		return antivirusStatus;
	}

	public long getRevision(){
		return revision;
	}

	public String getPath(){
		return path;
	}

	public String getFile(){
		return file;
	}

	public int getSize(){
		return size;
	}

	public String getMimeType(){
		return mimeType;
	}

	public String getMediaType(){
		return mediaType;
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

	public CommentIds getCommentIds(){
		return commentIds;
	}

	public Exif getExif(){
		return exif;
	}

	public String getMd5(){
		return md5;
	}
}
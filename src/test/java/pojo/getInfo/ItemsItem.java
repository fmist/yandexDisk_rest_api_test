package pojo.getInfo;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("preview")
	public String preview;

	@SerializedName("sha256")
	public String sha256;

	@SerializedName("created")
	public String created;

	@SerializedName("type")
	public String type;

	@SerializedName("antivirus_status")
	public String antivirusStatus;

	@SerializedName("revision")
	public long revision;

	@SerializedName("path")
	public String path;

	@SerializedName("file")
	public String file;

	@SerializedName("size")
	public int size;

	@SerializedName("mime_type")
	public String mimeType;

	@SerializedName("media_type")
	public String mediaType;

	@SerializedName("name")
	public String name;

	@SerializedName("resource_id")
	public String resourceId;

	@SerializedName("modified")
	public String modified;

	@SerializedName("comment_ids")
	public CommentIds commentIds;

	@SerializedName("exif")
	public Exif exif;

	@SerializedName("md5")
	public String md5;

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
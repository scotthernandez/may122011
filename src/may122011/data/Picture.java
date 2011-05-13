package may122011.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity("pictures")
public class Picture {
	@Id ObjectId id = new ObjectId();
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public Date getUploaded() {
		return uploaded;
	}
	public void setUploaded(Date uploaded) {
		this.uploaded = uploaded;
	}
	public Date getLastViewed() {
		return lastViewed;
	}
	public void setLastViewed(Date lastViewed) {
		this.lastViewed = lastViewed;
	}
	
	String name;
	byte[] data;
	String mimeType;
	Date uploaded = new Date();
	Date lastViewed = null;
	long views = 0;
	
}

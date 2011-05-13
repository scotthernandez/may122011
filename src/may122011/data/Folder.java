package may122011.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.bson.types.ObjectId;

import com.google.code.morphia.Key;
import com.google.code.morphia.annotations.Id;

@Data
public class Folder {
	@Id ObjectId id;
	String Name;
	Date created;
	List<Key<Picture>> pics = new ArrayList<Key<Picture>>();
}

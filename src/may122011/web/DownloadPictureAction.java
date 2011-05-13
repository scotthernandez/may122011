package may122011.web;

import java.io.ByteArrayInputStream;

import may122011.data.Picture;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;

import com.google.code.morphia.query.Query;

public class DownloadPictureAction extends BaseAction {
	String id;
	String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DefaultHandler
	public Resolution download(){
		Picture pic = (Picture) ctx.getRequest().getAttribute("pictureInstance");
		Query<Picture> query = null;
		if (pic==null) {
			if(id == null)
				query = ds.find(Picture.class).filter("name", name);
			else
				query = ds.find(Picture.class).filter("id", id);
			
			pic = query.get();
		}
		
		
		if (pic==null)
		    return new  StreamingResolution("text/plain", "Pic not found, please use id, name on the url");
		
		//update lastViewed date, and counter for views
//		ds.updateFirst(query, ds.createUpdateOperations(Picture.class).set("lastViewed", new Date()).inc("views"));

		return new StreamingResolution("image/jpeg",
				new ByteArrayInputStream(pic.getData())).setFilename(pic.getName());
	}
}

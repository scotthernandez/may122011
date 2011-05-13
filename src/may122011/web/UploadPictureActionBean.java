package may122011.web;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import lombok.Data;
import may122011.data.Picture;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.FileBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.validation.Validate;

@Data
public class UploadPictureActionBean extends BaseAction {
	@Validate(required=true)
	private FileBean pic = null;
	@Validate(required=true)
	private String name = "";
	
	public FileBean getPic() {
		return pic;
	}

	public void setPic(FileBean pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DefaultHandler
	public Resolution upload() throws IOException {
		//redirect to upload form if there are errors.
		if(ctx.getValidationErrors() != null && ctx.getValidationErrors().size() > 0)
			return ctx.getSourcePageResolution();
		
		if (pic != null && pic.getSize() > 0) {
            byte[] data = new byte[(int) this.pic.getSize()];
            InputStream in = this.pic.getInputStream();
            in.read(data);
            
            
			Picture newPic = new Picture();
            newPic.setData(data);
            newPic.setName(name);
            newPic.setUploaded(new Date());
            //Save it.
            ds.save(newPic);
            
            ctx.getRequest().setAttribute("pictureInstance", newPic);
//			return new  StreamingResolution("text/plain", "" + newPic.getId());

			return new ForwardResolution(DownloadPictureAction.class);
            
		} else
			return new  StreamingResolution("text/plain", "no data");
		
	}
}

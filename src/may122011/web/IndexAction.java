package may122011.web;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

//@UrlBinding("/Home")
public class IndexAction extends BaseAction {
	@DefaultHandler
	public Resolution index() {
	    return new ForwardResolution("UploadForm.jsp");
	}
}

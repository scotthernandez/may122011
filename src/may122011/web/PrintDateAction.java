package may122011.web;

import java.util.Date;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;


public class PrintDateAction extends BaseAction{

	@DefaultHandler
	public Resolution speak() {
	    return new  StreamingResolution("text/plain", "Time is currently:"  + new Date().toString());
	}
}

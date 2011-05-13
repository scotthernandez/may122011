package may122011.web;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

import com.google.code.morphia.Datastore;
import com.google.inject.Inject;

public abstract class BaseAction implements ActionBean {

	@Inject protected Datastore ds;
	protected ActionBeanContext ctx = null;
	
	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}

	@Override
	public void setContext(ActionBeanContext abc) {
		ctx = abc;
	}


}

package may122011.data;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.Mongo;


public class DataModule implements Module {

	@Override
	public void configure(Binder bind) {
	}

	@Provides @Singleton
	Mongo mongoProvider() {
		try {
			return new Mongo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Provides Datastore dsProvider(Mongo m) {
		return new Morphia().createDatastore(m, "demo");
	}
}

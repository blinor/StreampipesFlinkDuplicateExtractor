package ba.dextractor;

import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;

/**
 * @author Michael Jahns
 * This Modul is build on the template provided by StreamPipes
 * 
 */
public class FlinkInit extends StandaloneModelSubmitter {

	public static void main(String[] args) {

		DeclarersSingleton.getInstance().add(new DuplicateExtraktorCont());

		DeclarersSingleton.getInstance().setHostName(Config.INSTANCE.getHost());
		DeclarersSingleton.getInstance().setPort(8086);
		new FlinkInit().init();
	}

}

package ba.dextractor;


import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;

public class FlinkInit extends StandaloneModelSubmitter {

    public static void main(String[] args) {
        /*
            TOTORIAL:
            Add the newly created components to the declarer singleton
         */
        DeclarersSingleton.getInstance().add(new DuplicateExtraktorCont())
//        .add(new TemplateSource())
;

        DeclarersSingleton.getInstance().setHostName(Config.INSTANCE.getHost());
        DeclarersSingleton.getInstance().setPort(8086);
        new FlinkInit().init();
    }

}

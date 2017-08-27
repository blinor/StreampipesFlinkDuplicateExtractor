package weather;


import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;
import org.streampipes.templates.sources.template.TemplateSource;

public class FlinkInit extends StandaloneModelSubmitter {

    public static void main(String[] args) {
        /*
            TOTORIAL:
            Add the newly created components to the declarer singleton
         */
        DeclarersSingleton.getInstance().add(new DuplicateExtraktorCont())
//        .add(new TemplateSource())
;

        DeclarersSingleton.getInstance().setHostName("10.0.75.1");
        DeclarersSingleton.getInstance().setPort(1010);
        new FlinkInit().init();
    }

}

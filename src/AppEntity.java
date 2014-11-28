import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunil on 11/28/2014.
 */
public abstract class AppEntity {

    Map<String, Object> parameters;

    AppEntity() {
        parameters = new HashMap<String, Object>();
    }

    protected abstract void generateAndAddParametersFromInput(String[] inputParts);

    Map<String, Object> getParameters() {
        return parameters;
    }

    Object getParameter(String key) {
        return parameters.get(key);
    }
}

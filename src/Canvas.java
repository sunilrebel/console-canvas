import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunil on 11/28/2014.
 */
public class Canvas extends AppEntity {

    Canvas() {
        super();
        pixelAdditionFactor = 2;
    }

    Canvas(String[] inputParts) {
        generateAndAddParametersFromInput(inputParts);
    }

    static Boolean isValidInput(String[] inputParts) {
        return inputParts[0].equalsIgnoreCase("c") && inputParts.length == 3;
    }

    static Boolean isValidPoint(Integer x, Integer y, Canvas canvas) {
        if (x == 1)
            return true;
        else if (y == 1)
            return true;
        else if (x.equals(canvas.getParameters().get(CANVAS_PARAMS.X.name())))
            return true;
        else if (y.equals(canvas.getParameters().get(CANVAS_PARAMS.Y.name())))
            return true;

        return false;
    }

    static String getPrintingCharacter(Canvas canvas) {
        return canvas.getParameters().get(CANVAS_PARAMS.CHAR.name()).toString();
    }

    @Override
    protected void generateAndAddParametersFromInput(String[] inputParts) {
        Map<String, Object> params = new HashMap<String, Object>();

        try {
            params.put(CANVAS_PARAMS.X.name(), Integer.parseInt(inputParts[1]) + this.pixelAdditionFactor);
            params.put(CANVAS_PARAMS.Y.name(), Integer.parseInt(inputParts[2]) + this.pixelAdditionFactor);
            params.put(CANVAS_PARAMS.CHAR.name(), "*");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments not valid for canvas");
        }
        parameters = params;
    }

    enum CANVAS_PARAMS {
        X, Y, CHAR
    }
}

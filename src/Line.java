import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunil on 11/28/2014.
 */
public class Line extends AppEntity {

    Line() {
        super();
    }

    Line(String[] inputParts) {
        generateAndAddParametersFromInput(inputParts);
    }

    static Boolean isValidInput(String[] inputParts) {
        return inputParts[0].equalsIgnoreCase("l") && inputParts.length == 5;
    }

    static Boolean isValidPoint(Integer x, Integer y, List<Line> lines) {
        for(Line line: lines) {
            if (x >= (Integer) line.getParameters().get(LINE_PARAMS.X1.name()) && x <= (Integer) line.getParameters().get(LINE_PARAMS.X2.name())
                    && y >= (Integer) line.getParameters().get(LINE_PARAMS.Y1.name()) && y <= (Integer) line.getParameters().get(LINE_PARAMS.Y2.name()))
                return true;
        }
        return false;
    }

    static String getPrintingCharacter(Line line) {
        return line.getParameters().get(LINE_PARAMS.CHAR.name()).toString();
    }

    @Override
    protected void generateAndAddParametersFromInput(String[] inputParts) {
        Map<String, Object> params = new HashMap<String, Object>();

        try {
            params.put(LINE_PARAMS.X1.name(), Integer.parseInt(inputParts[1]) + this.pixelAdditionFactor);
            params.put(LINE_PARAMS.Y1.name(), Integer.parseInt(inputParts[2]) + this.pixelAdditionFactor);
            params.put(LINE_PARAMS.X2.name(), Integer.parseInt(inputParts[3]) + this.pixelAdditionFactor);
            params.put(LINE_PARAMS.Y2.name(), Integer.parseInt(inputParts[4]) + this.pixelAdditionFactor);
            params.put(LINE_PARAMS.CHAR.name(), "*");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments not valid for line");
        }
        parameters = params;
    }

    enum LINE_PARAMS {
        X1, Y1, X2, Y2, CHAR
    }
}

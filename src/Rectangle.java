import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunil on 11/28/2014.
 */
public class Rectangle extends AppEntity {

    Rectangle() {
        super();
    }

    Rectangle(String[] inputParts) {
        generateAndAddParametersFromInput(inputParts);
    }

    static Boolean isValidInput(String[] inputParts) {
        return inputParts[0].equalsIgnoreCase("r") && inputParts.length == 5;
    }

    static Boolean isValidPoint(Integer x, Integer y, List<Rectangle> rectangles) {
        for (Rectangle rectangle : rectangles) {
            if (x >= (Integer) rectangle.getParameters().get(RECTANGLE_PARAMS.X1.name())
                    && x <= (Integer) rectangle.getParameters().get(RECTANGLE_PARAMS.X2.name())
                    && (y == rectangle.getParameters().get(RECTANGLE_PARAMS.Y1.name())
                    || y == rectangle.getParameters().get(RECTANGLE_PARAMS.Y2.name())))
                return true;
            else if ((x == rectangle.getParameters().get(RECTANGLE_PARAMS.X1.name())
                    || x == rectangle.getParameters().get(RECTANGLE_PARAMS.X2.name()))
                    && y >= (Integer) rectangle.getParameters().get(RECTANGLE_PARAMS.Y1.name())
                    && y <= (Integer) rectangle.getParameters().get(RECTANGLE_PARAMS.Y2.name()))
                return true;
        }
        return false;
    }

    static String getPrintingCharacter(Rectangle rectangle) {
        return rectangle.getParameters().get(RECTANGLE_PARAMS.CHAR.name()).toString();
    }

    @Override
    protected void generateAndAddParametersFromInput(String[] inputParts) {
        Map<String, Object> params = new HashMap<String, Object>();

        try {
            params.put(RECTANGLE_PARAMS.X1.name(), Integer.parseInt(inputParts[1]));
            params.put(RECTANGLE_PARAMS.Y1.name(), Integer.parseInt(inputParts[2]));
            params.put(RECTANGLE_PARAMS.X2.name(), Integer.parseInt(inputParts[3]));
            params.put(RECTANGLE_PARAMS.Y2.name(), Integer.parseInt(inputParts[4]));
            params.put(RECTANGLE_PARAMS.CHAR.name(), "*");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments not valid for line");
        }
        parameters = params;
    }
    
    enum RECTANGLE_PARAMS {
        X1, Y1, X2, Y2, CHAR
    }
}

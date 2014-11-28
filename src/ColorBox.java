import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunil on 11/28/2014.
 */
public class ColorBox extends AppEntity {

    List<Line> lines;
    List<Rectangle> rectangles;
    Canvas canvas;

    ColorBox() {
        super();
        lines = new ArrayList<Line>();
        rectangles = new ArrayList<Rectangle>();
        canvas = new Canvas();
    }

    ColorBox(String[] inputParts) {
        generateAndAddParametersFromInput(inputParts);
    }

    void addLines(List<Line> lines) {
        this.lines = lines;
    }

    void addRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    void addCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    List<Rectangle> getAllEmptyRectangles() {
        List<Rectangle> emptyRectangles = new ArrayList<Rectangle>();
        emptyRectangles.addAll(rectangles);
        return emptyRectangles;
    }

    Boolean isPointInOnEmptyArea(Integer x, Integer y, List<Rectangle> emptyRectangles) {
        for (Rectangle rectangle : emptyRectangles) {
            if (x >= (Integer) rectangle.getParameter(Rectangle.RECTANGLE_PARAMS.X1.name())
                    && x <= (Integer) rectangle.getParameter(Rectangle.RECTANGLE_PARAMS.X2.name())
                    && y >= (Integer) rectangle.getParameter(Rectangle.RECTANGLE_PARAMS.Y1.name())
                    && y <= (Integer) rectangle.getParameter(Rectangle.RECTANGLE_PARAMS.Y2.name())) {
                return true;
            }
        }
        return false;
    }

    static Boolean isValidInput(String[] inputParts) {
        return inputParts[0].equalsIgnoreCase("b") && inputParts.length == 4;
    }

    static Boolean isValidPoint(Integer x, Integer y, ColorBox colorBox) {
        /*
        Step 1: find out all empty rectangles
        Step 2: find out the limit of coloring point
         */
        List<Rectangle> emptyRectangles = colorBox.getAllEmptyRectangles();
        if (emptyRectangles.size()==0)
            return false;
        return !colorBox.isPointInOnEmptyArea(x, y, emptyRectangles);
    }

    static String getPrintingCharacter(ColorBox colorBox) {
        return colorBox.getParameters().get(COLORING_BOX.COLOR.name()).toString();
    }

    @Override
    protected void generateAndAddParametersFromInput(String[] inputParts) {
        Map<String, Object> params = new HashMap<String, Object>();

        try {
            params.put(COLORING_BOX.X.name(), Integer.parseInt(inputParts[1]));
            params.put(COLORING_BOX.Y.name(), Integer.parseInt(inputParts[2]));
            params.put(COLORING_BOX.COLOR.name(), inputParts[3]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments not valid for canvas");
        }
        parameters = params;
    }

    enum COLORING_BOX {
        X, Y, COLOR
    }
}

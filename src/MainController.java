import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sunil on 11/28/2014.
 */
public class MainController {
    public static void main(String... args) {
        System.out.println("Welcome to Console Canvas App");
        MainController mainController = new MainController();
        mainController.startApp();
    }

    void startApp() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        InputStorage inputStorage = new InputStorage();

        do {
            System.out.print("Please enter your input: ");
            input = scanner.nextLine();
            System.out.println("Processing your input: " + input);

            if (input.equalsIgnoreCase("q"))
                return;

            String[] inputParts = input.split(" ");
            inputStorage.setInput(inputParts);

            processNewInput(inputStorage.getInput());
        } while (!input.equalsIgnoreCase("q"));
    }

    private void processNewInput(final List<String[]> allInputs) {
        String[] canvasInput = allInputs.get(0);
        Canvas canvas = new Canvas();
        canvas.generateAndAddParametersFromInput(canvasInput);

        List<Line> lines = new ArrayList<Line>();
        List<Rectangle> rectangles = new ArrayList<Rectangle>();
        ColorBox colorBox = new ColorBox();

        if (Canvas.isValidInput(canvasInput)) {
            for (String[] input : allInputs) {
                if (Canvas.isValidInput(input))
                    continue;
                else if (Line.isValidInput(input))
                    lines.add(new Line(input));
                else if (Rectangle.isValidInput(input))
                    rectangles.add(new Rectangle(input));
                else if (ColorBox.isValidInput(input)) {
                    colorBox = new ColorBox(input);
                    colorBox.addLines(lines);
                    colorBox.addRectangles(rectangles);
                    colorBox.addCanvas(canvas);
                } else
                    throw new IllegalArgumentException("The only supported options are Line(l), Rectangle(r), BoxColor(b)");
            }

            Map<String, Object> canvasSize = canvas.getParameters();
            for (int y = 1; y <= (Integer) canvasSize.get(Canvas.CANVAS_PARAMS.Y.name()); y++) {
                for (int x = 1; x <= (Integer) canvasSize.get(Canvas.CANVAS_PARAMS.X.name()); x++) {
                    if (Canvas.isValidPoint(x, y, canvas))
                        System.out.print(canvas.getPrintingCharacter(canvas));
                    else if (Line.isValidPoint(x, y, lines))
                        System.out.print(Line.getPrintingCharacter(lines.get(0)));
                    else if (Rectangle.isValidPoint(x, y, rectangles))
                        System.out.print(Rectangle.getPrintingCharacter(rectangles.get(0)));
                    else if (ColorBox.isValidPoint(x, y, colorBox))
                        System.out.print(ColorBox.getPrintingCharacter(colorBox));
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 11/28/2014.
 */
public class InputStorage {
    private List<String[]> input = null;

    InputStorage() {
        input = new ArrayList<String[]>();
    }

    public List<String[]> getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input.add(input);
    }
}

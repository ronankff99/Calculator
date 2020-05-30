package View.Util;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.Map;

public class Builder
{
    public Map<String, Button> createButtonMap(String[] names)
    {
        Map<String, Button> buttons = new HashMap<>();
        for (String name : names)
        {
            Button temp = new Button(name);
            AppTheme.set(temp);
            buttons.put(name, temp);
        }
        return buttons;
    }

    public HBox[] createHBoxes(int amount)
    {
        HBox[] temp = new HBox[amount];

        for (int i = 0; i < amount; i++)
        {
            temp[i] = new HBox(25);
        }

        return temp;
    }

    public void binGUIComponents(HBox[] rows, Map<String, Button> fields, String[] names, int divisor)
    {
        for (int i = 0; i < names.length; i++)
        {
            rows[i / divisor].getChildren().addAll(fields.get(names[i]));
        }
    }
}

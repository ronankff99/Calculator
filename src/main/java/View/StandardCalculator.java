package View;

import View.Util.AppTheme;
import View.Util.Builder;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Map;

public class StandardCalculator
{
    Label input;
    Map<String, Button> buttons;

    public StackPane create()
    {
        Builder build = new Builder();

        input = new Label();
        input.setText("null");
        AppTheme.set(input);

        // The button names are syntactically formatted like this to help visualize how the buttons will look in the GUI
        String[] buttonNames =
                {
                        "(", ")", "<-", "+",
                        "7", "8", "9", "*",
                        "4", "5", "6", "/",
                        "1", "2", "3", "-",
                        "0", ".", "C", "="
                };

        buttons = build.createButtonMap(buttonNames);

        // Just a concept for handling button clicks
        for (String key : buttonNames)
        {
            buttons.get(key).setOnAction(e -> updateCurrentExpression(key));
        }

        // Although extremely helpful, these methods are questionable in terms of good OOP practices
        HBox[] rows = build.createHBoxes(buttonNames.length / 4);
        build.binGUIComponents(rows, buttons, buttonNames, 4);

        VBox mainContainer = new VBox(25, input);
        mainContainer.getChildren().addAll(rows);
        mainContainer.setPadding(new Insets(35, 20, 20, 20));

        return new StackPane(mainContainer);
    }

    /*
    // TODO: will need to investigate current expression before adding key
    // TODO: will have to handle keys differently depending on both the key entered and the previous key entered, E.g if number previously entered and current key is a number, don't add a space
    // TODO: will have to handle bad input... eventually
     */
    private void updateCurrentExpression(String key)
    {
        String temp = input.getText();

        if (temp.equals("null"))
        {
            temp = "";
        }

        if (temp.length() == 0)
        {
            temp = key;
        }
        else if (Character.isDigit(key.charAt(0)) && Character.isDigit(temp.charAt(temp.length() - 1)))
        {
            temp += key;
        }
        else
        {
            temp += " " + key;
        }

        input.setText(temp);
    }


}

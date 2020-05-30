package View.Util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AppTheme
{
    public static void set(Label label)
    {
        label.setStyle(
                "-fx-min-width: 280;" + /*"-fx-background-color: #F8B195;" +*/
                "-fx-padding: 5 5 5 5;" +
                "-fx-font-size: 16px;" +
                "-fx-border-color: black;"
        );
    }

    public static void set(Button button)
    {
        button.setStyle(
                "-fx-min-width: 50;" + /*"-fx-background-color: #dc143c;" +*/
                "-fx-min-height: 50;" +
                "-fx-padding: 5 5 5 5;" +
                "-fx-font-size: 15px;" /*"-fx-text-fill: #ffffff;"*/
        );
    }

}


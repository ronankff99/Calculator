import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane mainPane = new BorderPane();
            Group root = new Group();
            primaryStage.setTitle("");
            Scene scene = new Scene(root, 850, 450);

            root.getChildren().add(mainPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void setup()
    {

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

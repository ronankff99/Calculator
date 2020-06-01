import View.StandardCalculator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            //BorderPane mainPane = new BorderPane();
            StandardCalculator standardCalculator = new StandardCalculator();
            StackPane mainPane = standardCalculator.create();
            Group root = new Group();
            primaryStage.setTitle("Functionality.Calculator");
            Scene scene = new Scene(root, 325, 475);

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

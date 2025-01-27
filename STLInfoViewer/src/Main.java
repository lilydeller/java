import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage stage)
	{
		Text titleLabel = new Text("Size of Bulbasaur.stl: ");
		Text data = new Text(STLHelper.getFileSize("Bulbasaur.stl"));
		
		Text listLabel = new Text("List of Models");
		
		ObservableList<String> names = FXCollections.observableArrayList();
		
		File f = new File("res/");
		for(File f1 : f.listFiles())
		{
			names.add(f1.getName());
		}
		
		ListView<String> listView = new ListView<String>(names);
		listView.getSelectionModel().select(0);
		//System.out.println(STLHelper.getFileSize("Bulbasaur.stl"));
		
		GridPane gridPane = new GridPane();
		
		Button showInfo = new Button("Show Info");
		showInfo.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e)
				{
					String name = listView.getSelectionModel().getSelectedItem();
					titleLabel.setText("Size of " + name + " :");
					data.setText(STLHelper.getFileSize(name));
				}
		});
		
		gridPane.add(titleLabel, 0, 0);
		gridPane.add(data, 1, 0);
		gridPane.add(listLabel, 0, 1);
		gridPane.add(listView, 0, 2);
		gridPane.add(showInfo, 0, 8);
		
		Scene scene = new Scene(gridPane);
		
		stage.setTitle("STL Info Viewer");
		stage.setHeight(300);
		stage.setWidth(400);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package AgChSaJo.GUI;

import AgChSaJo.JumpOrDie.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ScoreController {

    @FXML
    public VBox container;
    public TextField input;
    public TableView<Player> table;

    /**
     * sets the scene for the score list, creates the table columns and the binding to their content
     * adds the columns to the table and the container
     * @throws Exception in case something goes wrong with the FXML file
     */
    void setUp() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Score.fxml"));
        input =(TextField) root.lookup("#input");
        table =(TableView<Player>) root.lookup("#table");

        App.scoreList = new Scene(root,800,500);

        // Nickname column set up
        TableColumn<Player, String> nickname;
        nickname = new TableColumn<>("Nickname");
        nickname.setMinWidth(200);
        nickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        nickname.setSortable(false);

        // Score column set up
        TableColumn<Player, Integer> score;
        score = new TableColumn<>("Score");
        score.setMinWidth(200);
        score.setCellValueFactory(new PropertyValueFactory<>("finalScore"));
        score.setSortable(false);

        // add columns to the table
        table.getColumns().add(nickname);
        table.getColumns().add(score);

    }

    /**
     * event handling for the Button to get back to the menu
     */
    @FXML
    public void backToMenu(){
        App.window.setScene(App.menu);
    }

    @FXML
    public void filterScorelist() {
        String search = input.getText();
        table.setItems(loadScorelist(search));

    }

    /**
     * resets the data in the table
     */
    void resetScoreListView(){
        table.setItems(loadScorelist(""));
        input.clear();
    }

    /**
     * creates ObservableList with the ArrayList of the ScoreList class
     * @return data returns the ObservableList with the table content
     */
    private ObservableList<Player> loadScorelist(String s){
        ObservableList<Player> data;
        if (s.equals("")){
            data = FXCollections.observableArrayList(JumpOrDie.scoreList.getScoreList());
        }else{
            data = FXCollections.observableArrayList(JumpOrDie.scoreList.getScoreList(s));
        }
        return  data;
    }

}

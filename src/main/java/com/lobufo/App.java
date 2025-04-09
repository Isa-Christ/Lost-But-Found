package com.lobufo;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import com.lobufo.metier.*;
import com.lobufo.repertoire.RepertoireLaptop;
import com.lobufo.repertoire.RepertoireTelephone;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
//import javafx.;
import java.io.IOException;
import com.lobufo.traitement.Card;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static BorderPane root;
    private static TabPane tabPane;
    private static Tab laptop;
    private static Tab telephone;


    @Override
    public void init() throws Exception {
        super.init();
        RepertoireTelephone repertoireTelephone = new RepertoireTelephone();
        RepertoireLaptop repertoireLaptop = new RepertoireLaptop();

        Telephone tel1 = new Telephone("Samsung", "Rouge", "fissure sur la coque exterieur", "/src/main/java/com/lobufo/images/telephone1.jpg", "111111222222211554499");
        Telephone tel2 = new Telephone("Tecno", "Bleu", "", "src/main/java/com/lobufo/images/telephone1.jpg", "111116678877211554499");
        repertoireTelephone.ajouter(tel1);
        repertoireTelephone.ajouter(tel2);

        repertoireLaptop.ajouter(new Laptop("Dell", "Noir", "Dell Inspiron 15", "src/main/java/com/lobufo/images/telephone1.jpg", true, "125453789", 43, 25));
        repertoireLaptop.ajouter(new Laptop("HP", "Gris", "HP Pavilion 15 feutre rouge sur le clavier","src/main/resources/com/lobufo/images/telephone1.jpg", false, "123456789", 43, 25));
        repertoireLaptop.ajouter(new Laptop("Lenovo", "Bleu", "Lenovo IdeaPad 3", "src/main/resources/com/lobufo/images/telephone1.jpg", true, "168685649", 43, 25));

        tabPane = new TabPane();

        laptop = new Tab("Laptop");
        FlowPane laptopArea1 = new FlowPane();
        laptopArea1.setHgap(10);
        laptopArea1.setVgap(10);
        laptopArea1.setStyle("-fx-background-color:rgb(240, 204, 204); -fx-padding: 10px;");

        for(Laptop ltp : repertoireLaptop.getListLaptop()){    
            laptopArea1.getChildren().add(Card.createCard(ltp));
        }
        laptop.setContent(laptopArea1);

        telephone = new Tab("Telephone");
        FlowPane telephoneArea1 = new FlowPane();
        telephoneArea1.setHgap(10);
        telephoneArea1.setVgap(10);
        telephoneArea1.setStyle("-fx-background-color:rgb(235, 230, 230); -fx-padding: 10px;");

        for(Telephone tel : repertoireTelephone.getListTelephone()){    
            Node node = Card.createCard(tel);
            telephoneArea1.getChildren().add(node);
        }
        
        telephone.setContent(telephoneArea1);

        tabPane.getTabs().addAll(laptop,telephone);

    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Gestion des appareils volés");
        root = new BorderPane();
        
        root.setCenter(tabPane);

        Button ajout = new Button("Ajouter un appareil");
        root.setLeft(ajout);
         
        scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
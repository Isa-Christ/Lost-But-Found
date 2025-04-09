package com.lobufo.traitement;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.animation.ScaleTransition;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;

import javafx.util.Duration;

import com.lobufo.metier.Appareil;

public class Card {
    
    public static Node createCard(Appareil appareil) {
        Label marque = new Label(appareil.getMarque());
        Label descriptionLabel = new Label(appareil.getDescription());
        Label couleur = new Label(appareil.getCouleur());
        Button signaler = new Button("Signaler vol");

        signaler.setOnAction(e -> {
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Formulaire de Signalement");

            VBox formulaireSignal = new VBox();
            formulaireSignal.setSpacing(10);
            formulaireSignal.setStyle("-fx-padding: 20px; -fx-background-color: #f9f9f9; -fx-border-color: #ccc; -fx-border-radius: 5px; -fx-background-radius: 5px;");

            Label lieuLabel = new Label("Lieu:");
            lieuLabel.setStyle("-fx-font-weight: bold;");
            TextField lieuField = new TextField();
            lieuField.setStyle("-fx-border-color: #ccc; -fx-border-radius: 3px; -fx-padding: 5px;");

            Label dateLabel = new Label("Date:");
            dateLabel.setStyle("-fx-font-weight: bold;");
            javafx.scene.control.DatePicker datePicker = new javafx.scene.control.DatePicker();
            datePicker.setStyle("-fx-border-color: #ccc; -fx-border-radius: 3px; -fx-padding: 5px;");

            Label heureLabel = new Label("Heure:");
            heureLabel.setStyle("-fx-font-weight: bold;");
            TextField heureField = new TextField();
            heureField.setStyle("-fx-border-color: #ccc; -fx-border-radius: 3px; -fx-padding: 5px;");

            Button submitButton = new Button("Soumettre");
            submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 5px 10px; -fx-border-radius: 3px; -fx-background-radius: 3px;");
            submitButton.setOnMouseEntered(event -> submitButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white;"));
            submitButton.setOnMouseExited(event -> submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));
            submitButton.setOnAction(event -> {
                String lieu = lieuField.getText();
                String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
                String heure = heureField.getText();
                System.out.println("Lieu: " + lieu + ", Date: " + date + ", Heure: " + heure);
                dialog.close();
            });

            formulaireSignal.getChildren().addAll(lieuLabel, lieuField, dateLabel, datePicker, heureLabel, heureField, submitButton);
            Scene signalScene = new Scene(formulaireSignal);
            dialog.setScene(signalScene);
            dialog.showAndWait();
        });

        signaler.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        VBox node = new VBox();
        node.getChildren().addAll(marque, couleur, descriptionLabel, signaler);
        node.setStyle("-fx-border-color: black;-fx-border-width: 1px; -fx-padding: 10px; -fx-background-color: white;");
        node.setPrefSize(150, 200);
        node.setOnMouseEntered(e -> {
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), node);
            transition.setToX(1.05);
            transition.setToY(1.05);
            transition.play();
        });
        node.setOnMouseExited(e -> {
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), node);
            transition.setToX(1);
            transition.setToY(1);
            transition.play();
        });
        return node;
    }
}

package io.github.ink_song.idatt2003.CardGame;
import io.github.ink_song.idatt2003.CardGame.controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.*;

public class App extends Application {

  private GameController controller;
  private Label dealtHandDisplay;
  private Label informationContentText;

  public void start(Stage primaryStage) {
    Scene mainScene = createMainScene();
    String css = this.getClass().getResource("/styling.css").toExternalForm();
    mainScene.getStylesheets().add(css);


    primaryStage.setResizable(false);
    primaryStage.setScene(mainScene);
    primaryStage.setTitle("Card Game");
    primaryStage.show();
  }

  private Scene createMainScene(){
    HBox layout = new HBox();
    Region leftRegion = new Region();
    Region rightRegion = new Region();


    // Defining the game window
    VBox leftContent = new VBox(20);
    // Making the Game window Pane
    StackPane gameWindow = new StackPane();
    gameWindow.setPrefSize(500,300);
    dealtHandDisplay = new Label("Default Text");
    gameWindow.getChildren().add(dealtHandDisplay);
    gameWindow.setPadding(new Insets(10));

    InnerShadow innerShadow = new InnerShadow();
    innerShadow.setOffsetX(2);
    innerShadow.setOffsetY(2);
    innerShadow.setRadius(5);
    innerShadow.setColor(Color.GRAY);

    gameWindow.setEffect(innerShadow);
    gameWindow.setId("gameWindow");

    // Making the "New Hand" button
    StackPane buttonPane = new StackPane();
    Button button = new Button("New Hand");
    button.setOnAction(event -> {dealHand();});
    buttonPane.getChildren().add(button);

    // Building the Left Content Box
    //leftContent.getChildren().addAll(topRegion, gameWindow,bottomRegion, buttonPane);
    leftContent.getChildren().addAll(gameWindow, buttonPane);

    //Right Content Box
    VBox rightContent = new VBox();
    Label informationTitle = new Label("Information");
    //Build our information window
    VBox informationWindow = new VBox();
    informationContentText = new Label("Information Text");
    informationWindow.getChildren().add(informationContentText);

    informationWindow.setPrefSize(300,200);
    informationWindow.setEffect(innerShadow);
    informationWindow.setId("informationWindow");

    Button analysisButton = new Button("Analyze Hand");
    analysisButton.setOnAction(event -> {analysis();});
    Label welcomeText = new Label("Welcome");

    rightContent.getChildren().addAll(informationTitle, informationWindow, analysisButton, welcomeText);
    rightContent.setAlignment(Pos.TOP_CENTER);
    rightContent.setSpacing(20);

    layout.getChildren().addAll(leftRegion, leftContent, rightRegion,rightContent);


    layout.setSpacing(10);
    layout.setPadding(new Insets(10,10,10,10));
    return new Scene(layout,800,600);
  }
  private void dealHand(){
    controller.dealCards();
    dealtHandDisplay.setText(controller.getHandOfCardsAsString());
  }
  private void analysis(){
    informationContentText.setText(controller.analyzeCards());
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void init() throws Exception {
    super.init();
    this.controller = new GameController();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
  }
}

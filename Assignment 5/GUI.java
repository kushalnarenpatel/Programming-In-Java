package com.bham.pij.assignments.edgedetector;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GUI extends Application {
	
	ImageView imageView;
	
	Image currentImage;
	
	Image previousImage;
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Edge Detection Tool");
		
		VBox root = new VBox();
		
		Menu fileMenu = new Menu("File");
		
		MenuItem openItem = new MenuItem("Open");
		
		MenuItem closeItem = new MenuItem("Close");
		
		fileMenu.getItems().addAll(openItem, closeItem);
		
		Menu toolMenu = new Menu("Tools");
		
		MenuItem edgeDetectionItem = new MenuItem("Edge Detection");
		
		MenuItem revertItem = new MenuItem("Revert");
		
		toolMenu.getItems().addAll(edgeDetectionItem,revertItem);
		
		MenuBar menuBar = new MenuBar();
		
		menuBar.getMenus().add(fileMenu);
		
		menuBar.getMenus().add(toolMenu);
		
		closeItem.setDisable(true);
		
		edgeDetectionItem.setDisable(true);
		
		revertItem.setDisable(true);
		
		root.getChildren().add(menuBar);
		
		stage.setScene(new Scene(root, 500, 500));
		
		stage.show();
	
		openItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	
			public void handle(ActionEvent t) {
				
				FileChooser fileChooser = new FileChooser();
			
				fileChooser.setTitle("Open Image File");
			
				File file =
			
						fileChooser.showOpenDialog(stage);

				if (file != null) {
			
					loadImageFile(file);
			
				}
			
			}
			
			private void loadImageFile(File file) {
				
				closeItem.setDisable(false);
				
				openItem.setDisable(true);
				
				edgeDetectionItem.setDisable(false);
				
				Image image = new Image("file:" + file.getPath());
				
				ImageView imgView = new ImageView(image);
				
				imageView = imgView;
				
				currentImage = image;
				
				root.getChildren().add(imgView);
				
			}
			
		});
			
		closeItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	
			public void handle(ActionEvent t) {
				
				root.getChildren().remove(imageView);
				
				imageView = null;
				
				openItem.setDisable(false);
				
				closeItem.setDisable(true);
				
				edgeDetectionItem.setDisable(true);
				
				revertItem.setDisable(true);
				
			}
			
		});
		
		edgeDetectionItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	
			public void handle(ActionEvent t) {
				
				EdgeDetector ed = new EdgeDetector();
				
				previousImage = currentImage;
			
				currentImage = ed.filterImage(currentImage);
				
				root.getChildren().remove(imageView);
				
				imageView.setImage(currentImage);
				
				root.getChildren().add(imageView);
				
				revertItem.setDisable(false);
				
				edgeDetectionItem.setDisable(true);
			
			}
			
		});
		
		revertItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	
			public void handle(ActionEvent t) {
				
				root.getChildren().remove(imageView);
				
				imageView = new ImageView(previousImage);
				
				currentImage = previousImage;
				
				root.getChildren().add(imageView);
				
				revertItem.setDisable(true);
				
				edgeDetectionItem.setDisable(false);
			
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}

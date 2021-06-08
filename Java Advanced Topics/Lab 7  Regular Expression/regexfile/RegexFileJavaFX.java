package regexfile;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.chart.*;
import javafx.collections.*; 
import javafx.beans.property.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;

/*
\"(.+),\s*(.+)\",\d+,\d+\D+(\d+)

*/
public class RegexFileJavaFX extends Application {
    public static void main(String[] args) {

        Application.launch(args);

    }
    
    @Override
    public void start(Stage primaryStage) {
    
        ExtractData extract = new ExtractData(); 
        ArrayList<String> lname = extract.lastname;
        ArrayList<String> fname = extract.firstname;
        ArrayList<String> id = extract.id;
        ArrayList<Character> al = extract.al;
        
        ObservableList<String> list = FXCollections.observableArrayList();
        ListView<String> listView= new ListView<String>();
        listView.setPrefWidth(100);
        listView.setPrefHeight(250);
        listView.setItems(list);

        Collections.sort(al);
        ComboBox combo_lname = new ComboBox(FXCollections.observableArrayList(al));
        combo_lname.setValue("Select Last Name's first letter");
        combo_lname.setStyle("-fx-font-size: 1.5em;");
        combo_lname.setOnAction(e ->{
            listView.getItems().clear();
            String str = combo_lname.getValue().toString();
            for(int i=0; i<lname.size(); i++){
                if(lname.get(i).charAt(0) == str.charAt(0)){
                    list.add(id.get(i) + " : " + fname.get(i)+ " : "+ lname.get(i));
                }
            }
        });

        //charts
        Pane pane = new Pane();
        Map<Character,Integer> mp = new HashMap<Character,Integer>();
        for(String st : lname){
            if(mp.keySet().contains(st.charAt(0))){
                mp.put(st.charAt(0),mp.get(st.charAt(0))+1);

            }else{
                mp.put(st.charAt(0),1);

            }

        }
    PieChart pieChart = new PieChart();
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    for(Map.Entry<Character,Integer> el : mp.entrySet()){
        data.add(new PieChart.Data(String.valueOf(el.getKey()),el.getValue()));

    }

    pieChart.setData(data);
    pieChart.setTitle("Chart");
    pieChart.setClockwise(true);
    pieChart.setLabelLineLength(10);
    pieChart.setLabelsVisible(true);
    pieChart.setStartAngle(360);

    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("Alpha Names");
    yAxis.setLabel("number of students");
    BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis);
    XYChart.Series dataSeries1 = new XYChart.Series();
    dataSeries1.setName("Students");
    for(Map.Entry<Character,Integer> el : mp.entrySet()){
       dataSeries1.getData().add(new XYChart.Data(String.valueOf(el.getKey()), el.getValue()));

    }
    barChart.getData().add(dataSeries1);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(combo_lname,listView,pane);
        primaryStage.setTitle("Regular Expression Student List");
        Scene scene = new Scene(vbox, 550, 800);
        primaryStage.setScene(scene);
        primaryStage.show();


        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run(){
                int i =0;
                while(true){
                    try{
                        Thread.sleep(2000);


                    }catch(InterruptedException e){

                        e.printStackTrace();
                    }
                
                    if(i == 0) 
                        i=1;
                    else 
                        i=0;
                    final int p=i;

                Platform.runLater(new Runnable() {
                    @Override
                    public void run(){
                        if(pane.getChildren().size()>0){
                            for(int i =0; i <pane.getChildren().size(); i++){

                                pane.getChildren().remove(pane.getChildren().get(i));


                            }
                        }
                        
                        if(p==0){
                            pane.getChildren().add(pieChart);        
                        }else{
                            pane.getChildren().add(barChart);
                        }
                    }
                });
            }
            }
        });
       taskThread.start();
    }

}


//javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls copy\Copy.java
//java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls copy\Copy.java
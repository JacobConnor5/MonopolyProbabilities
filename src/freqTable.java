
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.LinkedHashSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class freqTable extends Application {
    static LinkedHashMap <String,Integer> Squaretable;

    private static LinkedHashMap <String,Integer> table = new LinkedHashMap<>();
    private XYChart.Series<String, Number> series1 =
            new XYChart.Series<>();

    private String[] colours;

    public freqTable(){
        Squaretable = new LinkedHashMap<>();

        colours = new String[]{"Brown", "Light Blue","Pink","Orange","Red","Yellow","Green","Blue","Trains","Utils"};

        if (table.isEmpty()) {
            System.out.println("start run");
            for (int i = 0; i < colours.length; i++) {

                table.put(colours[i], 0); //initialises the table to 0
                System.out.println(colours[i]+":"+table.get(colours[i]));
            }
        }
    }


    public void log(int pos){
        if(pos == 5 || pos == 15 || pos == 25 || pos == 35){
            table.put("Trains",table.get("Trains")+1); //updates the relavent group
        }
        if(pos == 6 || pos == 8 || pos == 9){
            table.put("Light Blue",table.get("Light Blue")+1);
        }

        if(pos == 11 || pos == 13 || pos == 14){
            table.put("Pink",table.get("Pink")+1);
        }

        if(pos == 16 || pos == 18 || pos == 19){
            table.put("Orange",table.get("Orange")+1);
        }

        if(pos == 21 || pos == 23 || pos == 24){
            table.put("Red",table.get("Red")+1);
        }

        if(pos == 26 || pos == 28 || pos == 29){
            table.put("Yellow",table.get("Yellow")+1);
        }
        if(pos == 31 || pos == 32 || pos == 34){
            table.put("Green",table.get("Green")+1);
        }
        if(pos == 1|| pos == 3){
            table.put("Brown",table.get("Brown")+1);
        }

        if(pos == 37|| pos == 39){
            table.put("Blue",table.get("Blue")+1);
        }
        if(pos == 12|| pos == 28){
            table.put("Utils",table.get("Utils")+1);
        }

//        table.put(pos,table.get(pos)+1);
    }
    public void plot(){
        System.out.println("Table before launch: " + table.get(colours[0]));
        launch();

    }
    public void getter(){
        System.out.println("running getter ____________");
        for (int i = 0;i< colours.length;i++){
            System.out.println(colours[i]+":"+table.get(colours[i]));
        }

    }

    @Override
    public void start(Stage stage){
        stage.setTitle("monopoly board probabilities");
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();

        BarChart <String,Number> bc =new BarChart<String,Number>(x,y);
        x.setLabel("Colour");
        y.setLabel("frequency");

        //x.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Brown","Light Blue","Pink","Orange","Red","Yellow","Green","Blue","Trains","Utils")));

        for (int i = 0; i< this.colours.length; i++){ //loops through the clours array and adds a category to the x axis each time
            series1.getData().add(new XYChart.Data<>(colours[i], table.get(colours[i])));//table.get(colours[i])));
        }

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
}


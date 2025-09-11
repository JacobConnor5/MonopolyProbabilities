
import java.util.*;

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
    static LinkedHashMap<String, Integer> Squaretable;

    private static LinkedHashMap<String, Integer> table = new LinkedHashMap<>();
    private XYChart.Series<String, Number> series1 =
            new XYChart.Series<>();

    private final LinkedHashMap<String, List<Integer>> colours = new LinkedHashMap<>();
    {
    colours.put("Brown",List.of(1,3));
    colours.put("Light Blue",List.of(6,8,9));
    colours.put("Pink",List.of(11,13,14));
    colours.put("Orange",List.of(16,18,19));
    colours.put("Red",List.of(21,23,24));
    colours.put("Yellow",List.of(26,28,29));
    colours.put("Green",List.of(31,32,34));
    colours.put("Blue",List.of(37,39));
    colours.put("Trains",List.of(5,15,25,35));
    colours.put("Utilities",List.of(12,28));
    };

    public freqTable(){
        Squaretable = new LinkedHashMap<>();

        if (table.isEmpty()) {
            String colour;
            for (Map.Entry<String, List<Integer>> entry : colours.entrySet()) { //loops through the colours map
                colour = entry.getKey();//this is the colour currently on
                System.out.println("testing testing: "+colour);
                table.put(colour, 0); //initialises the table to 0
            }
        }
    }

    public void log(int pos){
        for (Map.Entry<String, List<Integer>> entry : colours.entrySet()){
            if (entry.getValue().contains(pos)){
                table.put(entry.getKey(),table.get(entry.getKey())+1); //updates the relevant group in the table mapping
            }
        }

    }
    public void plot(){
        launch();

    }
    public void getter(){
        System.out.println("running getter ____________");
        String colour;
        for (Map.Entry<String, List<Integer>> entry : colours.entrySet()){
            colour = entry.getKey();
            System.out.println(colour+":"+table.get(colour));
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
        String colour;
        for (Map.Entry<String, List<Integer>> entry : colours.entrySet()){ //loops through the clours array and adds a category to the x axis each time
            colour = entry.getKey();
            System.out.println("\n\ncolour: "+colour+"\ntotal frequency: "+table.get(colour)+"\nrelative frequency: "+ ((float) table.get(colour)/(float) colours.get(colour).size()));

            series1.getData().add(new XYChart.Data<>(colour, (float) (table.get(colour)/colours.get(colour).size())));//table.get(colours[i])));
        }

        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
}


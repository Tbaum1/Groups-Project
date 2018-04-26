package subway;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @Anthony Tennenbaum
 */
public class Subway extends Application {
    RadioButton sixInche = new RadioButton("6 inch sub");
    RadioButton twelveInche = new RadioButton("12 inch sub");
    RadioButton salt = new RadioButton("Salt");
    RadioButton pepper = new RadioButton("Pepper");
    Region left = new Region();
    Region top = new Region();
    Region topSpacer = new Region();
    Region cheeseSpacer = new Region();
    Region bottom = new Region();
    Region right = new Region();
    Pane pane = new Pane();
    ToggleGroup group = new ToggleGroup();
    ComboBox breadType = new ComboBox();
    CheckBox ham = new CheckBox("Ham");
    CheckBox turkey = new CheckBox("Turkey");
    CheckBox pepperoni = new CheckBox("Pepperoni");
    CheckBox bacon = new CheckBox("bacon");
    CheckBox american = new CheckBox("American");
    CheckBox provolone = new CheckBox("Provolone");
    CheckBox swiss = new CheckBox("Swiss");
    CheckBox onions = new CheckBox("Onions");
    CheckBox tomatoes = new CheckBox("Tomatoes");
    CheckBox lettuce = new CheckBox("Lettuce");
    CheckBox olives = new CheckBox("Olives");
    CheckBox mayo = new CheckBox("Mayo");
    CheckBox mustard = new CheckBox("Mustard");
    CheckBox ranch = new CheckBox("Ranch");
    CheckBox vinegrete = new CheckBox("Vinegrete");
    Label lblTitle = new Label("    OTHERWAY\nSANDWICH POS");
    Label lblMeat = new Label("Type of Meat");
    Label lblSize = new Label("Bread Size");
    Label lblPepperSalt = new Label("Salt and Pepper");
    Label lblVeggieLabel = new Label("Vegetables");
    Label lblSauce = new Label("Sauce");
    Label lblCheeses = new Label("Cheese Type");
    HBox veggies1 = new HBox(15);
    HBox veggies2 = new HBox(15);
    HBox sauce1 = new HBox(15);
    HBox sauce2 = new HBox(15);
    HBox hbox;
    VBox sizes = new VBox(20);
    VBox meatType = new VBox(15);
    VBox cheese = new VBox(15);
    VBox vegetable = new VBox(15);
    VBox saltPepper = new VBox(15);
    VBox sauces = new VBox(15);
    TextArea display = new TextArea();
    ArrayList<String> order = new ArrayList<>();
    Button submit = new Button("Submit");
    String output = "";
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        BorderPane.setMargin(sizes, new Insets(20,20,20,20));
        GridPane center = new GridPane();
        initComponents();
        bread();
//        breadComponents();
        meatComponents();
        cheeseComponents();
        veggieComponents();
        sauceComponents();
        pepperNsalt();
//        center.add(bottom, 0, 0);
        center.add(sizes, 1, 1);
        center.add(meatType, 2, 1);
        center.add(cheese,3,1); 
        center.add(vegetable,1,2);
        center.add(sauces, 2, 2);
        center.add(saltPepper, 3, 2);
        center.add(display, 1, 3, 3,1);
        center.add(submit, 1,4);
        root.setCenter(center);
        root.setLeft(left);
        root.setRight(right);
        root.setBottom(bottom);
        root.setTop(pane);
        root.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));
        Scene scene = new Scene(root, 1200, 900);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setTitle("Subway");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void bread(){
        sixInche.setToggleGroup(group);
        sixInche.setPadding(new Insets(25,0,0,50));
        twelveInche.setToggleGroup(group);
        twelveInche.setPadding(new Insets(0,0,10,50));
        sizes.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        sizes.getChildren().addAll(lblSize, sixInche, twelveInche, breadType);
        sizes.getStyleClass().add("breadBox");
        lblSize.setPadding(new Insets(25,0,0,75));
        sizes.getStyleClass().add("bread");
        breadType.getItems().addAll("Wheat", "Italian", "Honey Oat", "Monterey Cheddar");
        breadType.setPromptText("Bread Type");
        
        breadType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                order.add(" +" + newValue);
            }
        });
        
        sixInche.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +6 Inch ");
                }
            }    
        });
            
        twelveInche.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +12 Inch ");
                }
            }    
        });
    }
    
    private void initComponents(){
        BorderPane.setAlignment(display, Pos.TOP_CENTER);
//        pane.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));
        pane.getChildren().addAll(top, lblTitle);
        lblTitle.layoutXProperty().bind(pane.widthProperty().subtract(lblTitle.widthProperty()).divide(2));
        lblTitle.getStyleClass().add("title");
        lblTitle.setFont(Font.font(30));
        left.setPrefSize(250, 900);
        left.getStyleClass().add("left");
        right.setPrefSize(250, 900);
        right.getStyleClass().add("right");
        bottom.getStyleClass().add("bottom");
//        topSpacer.setPrefSize(25, 40);
        top.setPrefSize(1207, 125);
        top.getStyleClass().add("title");
        bottom.setPrefSize(600, 100);
        display.setPrefSize(600, 550);
        submit.setOnAction((e) ->{
            for(String s: order){
                output = output + s + "\n";
            }
            display.setText(output );
         order.clear();
        });
    }
    
    public void pepperNsalt(){
        saltPepper.getChildren().addAll(lblPepperSalt, salt, pepper);
//        saltPepper.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        saltPepper.getStyleClass().add("sp");
        lblPepperSalt.setPadding(new Insets(25,0,0,65));
        salt.setPadding(new Insets(25,0,0,45));
        pepper.setPadding(new Insets(0,0,0,45));
        
        salt.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add( " +Salt ");
                }
            }
        });
       pepper.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Pepper ");
                }
            }
        });
    }
    
    public void veggieComponents(){
//        vegetable.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        vegetable.getChildren().addAll(lblVeggieLabel,veggies1, veggies2);
        veggies1.getChildren().addAll(onions, tomatoes);
        veggies2.getChildren().addAll(lettuce, olives);
        vegetable.getStyleClass().add("vegetables");
        lblVeggieLabel.setPadding(new Insets(25,0,0,85));
        onions.setPadding(new Insets(0,0,0,25));
        tomatoes.setPadding(new Insets(0,0,0,25));
        olives.setPadding(new Insets(0,0,0,25));
        lettuce.setPadding(new Insets(0,0,0,25));
        
        onions.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Onions ");
                }
            }
        });
        tomatoes.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Tomatoes ");
                }
            }
        });
        olives.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Olives ");
                }
            }
        });
        lettuce.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Lettuce ");
                }
            }
        });
    }
    
    public void sauceComponents(){
        sauce1.getChildren().addAll(mayo,mustard);
        sauce2.getChildren().addAll(ranch,vinegrete);
        sauces.getChildren().addAll(lblSauce,sauce1, sauce2);
//        sauces.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        sauces.getStyleClass().add("sauces");
        lblSauce.setPadding(new Insets(25,0,0,100));
        mayo.setPadding(new Insets(0,0,0,25));
        mustard.setPadding(new Insets(0,0,0,25));
        ranch.setPadding(new Insets(0,0,0,25));
        vinegrete.setPadding(new Insets(0,0,0,25));
        
        mayo.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Mayo ");
                }
            }
        });
        mustard.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Mustard ");
                }
            }
        });
        ranch.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Ranch ");
                }
            }
        });
        vinegrete.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Vinegrete ");
                }
            }
        });
    }
    
    public void cheeseComponents(){
        cheese.getChildren().addAll(lblCheeses,new HBox(american, swiss),new HBox(provolone));
        cheese.getStyleClass().add("cheeses");
        american.setPadding(new Insets(0,0,0,25));
        swiss.setPadding(new Insets(0,0,0,25));
        provolone.setPadding(new Insets(0,0,0,25));
        lblCheeses.setPadding(new Insets(25,0,0,75));
        
        american.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +American ");
                }
            }
        });
        swiss.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Swiss ");
                }
            }
        });
        provolone.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Provolone ");
                }
            }
        });
    }
    
    public void meatComponents(){
        meatType.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        meatType.getChildren().add(lblMeat);
        meatType.getChildren().add(new HBox(turkey, bacon));
        meatType.getChildren().add(new HBox(pepperoni, ham));
        meatType.getStyleClass().add("meatBox");
        lblMeat.setPadding(new Insets(25,0,0,75));
        ham.setPadding(new Insets(0,0,0,25));
        turkey.setPadding(new Insets(0,0,0,25));
        pepperoni.setPadding(new Insets(0,0,0,25));
        bacon.setPadding(new Insets(0,0,0,25));
        
        turkey.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Turkey ");
                }
            }
        });
        
        bacon.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Banon ");
                }
            }
        });
        
        ham.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Ham ");
                }
             }
        });   
        
        pepperoni.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Pepperoni ");
                }
            }
        });
   }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
    }

}
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
    Region submitSpacer = new Region();
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
    Label lblVeggie = new Label("Vegetables");
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
        BorderPane root = new BorderPane();  //create borderPane as root
        BorderPane.setMargin(sizes, new Insets(20,20,20,20));  //set margins for root
        GridPane center = new GridPane();  //create gridPane
        initComponents();  //call method initComponets
        bread();  //call method bread
//        breadComponents();
        meatComponents(); //call method meatComponents
        cheeseComponents();  //call method cheeseComponents
        veggieComponents();  //call method veggieComponents
        sauceComponents();  //call method sauceComponents
        pepperNsalt();  //call method pepperNsalt
//        center.add(bottom, 0, 0);
        center.add(sizes, 1, 1);  //adding vbox sizes to gridPane
        center.add(meatType, 2, 1); //adding vbox meatType to gridPane
        center.add(cheese,3,1); //adding vbox cheese to gridPane
        center.add(vegetable,1,2);  //adding vbox vegetable to gridPane
        center.add(sauces, 2, 2);  //adding vbox sauces to gridPane
        center.add(saltPepper, 3, 2);  //adding vbox saltPepper to gridPane
        center.add(display, 1, 3, 3,1);  //adding textArea display to gridPane
        center.add(submit, 1,4);  //adding submit button
        center.add(submitSpacer, 2, 4, 2,1);
        root.setCenter(center);  //adding the gridPane to root
        root.setLeft(left);  //adding left region
        root.setRight(right);  //adding right region
        root.setBottom(bottom);  //adding bottom region
        root.setTop(pane);  //adding pane 
        root.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));  //create border around the borderPane
        Scene scene = new Scene(root, 1200, 900);  //create scene
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());  //adding style sheet to scene
        primaryStage.setResizable(false);  //set stage resize to false
        primaryStage.setTitle("Subway");  //set title
        primaryStage.setScene(scene);  //set scene
        primaryStage.show();  //display stage
    }
    
    public void bread(){
        sixInche.setToggleGroup(group);  //adding sixInche radio button to toggle group
        sixInche.setPadding(new Insets(25,0,0,50)); //set padding for sixInche
        twelveInche.setToggleGroup(group);  //adding twelveInche radio button to toggle group
        twelveInche.setPadding(new Insets(0,0,10,50)); //set padding for twelveInche
        //sizes.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        sizes.getChildren().addAll(lblSize, sixInche, twelveInche, breadType); //adding objects to vbox sizes
        sizes.getStyleClass().add("bread");  //add class for css styling of vbox sizes
        lblSize.setPadding(new Insets(25,0,0,75));  //set padding for lblSize
        breadType.getItems().addAll("Wheat", "Italian", "Honey Oat", "Monterey Cheddar");  //adding objects to comboBox breadType
        breadType.setPromptText("Bread Type");  //add class for comboBox
        
        //listener for comboBox breadType for when you click on one it updates into the ArrayList called order
        breadType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                order.add(" +" + newValue);
            }
        });
        
        //listener for radio button sixInche
        sixInche.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +6 Inch ");
                }
            }    
        });
        
        //listener for radio button twelceInche
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
        BorderPane.setAlignment(display, Pos.TOP_CENTER);  //set alignment for textArea called display
//        pane.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));
        pane.getChildren().addAll(top, lblTitle);  //adding top region and lblTitle to pane  
        lblTitle.layoutXProperty().bind(pane.widthProperty().subtract(lblTitle.widthProperty()).divide(2));  //create border for lblTitle
        lblTitle.getStyleClass().add("title");  //add class for lblTitle
        lblTitle.setFont(Font.font(30));  //set font size
        left.setPrefSize(250, 900);  //set size of the left region
        left.getStyleClass().add("left");  //add class for css for left region
        right.setPrefSize(250, 900);  //set size of the right region
        right.getStyleClass().add("right");  //add class for css for right region
        bottom.getStyleClass().add("bottom");  //add class for css for bottom region
//        topSpacer.setPrefSize(25, 40);
        top.setPrefSize(1207, 125); //set size of the top region
        top.getStyleClass().add("title");  //add class for css for top region
        bottom.setPrefSize(600, 100);  //set size of the bottom region
        display.setPrefSize(600, 550);  //set size of textArea
        submitSpacer.getStyleClass().add("filler");
        submit.setOnAction((e) ->{  //lamda for submit button
            for(String s: order){  //iterate through ArrayList order
                output = output + s + "\n";  //adding strings to order plust what was already in order
            }
            display.setText(output );  //displays order in the textArea
         order.clear();  //clears order
        });
    }
    
    public void pepperNsalt(){  
        saltPepper.getChildren().addAll(lblPepperSalt, salt, pepper);  //adding objects to vbox saltPepper
//        saltPepper.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        saltPepper.getStyleClass().add("sp");  //add class for css for saltPepper
        lblPepperSalt.setPadding(new Insets(25,0,0,65));  //set padding for lblPepperSalt
        salt.setPadding(new Insets(25,0,0,45));  //set padding for radio button salt
        pepper.setPadding(new Insets(0,0,0,45));  //set padding for radio button pepper
        
        salt.selectedProperty().addListener(new ChangeListener<Boolean>() {  //add listener to radio button salt
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add( " +Salt ");  //adds string to order
                }
            }
        });
       pepper.selectedProperty().addListener(new ChangeListener<Boolean>() { //add listener to radio button pepper
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Pepper "); //add string to order
                }
            }
        });
    }
    
    public void veggieComponents(){
//        vegetable.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        vegetable.getChildren().addAll(lblVeggie,veggies1, veggies2); //adding objects to vbox vetetable
        veggies1.getChildren().addAll(onions, tomatoes);  //adding objects to hbox veggie1
        veggies2.getChildren().addAll(lettuce, olives);  //adding objects to hbox veggie2
        vegetable.getStyleClass().add("vegetables");  //add class for css for vbox vegetable
        lblVeggie.setPadding(new Insets(25,0,0,85));  //set padding for lblVeggie
        onions.setPadding(new Insets(0,0,0,25)); //set padding for onion checkbox
        tomatoes.setPadding(new Insets(0,0,0,25));  //set padding for tomatoes checkbox
        olives.setPadding(new Insets(0,0,0,25));  //set padding for olives checkbox
        lettuce.setPadding(new Insets(0,0,0,25));  //set padding for lettuce checkbox
        
        onions.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to onions checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Onions ");  //add string to order
                }
            }
        });
        
        tomatoes.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to tomatoes checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Tomatoes ");  //add string to order
                }
            }
        });
        
        olives.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to olives checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Olives ");  //add string to order
                }
            }
        });
        
        lettuce.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to lettuce checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Lettuce ");  //add string to order
                }
            }
        });
    }
    
    public void sauceComponents(){
        sauce1.getChildren().addAll(mayo,mustard);  //adding objects to hbox sauce1
        sauce2.getChildren().addAll(ranch,vinegrete);  //adding objects to hbox sauce2
        sauces.getChildren().addAll(lblSauce,sauce1, sauce2);  //adding objects to vbox sauces
//        sauces.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        sauces.getStyleClass().add("sauces");  //add class for css for vbox sauces
        lblSauce.setPadding(new Insets(25,0,0,100));  //set padding for lblSuace
        mayo.setPadding(new Insets(0,0,0,25));  //set padding for checkbox mayo
        mustard.setPadding(new Insets(0,0,0,25));  //set padding for checkbox mustard
        ranch.setPadding(new Insets(0,0,0,25));  //set padding for checkbox ranch
        vinegrete.setPadding(new Insets(0,0,0,25));  //set padding for checkbox vinegrette
        
        mayo.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to mayo checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Mayo ");  //add string to order
                }
            }
        });
        
        mustard.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to mustard checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Mustard ");  //add string to order
                }
            }
        });
        
        ranch.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to ranch checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Ranch ");  //add string to order
                } 
            }
        });
        
        vinegrete.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to vinegrette checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Vinegrete ");  //add string to order
                }
            }
        });
    }
    
    public void cheeseComponents(){
        cheese.getChildren().addAll(lblCheeses,new HBox(american, swiss),new HBox(provolone));  //adding objects to vbox cheese
        cheese.getStyleClass().add("cheeses"); //add class for css for vbox cheese
        american.setPadding(new Insets(0,0,0,25)); //set padding for checkbox american
        swiss.setPadding(new Insets(0,0,0,25));  //set padding for checkbox swiss
        provolone.setPadding(new Insets(0,0,0,25));  //set padding for checkbox provolone
        lblCheeses.setPadding(new Insets(25,0,0,75));  //set padding for lblCheese
        
        american.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to american checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +American ");  //add string to order
                }
            }
        });
        
        swiss.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to swiss checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Swiss ");  //add string to order
                }
            }
        });
        
        provolone.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to provolone checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if(newValue){
                    order.add(" +Provolone ");  //add string to order
                }
            }
        });
    }
    
    public void meatComponents(){
        //meatType.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1.5))));
        meatType.getChildren().add(lblMeat);  //adding label to vbox meatType
        meatType.getChildren().add(new HBox(turkey, bacon));  //objects to vbox meatType
        meatType.getChildren().add(new HBox(pepperoni, ham));  //objects to vbox meatType
        meatType.getStyleClass().add("meatBox");  //add class for css for vbox meatType
        lblMeat.setPadding(new Insets(25,0,0,75));  //set paddinf for lblMeat
        ham.setPadding(new Insets(0,0,0,25));  //set padding for checkbox ham
        turkey.setPadding(new Insets(0,0,0,25));  //set padding for checkbox turkey
        pepperoni.setPadding(new Insets(0,0,0,25));  //set padding for checkbox pepperonti
        bacon.setPadding(new Insets(0,0,0,25));  //set padding for checkbox bacon
        
        turkey.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to turkey checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Turkey ");  //add string to order
                }
            }
        });
        
        bacon.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to bacon checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Banon ");  //add string to order
                }
            }
        });
        
        ham.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to ham checkbox
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Ham ");  //add string to order
                }
             }
        });   
        
        pepperoni.selectedProperty().addListener(new ChangeListener<Boolean>() {  //listener to pepperoni checkbox 
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue){
                if(newValue){
                    order.add(" +Pepperoni ");  //add string to order
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

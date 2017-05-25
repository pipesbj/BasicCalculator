/*
 * 
 */
package BasicCalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pipes
 */
public class BasicCalculator extends Application {
    Button btn_pls, btn_min, btn_mul, btn_div, btn_clr, btn_mod, btn_pow;
    TextField txt_n1, txt_n2;
    Label lbl_ans;
    ColumnConstraints col1 = new ColumnConstraints();
    ColumnConstraints col2 = new ColumnConstraints();
    @Override
    public void start(Stage primaryStage) {
        btn_pls = new Button("+");
        btn_min = new Button("-");
        btn_mul = new Button("*");
        btn_div = new Button("÷");
        btn_mod = new Button("mod");
        btn_pow = new Button("^");
        btn_clr = new Button("Clear");
        lbl_ans = new Label("...");
        lbl_ans.setAlignment(Pos.CENTER);
        txt_n1 = new TextField();
        txt_n2 = new TextField();
       
        setStyle();
        
        GridPane root = new GridPane();
        
        //set alignment to middle of scene
        root.setAlignment(Pos.CENTER);
        //parameters are add(COLUMN,ROW, COLSPAN, ROWSPAN)
        root.setHgap(10);
        root.setVgap(10);
        root.add(txt_n1, 0, 0);
        root.add(txt_n2, 1, 0);
        root.add(btn_pls, 0, 1, 1, 1);
        root.add(btn_min, 1, 1, 1, 1);
        root.add(btn_mul, 0, 2, 1, 1);
        root.add(btn_div, 1, 2, 1, 1);
        root.add(btn_mod, 0, 3, 1, 1);
        root.add(btn_pow, 1, 3, 1, 1);
        root.add(lbl_ans, 0, 4, 2, 1);
        root.add(btn_clr, 0, 5, 2, 1);
        
        
        attachCode();
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Basic Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(BasicCalculator.class.getResource("bccss.css").toExternalForm());
        primaryStage.show();
    }
public void setStyle(){
   
    
    col1.setPercentWidth(45);
    col2.setPercentWidth(45);
    lbl_ans.setMinWidth(300);
    lbl_ans.setMinHeight(35);
    btn_pls.setMinWidth(150);
    btn_min.setMinWidth(150);
    btn_mul.setMinWidth(150);
    btn_div.setMinWidth(150);
    btn_mod.setMinWidth(150);
    btn_pow.setMinWidth(150);
    btn_clr.setMinWidth(300);
}
public void attachCode(){
    btn_pls.setOnAction(e -> btnop(e));
    btn_min.setOnAction(e -> btnop(e));
    btn_mul.setOnAction(e -> btnop(e));
    btn_div.setOnAction(e -> btnop(e));
    btn_mod.setOnAction(e -> btnop(e));
    btn_pow.setOnAction(e -> btnop(e));
    btn_clr.setOnAction(e -> btnop(e));
}
public void btnop(ActionEvent e){
    int n1, n2, ans = 0;
    float nf1, nf2, ansf;
    if(e.getSource()==btn_clr){
        txt_n1.setText("");
        txt_n2.setText("");
        lbl_ans.setText("...");
        txt_n1.requestFocus();
        return;
    }
    else if(e.getSource() == btn_div){
        nf1 = Float.parseFloat(txt_n1.getText());
        nf2 = Float.parseFloat(txt_n2.getText());
        ansf = nf1 / nf2;
        
        lbl_ans.setText("" + ansf);
        return;
    }
    n1 = Integer.parseInt(txt_n1.getText());
    n2 = Integer.parseInt(txt_n2.getText());
    
    if(e.getSource()==btn_pls){
        ans = n1 + n2;
    }
    else if(e.getSource() == btn_min){
        ans = n1 - n2;
    }
    else if(e.getSource() == btn_mul){
        ans = n1 * n2;
    }
    else if(e.getSource() == btn_mod){
        ans = n1 % n2;
    }
    else if(e.getSource() == btn_pow){
        ans = 1;
        for(int i = 0; i < n2; i++){
            ans*= n1;
        }
        
    }
    
    lbl_ans.setText("" + ans);
}
}

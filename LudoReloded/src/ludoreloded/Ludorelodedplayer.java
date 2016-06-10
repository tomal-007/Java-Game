
package ludoreloded;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.ConectionUtillities;
public class Ludorelodedplayer extends Application {
    
    static Stage stage;
    Scene s1,s2,s3,s4,s5,s6;
    player snkp[]=new player[5];
    Circle red=new Circle(651,40,25.0f,Color.RED); 

    Circle green=new Circle(651,96,23.0f,Color.GREEN); 
    Circle blue=new Circle(651,152,21.0f,Color.BLUEVIOLET); 
    Circle orange=new Circle(651,208,19.0f,Color.ORANGE); 
    Pane root3=new Pane();
    Label label=new Label(" "); 
    Button btn5=new Button("Dice");
    int x,count1=0,count2=0,count3=0,count4=0,flag1=0,flag2=0,flag3=0,flag4=0;
    VBox h=new VBox();
    VBox h2=new VBox();
    VBox h3=new VBox();
    VBox h4=new VBox();
    Button b=new Button("OK");
    Label l=new Label("Your Turn ");
    Button b2=new Button("OK");
    Label l2=new Label(" ");
    Label l3=new Label(" ");
    Label l4=new Label(" ");
    Button b3=new Button("OK");
    Button b4=new Button("OK");
    Button btn6=new Button("Exit");
    int i=1;
    SnakeBox[] a=new SnakeBox[101];
    int j;
    int online=0;
    Random rand=new Random(); 
    Stage popupstage=new Stage();
    Stage pop2=new Stage();
    Stage pop3=new Stage();
    Stage pop4=new Stage();
    Stage popsave=new Stage();
    VBox hs=new VBox();
    Button bs1=new Button("YES");
    Button bs2=new Button("NO");
    Label ls=new Label("Do you want to save the game and exit??");
    LudoBox[] ludo=new LudoBox[73];
    int save=0;
    DataOutputStream outToServer;
    BufferedReader inFromServer;
    public void start(Stage primaryStage) {
        stage=primaryStage;
        Button btn1 = new Button("NEW GAME");
        Button btn2=new Button("CONTINUE");
        Button btn3=new Button("EXIT");
        btn1.setPrefSize(200, 50);
        btn2.setPrefSize(200, 50);
        btn3.setPrefSize(200, 50);
        btn3.setOnAction(e->{
            exit(0);
        });
        btn1.setOnAction((ActionEvent event) -> {
            stage.setScene(s2);
            stage.show();
        });        
        
        VBox root;
        root = new VBox();
        root.getChildren().addAll(btn1,btn2,btn3);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);      
        s1 = new Scene(root, 700, 700);
        s1.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        Button bt4=new Button("SNAKE MODE");
        Button bt5=new Button("LUDO MODE");
        bt4.setPrefSize(200, 50);
        bt5.setPrefSize(200, 50);
        bt4.setOnAction(e-> {
            stage.setScene(s6);
            stage.show();
            
        });
        
        bt5.setOnAction(e->{
            stage.setScene(s4);
            stage.show();
            ludo();
        });
        btn2.setOnAction(e->{
            stage.setScene(s3);
            stage.show();
            save=1;
            try {
                snake();
            } catch (IOException ex) {
                Logger.getLogger(LudoReloded.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        VBox root2=new VBox();
        root2.getChildren().addAll(bt4,bt5);
        root2.setAlignment(Pos.CENTER);
        root2.setSpacing(50);
        s2=new Scene(root2,700,700);
        s2.getStylesheets().add(getClass().getResource("scene2.css").toExternalForm());
        Button b1=new Button("Play Online");
        Button b2=new Button("Play Vs Pc");
        b1.setPrefSize(200, 50);
        b2.setPrefSize(200, 50);
        b1.setOnAction(e->{
            stage.setScene(s3);
            stage.show();
            online=1;
            try {
                snake();
            } catch (IOException ex) {
                Logger.getLogger(LudoReloded.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        b2.setOnAction(e->{
            stage.setScene(s3);
            stage.show();
            try {
                snake();
            } catch (IOException ex) {
                Logger.getLogger(LudoReloded.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        VBox root6=new VBox();
        root6.getChildren().addAll(b1,b2);
        root6.setAlignment(Pos.CENTER);
        root6.setSpacing(50);
        s6=new Scene(root6,700,700);
        s6.getStylesheets().add(getClass().getResource("scene6.css").toExternalForm());
        btn5.setMinHeight(50);
        btn5.setPrefWidth(70);
        btn5.setLayoutX(616);
        btn5.setLayoutY(511);
        label.setPrefSize(82, 43);
        label.setLayoutX(610);
        label.setLayoutY(329);
        red.setStroke(Color.BLACK);
        red.setStrokeWidth(4);
        green.setStroke(Color.BLACK);
        green.setStrokeWidth(4);
        blue.setStroke(Color.BLACK);
        blue.setStrokeWidth(4);
        orange.setStroke(Color.BLACK);
        orange.setStrokeWidth(4);
        
        btn6.setMinHeight(50);
        btn6.setPrefWidth(60);
        btn6.setLayoutX(626);
        btn6.setLayoutY(605);
        root3.getChildren().addAll(red,green,blue,orange,btn5,label,btn6);
        s3=new Scene(root3,700,700);
        s3.getStylesheets().add(getClass().getResource("scene3.css").toExternalForm());        
        Pane root4=new Pane();
        s4=new Scene(root4,700,700);
        s4.getStylesheets().add(getClass().getResource("scene4.css").toExternalForm());
        stage.setScene(s1);
        stage.show();
    }
    void snake() throws IOException{
        //snake game ode
        
        for(j=1;j<=4;j++){
            snkp[j]=new player();
        }
        a[1]=new SnakeBox();
        a[1].c_x=43;
        a[1].c_y=641;
        double width=58;
        double height=64;
        
        for(j=2;j<=10;j++){
            a[j]=new SnakeBox();
            a[j].c_x=a[j-1].c_x+width;
            a[j].c_y=a[1].c_y;
        }
        for(j=11;j<=20;j++){
            a[j]=new SnakeBox();
            if(j==11){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x-width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=21;j<=30;j++){
            a[j]=new SnakeBox();
            if(j==21){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x+width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=31;j<=40;j++){
            a[j]=new SnakeBox();
            if(j==31){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x-width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=41;j<=50;j++){
            a[j]=new SnakeBox();
            if(j==41){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x+width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=51;j<=60;j++){
            a[j]=new SnakeBox();
            if(j==51){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x-width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=61;j<=70;j++){
            a[j]=new SnakeBox();
            if(j==61){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x+width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=71;j<=80;j++){
            a[j]=new SnakeBox();
            if(j==71){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x-width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        for(j=81;j<=90;j++){
            a[j]=new SnakeBox();
            if(j==81){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x+width;
            a[j].c_y=a[j-1].c_y;
            }
        }
        
        for(j=91;j<=100;j++){
            a[j]=new SnakeBox();
            if(j==91){
                a[j].c_x=a[j-1].c_x;
                a[j].c_y=a[j-1].c_y-height;
            }
            else{
            a[j].c_x=a[j-1].c_x-width;
            a[j].c_y=a[j-1].c_y;
            }
        }

        
        h.getChildren().addAll(b,l);
        h.setAlignment(Pos.CENTER);
        h.setSpacing(50);
        Scene s=new Scene(h,300,300);
        h2.getChildren().addAll(b2,l2);
        h2.setAlignment(Pos.CENTER);
        h2.setSpacing(50);
        Scene sc=new Scene(h2,300,300);
        pop2.setScene(sc);
        pop2.initModality(Modality.APPLICATION_MODAL);
        popupstage.setScene(s);
        popupstage.initModality(Modality.APPLICATION_MODAL);
        
        h3.getChildren().addAll(b3,l3);
        h3.setAlignment(Pos.CENTER);
        h3.setSpacing(50);
        Scene sc3=new Scene(h3,300,300);
        pop3.setScene(sc3);
        pop3.initModality(Modality.APPLICATION_MODAL);
        h4.getChildren().addAll(b4,l4);
        h4.setAlignment(Pos.CENTER);
        h4.setSpacing(50);
        Scene sc4=new Scene(h4,300,300);
        pop4.setScene(sc4);
        pop4.initModality(Modality.APPLICATION_MODAL);
        if(online==1){
            snake_online();
        }
        else{
        hs.getChildren().addAll(bs1,bs2,ls);
        hs.setAlignment(Pos.CENTER);
        hs.setSpacing(20);
        Scene ss=new Scene(hs,300,300);
        popsave.setScene(ss);
        popsave.initModality(Modality.APPLICATION_MODAL);
        if(save==0){
            popupstage.show();
        }
        else{
            FileReader fr = null;
            try { 
                BufferedReader br;
                fr = new FileReader("E:\\Java Prog\\LudoReloded\\src\\ludoreloded\\save.txt");
                br = new BufferedReader(fr);
                String pl = br.readLine();
                String pos1 = br.readLine();
                String pos2 = br.readLine();
                String pos3 = br.readLine();
                String pos4 = br.readLine();
                String c1 = br.readLine();
                String c2 = br.readLine();
                String c3 = br.readLine();
                String c4 = br.readLine();
                i=Integer.parseInt(pl);
                snkp[1].currpos=Integer.parseInt(pos1);
                snkp[2].currpos=Integer.parseInt(pos2);
                snkp[3].currpos=Integer.parseInt(pos3);
                snkp[4].currpos=Integer.parseInt(pos4);
                count1=Integer.parseInt(c1);
                count2=Integer.parseInt(c2);
                count3=Integer.parseInt(c3);
                count4=Integer.parseInt(c4);
                fr.close();
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LudoReloded.class.getName()).log(Level.SEVERE, null, ex);
            } 
            for(int k=1;k<=4;k++){
                if(snkp[k].currpos==0 ){
                  snkp[k].start=false;
                }
                else{
                    snkp[k].start=true;
                    if(k==1){
                        red.setCenterX(a[snkp[k].currpos].c_x);
                        red.setCenterY(a[snkp[k].currpos].c_y);
                    }
                    else if(k==2){
                        green.setCenterX(a[snkp[k].currpos].c_x);
                        green.setCenterY(a[snkp[k].currpos].c_y);
                    }
                    else if(k==3){
                        blue.setCenterX(a[snkp[k].currpos].c_x);
                        blue.setCenterY(a[snkp[k].currpos].c_y);
                    }
                    else if(k==4){
                        orange.setCenterX(a[snkp[k].currpos].c_x);
                        orange.setCenterY(a[snkp[k].currpos].c_y);
                    }
                }
                
            }
            if(count1!=0){
                snkp[1].start=true;
                l.setText("wops,its 1... make another turn");
                popupstage.show();
            }
            else if(count2!=0){
                snkp[2].start=true;
                if(i==2){
                   l2.setText("Second Player Turn");
                   pop2.show();
               }
               else{
                   l2.setText("Second Player is making move");
                   pop2.show();
               }
           }
            else if(count3!=0){
                snkp[3].start=true;
                if(i==3){
                   l3.setText("Third Player Turn");
                   pop3.show();
               }
               else{
                   l3.setText("Third Player is making move");
                   pop3.show();
               }
            }
            else if(count4!=0){
                snkp[4].start=true;
                if(i==4){
                   l4.setText("Fourth Player Turn");
                   pop4.show();
               }
               else{
                   l4.setText("Fourth Player is making move");
                   pop4.show();
               }
            }
            else if(i==1){
                l.setText("Your Turn");
                popupstage.show();
            }
            else if(i==2){
                l2.setText("Second Player Turn");
                pop2.show();
            }
            else if(i==3){
                l3.setText("Third Palyer Turn");
                pop3.show();
            }
            else{
                l4.setText("Fourth Palyer Turn");
                pop4.show();
            }
        }
        b2.setOnAction(e->{
           pop2.close();
           if(i==3){
               do_move(i-1);
               l3.setText("Third Player turn");
               pop3.show();
           }
           else{
           x=rand.nextInt(6)+1;   
           label.setText(Integer.toString(x));                   
           if(x==1 && snkp[i].start==false){
                snkp[i].start=true;
           }    
           if(x==1 && snkp[i].start==true){
               count2+=x;
               l2.setText("wops its 1....player 2 is making another turn");
               pop2.show();
           }
           else if(x!=1 && snkp[i].start==true){
               count2+=x;           
               i++;
               l2.setText("Second player is making move");
               pop2.show();
               
           }
           else if(snkp[i].start==false){
               i++;
               l3.setText("Third Player Turn");
               pop3.show();
           }     
           }
        });
        b3.setOnAction(e->{
           pop3.close();
           if(i==4){
               do_move(i-1);
               l4.setText("Fourth Player turn");
               pop4.show();
           }
           else{
               x=rand.nextInt(6)+1;   
               label.setText(Integer.toString(x)); 
           
           if(x==1 && snkp[i].start==false){
                snkp[i].start=true;
           }    
           if(x==1 && snkp[i].start==true){
               count3+=x;
               l3.setText("wops its 1....player 3 is making another turn");
               pop3.show();
           }
           else if(x!=1 && snkp[i].start==true){
               count3+=x;           
               i++;
               l3.setText("Third player is making move");
               pop3.show();
               
           }
           else if(snkp[i].start==false){
               i++;
               l4.setText("Fourth Player Turn");
               pop4.show();
           }
           }
        });
        b4.setOnAction(e->{
            pop4.close();
            if(i==1){
               do_move(4);
               l.setText("Your Turn");
               popupstage.show();
           }
           else{
               x=rand.nextInt(6)+1;   
               label.setText(Integer.toString(x)); 
           if(x==1 && snkp[i].start==false){
                snkp[i].start=true;
           }    
           if(x==1 && snkp[i].start==true){
               count4+=x;
               l4.setText("wops its 1....player 4 is making another turn");
               pop4.show();
           }
           else if(x!=1 && snkp[i].start==true){
               count4+=x;           
               i=1;
               l4.setText("Fourth player is making move");
               pop4.show();
               
           }
           else if(snkp[i].start==false){
               i=1;
               l.setText("Your Turn");
               popupstage.show();
           }
           }
        });
        b.setOnAction(e->{
            popupstage.close();
        });
        btn5.setOnAction(e->{           
           if(i==1){          
           x=rand.nextInt(6)+1;   
           label.setText(Integer.toString(x));
           if(x==1 && snkp[i].start==false){
                snkp[i].start=true;
           }    
           if(x==1 && snkp[i].start==true){
               count1+=x;
               l.setText("wops its 1... make another turn");
               popupstage.show();
           }
           else if(x!=1 && snkp[i].start==true){
               count1+=x;
               do_move(i);
               i++;
               l2.setText("Second Player Turn");
               pop2.show();
               
           }
           else if(snkp[i].start==false){
               i++;
               l2.setText("Second Player Turn");
               pop2.show();
           }     
           }
           });
        btn6.setOnAction(e->{
            popsave.show();
        });
       bs1.setOnAction(e->{
            popsave.close();
           try {
                FileWriter fw;
                BufferedWriter bw;
                fw = new FileWriter("E:\\Java Prog\\LudoReloded\\src\\ludoreloded\\save.txt");
                bw = new BufferedWriter(fw);
                bw.write(i + "\n");
                bw.write(snkp[1].currpos+ "\n");
                bw.write(snkp[2].currpos+ "\n");
                bw.write(snkp[3].currpos+ "\n");
                bw.write(snkp[4].currpos+ "\n");
                bw.write(count1+ "\n");
                bw.write(count2+ "\n");
                bw.write(count3+ "\n");
                bw.write(count4+ "\n");
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(LudoReloded.class.getName()).log(Level.SEVERE, null, ex);
            }
            exit(0);
       });
        }   //save game button action set
    }
    void snake_online() throws IOException {
        l.setText("First Player Move");
        popupstage.show();
        System.out.println("hi");
        ConectionUtillities connection=new ConectionUtillities("localhost",6789);
        connection.write("tomal");
        b.setOnAction(e->{
            Object o=connection.read();
        System.out.println(o.toString());  
        });     
        while(true);        
    }
    
    void do_move(int m){
    
     if(m==1){
      snkp[m].currpos+=count1;
      red.setCenterX(a[snkp[m].currpos].c_x);
      red.setCenterY(a[snkp[m].currpos].c_y);
      check_(m,snkp[m].currpos);
      count1=0;  
      }
      if(m==2){
          snkp[m].currpos+=count2;
          green.setCenterX(a[snkp[m].currpos].c_x);
          green.setCenterY(a[snkp[m].currpos].c_y);
          check_(m,snkp[m].currpos);
          count2=0; 
      }
      if(m==3){
          snkp[m].currpos+=count3;
          blue.setCenterX(a[snkp[m].currpos].c_x);
          blue.setCenterY(a[snkp[m].currpos].c_y);
          check_(m,snkp[m].currpos);
          count3=0; 
      }
      if(m==4){
          snkp[m].currpos+=count4;
          orange.setCenterX(a[snkp[m].currpos].c_x);
          orange.setCenterY(a[snkp[m].currpos].c_y);
          check_(m,snkp[m].currpos);
          count4=0; 
      }
    }    
    void check_(int p,int pos){

        if(pos==6){
            snkp[p].currpos=16;
            if(p==1){
                red.setCenterX(a[snkp[p].currpos].c_x);
                red.setCenterY(a[snkp[p].currpos].c_y);
            }
            if(p==2){
                green.setCenterX(a[snkp[p].currpos].c_x);
                green.setCenterY(a[snkp[p].currpos].c_y);
            }
             if(p==3){
                blue.setCenterX(a[snkp[p].currpos].c_x);
                blue.setCenterY(a[snkp[p].currpos].c_y);
            }
              if(p==4){
                orange.setCenterX(a[snkp[p].currpos].c_x);
                orange.setCenterY(a[snkp[p].currpos].c_y);
            }
        }
        if(pos==9){
            snkp[p].currpos=31;
            if(p==1){
                red.setCenterX(a[snkp[p].currpos].c_x);
                red.setCenterY(a[snkp[p].currpos].c_y);
            }
            if(p==2){
                green.setCenterX(a[snkp[p].currpos].c_x);
                green.setCenterY(a[snkp[p].currpos].c_y);
            }
             if(p==3){
                blue.setCenterX(a[snkp[p].currpos].c_x);
                blue.setCenterY(a[snkp[p].currpos].c_y);
            }
              if(p==4){
                orange.setCenterX(a[snkp[p].currpos].c_x);
                orange.setCenterY(a[snkp[p].currpos].c_y);
            }
        }
        
    }
    void ludo(){
        ludo[1]=new LudoBox();
        ludo[1].c_x=524;
        ludo[1].c_y=390;
        double w=36;
        double hi=43;
        for(i=2;i<=6;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x-w;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        for(i=7;i<=12;i++){
            ludo[i]=new LudoBox();
            if(i==7){
                ludo[i].c_x=ludo[i-1].c_x-w;
                ludo[i].c_y=ludo[i-1].c_y+hi;
            }
            else{
            ludo[i].c_x=ludo[i-1].c_x;
            ludo[i].c_y=ludo[i-1].c_y+hi;
            }
        }
        for(i=13;i<=14;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x-w;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        for(i=15;i<=19;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x;
            ludo[i].c_y=ludo[i-1].c_y-hi;
        }
        for(i=20;i<=25;i++){
            ludo[i]=new LudoBox();
            if(i==20){
            ludo[i].c_x=ludo[i-1].c_x-w;
            ludo[i].c_y=ludo[i-1].c_y-hi;       
            }
            else{
            ludo[i].c_x=ludo[i-1].c_x-w;
            ludo[i].c_y=ludo[i-1].c_y;
            }
        }
        for(i=26;i<=27;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x;
            ludo[i].c_y=ludo[i-1].c_y-hi;
        }
        for(i=28;i<=32;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x+w;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        for(i=33;i<=38;i++){
            ludo[i]=new LudoBox();
            if(i==33){
                ludo[i].c_x=ludo[i-1].c_x+w;
                ludo[i].c_y=ludo[i-1].c_y-hi;
            }
            else{
                ludo[i].c_x=ludo[i-1].c_x;
                ludo[i].c_y=ludo[i-1].c_y-hi;
            }
        }
        for(i=39;i<=40;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x+w;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        for(i=41;i<=45;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x;
            ludo[i].c_y=ludo[i-1].c_y+hi;
        }
        for(i=46;i<=51;i++){
            ludo[i]=new LudoBox();
            if(i==46){
                ludo[i].c_x=ludo[i-1].c_x+w;
                ludo[i].c_y=ludo[i-1].c_y+hi;
            }
            else{
            ludo[i].c_x=ludo[i-1].c_x+w;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        }    
        ludo[52]=new LudoBox();
        ludo[52].c_x=ludo[51].c_x;
        ludo[52].c_y=ludo[51].c_y+hi;
        for(i=53;i<=57;i++){
            ludo[i]=new LudoBox();
            ludo[i].c_x=ludo[i-1].c_x-w;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        for(i=58;i<=62;i++){
            ludo[i]=new LudoBox(); 
            if(i==58){
                 ludo[i].c_x=ludo[13].c_x;
                 ludo[i].c_y=ludo[13].c_y-hi;
             }
            else{
                ludo[i].c_x=ludo[i-1].c_x;
                 ludo[i].c_y=ludo[i-1].c_y-hi;
            }
        }
        for(i=63;i<=67;i++){
            ludo[i]=new LudoBox(); 
            if(i==63){
                 ludo[i].c_x=ludo[20].c_x+w;
                 ludo[i].c_y=ludo[20].c_y;
             }
            else{
                ludo[i].c_x=ludo[i-1].c_x+w;
                 ludo[i].c_y=ludo[i-1].c_y;
            }
        }
        for(i=68;i<=72;i++){
            ludo[i]=new LudoBox(); 
            if(i==68){
                 ludo[i].c_x=ludo[39].c_x;
                 ludo[i].c_y=ludo[39].c_y+hi;
             }
            else{
                ludo[i].c_x=ludo[i-1].c_x;
                 ludo[i].c_y=ludo[i-1].c_y+hi;
            }
        }
    }    
    public static void main(String[] args) {
        launch(args);
    }

}

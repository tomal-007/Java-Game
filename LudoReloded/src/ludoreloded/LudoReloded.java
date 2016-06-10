
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
public class LudoReloded extends Application {
    
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
    int x,count1=0,count2=0,count3=0,count4=0,flag1=0,flag2=0,flag3=0,flag4=0,y,toss;
    VBox h=new VBox();
    VBox h2=new VBox();
    VBox h3=new VBox();
    VBox h4=new VBox();
    VBox h5=new VBox();
    Button hb1=new Button("1");
    Button hb2=new Button("2");
    Button hb3=new Button("3");
    Button hb4=new Button("4");
    Button hb5=new Button("Cancel");
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
    int t=1;
    SnakeBox[] a=new SnakeBox[101];
    int j;
    int online=0;
    Random rand=new Random(); 
    Stage popupstage=new Stage();
    Stage pop2=new Stage();
    Stage pop3=new Stage();
    Stage pop4=new Stage();
    Stage popsave=new Stage();
    Stage popop=new Stage();
    VBox hs=new VBox();
    Button bs1=new Button("YES");
    Button bs2=new Button("NO");
    Label ls=new Label("Do you want to save the game and exit??");
    LudoBox[] ludo=new LudoBox[90];
    Gamer g[]=new Gamer[5];
    int save=0;
    
     Circle red1=new Circle(88,583,15.0f,Color.RED);
     Circle red2=new Circle(87,505,12.0f,Color.RED); 
     Circle red3=new Circle(155,504,10.0f,Color.RED); 
     Circle red4=new Circle(154,582,9.0f,Color.RED); 
     Circle green1=new Circle(85,187,15.0f,Color.GREEN); 
     Circle green2=new Circle(87,114,12.0f,Color.GREEN);
     Circle green3=new Circle(155,113,9.0f,Color.GREEN);
     Circle green4=new Circle(155,190,8.0f,Color.GREEN); 
     Circle yellow1=new Circle(404,112,15.0f,Color.YELLOW); 
     Circle yellow2=new Circle(403,191,12.0f,Color.YELLOW);
     Circle yellow3=new Circle(469,190,9.0f,Color.YELLOW);
     Circle yellow4=new Circle(469,113,8.0f,Color.YELLOW); 
     Circle blue1=new Circle(404,504,15.0f,Color.BLUE); 
     Circle blue2=new Circle(402,583,12.0f,Color.BLUE);
     Circle blue3=new Circle(469,582,9.0f,Color.BLUE);
     Circle blue4=new Circle(470,504,8.0f,Color.BLUE); 
     int mm=1;
     Button btn7=new Button("DICE");
     Label lebel=new Label(" ");
     Button bbm=new Button("Back");
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
        red.setStrokeWidth(1);
        green.setStroke(Color.BLACK);
        green.setStrokeWidth(1);
        blue.setStroke(Color.BLACK);
        blue.setStrokeWidth(1);
        orange.setStroke(Color.BLACK);
        orange.setStrokeWidth(1);
        
        btn6.setMinHeight(50);
        btn6.setPrefWidth(60);
        btn6.setLayoutX(626);
        btn6.setLayoutY(605);
        root3.getChildren().addAll(red,green,blue,orange,btn5,label,btn6);
        s3=new Scene(root3,700,700);
        s3.getStylesheets().add(getClass().getResource("scene3.css").toExternalForm());        
        btn7.setMinHeight(50);
        btn7.setPrefWidth(70);
        btn7.setLayoutX(584);
        btn7.setLayoutY(526);
      
        lebel.setPrefSize(82, 43);
        lebel.setLayoutX(579);
        lebel.setLayoutY(366);
        Pane root4=new Pane();
        red1.setStroke(Color.BLACK);
        red2.setStroke(Color.BLACK);
        red3.setStroke(Color.BLACK);
        red4.setStroke(Color.BLACK);
        green1.setStroke(Color.BLACK);
        green2.setStroke(Color.BLACK);
        green3.setStroke(Color.BLACK);
        green4.setStroke(Color.BLACK);
        yellow1.setStroke(Color.BLACK);
        yellow2.setStroke(Color.BLACK);
        yellow3.setStroke(Color.BLACK);
        yellow4.setStroke(Color.BLACK);
        blue1.setStroke(Color.BLACK);
        blue2.setStroke(Color.BLACK);
        blue3.setStroke(Color.BLACK);
        blue4.setStroke(Color.BLACK);
        root4.getChildren().addAll(btn7,lebel,red1,red2,red3,red4,blue1,blue2,blue3,blue4,green1,green2,green3,green4,yellow1,yellow2,yellow3,yellow4);
        s4=new Scene(root4,700,700);
        s4.getStylesheets().add(getClass().getResource("scene4.css").toExternalForm());
        stage.setScene(s1);
        stage.show();
        bbm.setOnAction(e->{
           stage.setScene(s1);
           stage.show();
        });
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
        popupstage.show();
        
        ConectionUtillities connection=new ConectionUtillities("localhost",6789);
        connection.write("toushik");
        while(true);
    }
    
    void do_move(int m){
    
     if(m==1){
      if((snkp[m].currpos+count1)<=100){   
      snkp[m].currpos+=count1;
      red.setCenterX(a[snkp[m].currpos].c_x);
      red.setCenterY(a[snkp[m].currpos].c_y);
      check_(m,snkp[m].currpos);
      count1=0;  
      }
     }
      if(m==2){
          if((snkp[m].currpos+count2)<=100){
          snkp[m].currpos+=count2;
          green.setCenterX(a[snkp[m].currpos].c_x);
          green.setCenterY(a[snkp[m].currpos].c_y);
          check_(m,snkp[m].currpos);
          count2=0; 
          }
      }
      if(m==3){
          if((snkp[m].currpos+count3)<=100){
          snkp[m].currpos+=count3;
          blue.setCenterX(a[snkp[m].currpos].c_x);
          blue.setCenterY(a[snkp[m].currpos].c_y);
          check_(m,snkp[m].currpos);
          count3=0; 
          }
      }
      if(m==4){
          if((snkp[m].currpos+count4)<=100){
          snkp[m].currpos+=count4;
          orange.setCenterX(a[snkp[m].currpos].c_x);
          orange.setCenterY(a[snkp[m].currpos].c_y);
          check_(m,snkp[m].currpos);
          count4=0; 
          }
          
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
        if(pos==19){
            snkp[p].currpos=38;
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
        if(pos==28){
            snkp[p].currpos=84;
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
        if(pos==21){
            snkp[p].currpos=79;
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
        if(pos==52){
            snkp[p].currpos=67;
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
        if(pos==72){
            snkp[p].currpos=93;
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
        if(pos==80){
            snkp[p].currpos=100;
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
        if(pos==18){
            snkp[p].currpos=5;
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
        if(pos==49){
            snkp[p].currpos=33;
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
        if(pos==43){
            snkp[p].currpos=23;
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
        if(pos==65){
            snkp[p].currpos=44;
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
        if(pos==56){
            snkp[p].currpos=26;
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
        if(pos==99){
            snkp[p].currpos=35;
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
        if(pos==92){
            snkp[p].currpos=71;
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
        if(pos==88){
            snkp[p].currpos=53;
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
    @SuppressWarnings("empty-statement")
    void ludo(){
        
        int q,k;
        for( k=1;k<=4;k++){
            g[k]=new Gamer();
            if(k==1) g[k].rip=13;
            if(k==2) g[k].rip=26;
            if(k==3) g[k].rip=52;
            if(k==4) g[k].rip=39;
        }
        for(k=1;k<=4;k++){
            g[1].a[k].curr=15;
        }
        for(k=1;k<=4;k++){
            g[2].a[k].curr=28;
        }
        for(k=1;k<=4;k++){
            g[3].a[k].curr=2;
        }
        for(k=1;k<=4;k++){
            g[4].a[k].curr=41;
        }
        
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
            ludo[i].c_x=ludo[i-1].c_x-w+3;
            ludo[i].c_y=ludo[i-1].c_y-hi;       
            }
            else{
            ludo[i].c_x=ludo[i-1].c_x-w+3;
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
            ludo[i].c_x=ludo[i-1].c_x+w-1;
            ludo[i].c_y=ludo[i-1].c_y;
        }
        for(i=33;i<=38;i++){
            ludo[i]=new LudoBox();
            if(i==33){
                ludo[i].c_x=ludo[i-1].c_x+w-1;
                ludo[i].c_y=ludo[i-1].c_y-hi;
            }
            else{
                ludo[i].c_x=ludo[i-1].c_x-1;
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
                 ludo[i].c_x=ludo[26].c_x+w;
                 ludo[i].c_y=ludo[26].c_y;
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
        for(i=73;i<=88;i++){
            ludo[i]=new LudoBox();
        }
        ludo[73].c_x=88;
        ludo[73].c_y=583;
        ludo[74].c_x=87;
        ludo[74].c_y=505;
        ludo[75].c_x=155;
        ludo[75].c_y=504;
        ludo[76].c_x=154;
        ludo[76].c_y=582;
        ludo[77].c_x=85;
        ludo[77].c_y=187;
        ludo[78].c_x=87;
        ludo[78].c_y=114;
        ludo[79].c_x=155;
        ludo[79].c_y=113;
        ludo[80].c_x=155;
        ludo[80].c_y=190;
        ludo[81].c_x=404;
        ludo[81].c_y=504;
        ludo[82].c_x=402;
        ludo[82].c_y=583;
        ludo[83].c_x=409;
        ludo[83].c_y=582;
        ludo[84].c_x=470;
        ludo[84].c_y=504;
        ludo[85].c_x=404;
        ludo[85].c_y=112;
        ludo[86].c_x=403;
        ludo[86].c_y=191;
        ludo[87].c_x=469;
        ludo[87].c_y=190;
        ludo[88].c_x=469;
        ludo[88].c_y=113;
        g[1].a[1].initial=73;
        g[1].a[2].initial=74;
        g[1].a[3].initial=75;
        g[1].a[4].initial=76;
        g[2].a[1].initial=77;
        g[2].a[2].initial=78;
        g[2].a[3].initial=79;
        g[2].a[4].initial=80;
        g[3].a[1].initial=81;
        g[3].a[2].initial=82;
        g[3].a[3].initial=83;
        g[3].a[4].initial=84;
        g[4].a[1].initial=85;
        g[4].a[2].initial=86;
        g[4].a[3].initial=87;
        g[4].a[4].initial=88;
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
        popupstage.show();
        h5.getChildren().addAll(hb1,hb2,hb3,hb4,hb5);
        h5.setAlignment(Pos.CENTER);
        h5.setSpacing(20);
        Scene sc5=new Scene(h5,300,300);
        popop.setScene(sc5);
        b.setOnAction(e->{
            popupstage.close();
            
        });
        btn7.setOnAction(e->{
            x=rand.nextInt(6)+1;   
           lebel.setText(Integer.toString(x));
           if(t==1){
               if(x==6){
                   count1+=x;
                   popop.show();
               }
               if(x!=6){
                   count1+=x;
                   t++;
                   popop.show();
                  
               }
               
               
               
           }
           
        });
        b2.setOnAction(e->{
            pop2.close();
            x=rand.nextInt(6)+1;
            y=rand.nextInt(4)+1;
           lebel.setText(Integer.toString(x));
           if(t==2){
               if(x==6){
                   count2+=x;
                   //popop.show();
                   l2.setText("Its 6!!Second is making another turn");
                   pop2.show();
                   
               }
               if(x!=6){
                   count2+=x;
                   g[2].a[y].curr+=count2;
                   g[2].a[y].var+=count2;
        
                   if(g[2].a[y].curr>52){
                      g[2].a[y].curr=g[2].a[y].curr-52;
                      if(g[2].a[y].var>50){
                         g[2].a[y].curr=62+(g[4].a[y].curr-26);
                      }
             
                    }
                   check(2,y);
                   if(g[2].a[y].curr<75){
                      if(y==1){
                          green1.setCenterX(ludo[g[2].a[y].curr].c_x);
                          green1.setCenterY(ludo[g[2].a[y].curr].c_y);
                      }
                      if(y==2){
                          green2.setCenterX(ludo[g[2].a[y].curr].c_x);
                          green2.setCenterY(ludo[g[2].a[y].curr].c_y);
                      }
                      if(y==3){
                          green3.setCenterX(ludo[g[2].a[y].curr].c_x);
                          green3.setCenterY(ludo[g[2].a[y].curr].c_y);
                      }
                      if(y==4){
                          green4.setCenterX(ludo[g[2].a[y].curr].c_x);
                          green4.setCenterY(ludo[g[2].a[y].curr].c_y);
                      }
                    }
                    count2=0;
                   l3.setText("Third Player Turn");
                   pop3.show();
                   t++;
                  
               }
               
               
           }
            
        });
        b3.setOnAction(e->{
            pop3.close();
            x=rand.nextInt(6)+1;
            y=rand.nextInt(4)+1;
           lebel.setText(Integer.toString(x));
           if(t==3){
               if(x==6){
                   count3+=x;
                   //popop.show();
                   l3.setText("Its 6!! Third Palyer is making another turn");
                   pop3.show();
               }
               if(x!=6){
                   count3+=x;
                   g[3].a[y].curr+=count3;
                   g[3].a[y].var+=count3;
        
                   
                      if(g[3].a[y].var>50){
                         g[3].a[y].curr=52+(g[3].a[y].curr-52);
                      }
             
                    
                   check(3,y);
                   if(g[3].a[y].curr<75){
                      if(y==1){
                          blue1.setCenterX(ludo[g[3].a[y].curr].c_x);
                          blue1.setCenterY(ludo[g[3].a[y].curr].c_y);
                      }
                      if(y==2){
                          blue2.setCenterX(ludo[g[3].a[y].curr].c_x);
                          blue2.setCenterY(ludo[g[3].a[y].curr].c_y);
                      }
                      if(y==3){
                          blue3.setCenterX(ludo[g[3].a[y].curr].c_x);
                          blue3.setCenterY(ludo[g[3].a[y].curr].c_y);
                      }
                      if(y==4){
                          blue4.setCenterX(ludo[g[3].a[y].curr].c_x);
                          blue4.setCenterY(ludo[g[3].a[y].curr].c_y);
                      }
                    }
                    count3=0;
                   l4.setText("Fourth Player Turn");
                   pop4.show();
                   t++;
                  
               }
               
               
           }
            
        });
        b4.setOnAction(e->{
            pop4.close();
            x=rand.nextInt(6)+1;
            y=rand.nextInt(4)+1;
           lebel.setText(Integer.toString(x));
           if(t==4){
               if(x==6){
                   count4+=x;
                   //popop.show();
                   l4.setText("Its 6!! fourth Player is making another turn");
                   pop4.show();
               }
               if(x!=6){
                   count4+=x;
                   g[4].a[y].curr+=count4;
                   g[4].a[y].var+=count4;
        
                   if(g[4].a[y].curr>52){
                      g[4].a[y].curr=g[4].a[y].curr-52;
                      if(g[4].a[y].var>50){
                         g[4].a[y].curr=67+(g[4].a[y].curr-39);
                      }
             
                    }
                   check(4,y);
                   if(g[4].a[y].curr<75){
                      if(y==1){
                          yellow1.setCenterX(ludo[g[4].a[y].curr].c_x);
                          yellow1.setCenterY(ludo[g[4].a[y].curr].c_y);
                      }
                      if(y==2){
                          yellow2.setCenterX(ludo[g[4].a[y].curr].c_x);
                          yellow2.setCenterY(ludo[g[4].a[y].curr].c_y);
                      }
                      if(y==3){
                          yellow3.setCenterX(ludo[g[4].a[y].curr].c_x);
                          yellow3.setCenterY(ludo[g[4].a[y].curr].c_y);
                      }
                      if(y==4){
                          yellow4.setCenterX(ludo[g[4].a[y].curr].c_x);
                          yellow4.setCenterY(ludo[g[4].a[y].curr].c_y);
                      }
                    }
                    count4=0;
                    t=1;
                   l.setText("Your turn");
                   popupstage.show();
                  
                   
                  
               }
               
               
           }
            
        });
        hb1.setOnAction(e->{
            move1();
            popop.close();
            if(t!=1){
                l2.setText("Second Player Turn");
                pop2.show();
            }
            
            
        });
         hb2.setOnAction(e->{
            move2();
            popop.close();
            if(t!=1)
            {   l2.setText("Second Player Turn");
                pop2.show();
            }
            
        });
          hb3.setOnAction(e->{
            move3();
            popop.close();
            if(t!=1){
                l2.setText("Second Player Turn");
                pop2.show();
                
            }
            
        });
         hb4.setOnAction(e->{
            move4();
            popop.close();
            if(t!=1){
                l2.setText("Second Player Turn");
                pop2.show();
            }
            
        });
          hb5.setOnAction(e->{
            cancel();
            
            
        });
        
    }  
    void move1(){
        //if(g[1].a[1].flag==1) return; 
        g[1].a[1].curr+=count1;
         g[1].a[1].var+=count1;
         
         if(g[1].a[1].curr>52){
             if(g[1].a[1].var>50){
                 g[1].a[1].curr=g[1].a[1].curr-52;
             if(g[1].a[1].var>50){
                g[1].a[1].curr=57+(g[1].a[1].curr-13);
             }
                     }
                 }
             
             //g[1].a[1].curr=g[1].a[1].curr-52;
             /*if(g[1].a[1].var>50){
                g[1].a[1].curr=57+(g[1].a[1].curr-13);
             }*/
             
        
         check(1,1);
         /*if(g[1].a[1].curr>52){
             g[1].a[1].curr-=count1;
             g[1].a[1].curr=57+(count1-(52-count1));
         }*/
         if(g[1].a[1].curr<73){
            red1.setCenterX(ludo[g[1].a[1].curr].c_x);
            red1.setCenterY(ludo[g[1].a[1].curr].c_y);
         }
         count1=0;
         
    }
    void move2(){
         g[1].a[2].curr+=count1;
         g[1].a[2].var+=count1;
        
         if(g[1].a[2].curr>52){
             g[1].a[2].curr=g[1].a[2].curr-52;
             if(g[1].a[2].var>50){
                g[1].a[2].curr=57+(g[1].a[2].curr-13);
             }
             
         }
         check(1,2);
         if(g[1].a[2].curr<75){
            red2.setCenterX(ludo[g[1].a[2].curr].c_x);
            red2.setCenterY(ludo[g[1].a[2].curr].c_y);
         }
         count1=0;
         
    }
    void move3(){
         g[1].a[3].curr+=count1;
         g[1].a[3].var+=count1;
        
         if(g[1].a[3].curr>52){
             g[1].a[3].curr=g[1].a[3].curr-52;
             if(g[1].a[3].var>50){
                g[1].a[3].curr=57+(g[1].a[3].curr-13);
             }
             
         }
         check(1,3);
         if(g[1].a[3].curr<75){
            red3.setCenterX(ludo[g[1].a[3].curr].c_x);
            red3.setCenterY(ludo[g[1].a[3].curr].c_y);
         }
         count1=0;
         
    }
    void move4(){
         g[1].a[4].curr+=count1;
         g[1].a[4].var+=count1;
        
         if(g[1].a[4].curr>52){
             g[1].a[4].curr=g[1].a[4].curr-52;
             if(g[1].a[4].var>50){
                g[1].a[4].curr=57+(g[1].a[4].curr-13);
             }
             
         }
         check(1,4);
         if(g[1].a[4].curr<75){
            red4.setCenterX(ludo[g[1].a[4].curr].c_x);
            red4.setCenterY(ludo[g[1].a[4].curr].c_y);
         }
         count1=0;
         
    }
    void cancel(){
         popop.close();
         
    }
    void check(int k, int l){
        int temp= g[k].a[l].curr;
        int flag=1;
        for(int i=1;i<=4;i++){
            if(i==k) continue;
            for(int j=1;j<=4;j++){
                
                if((g[i].a[j].curr==temp)&&(temp!=15)&&(temp!=2)&&(temp!=28)&&(temp!=41)){
                    g[i].a[j].curr=g[i].a[j].initial;
                    if((i==1)&&(j==1)){
                        red1.setCenterX(ludo[g[1].a[1].curr].c_x);
                        red1.setCenterY(ludo[g[1].a[1].curr].c_y);
                    }
                    else if((i==1)&&(j==2)){
                        red2.setCenterX(ludo[g[1].a[2].curr].c_x);
                        red2.setCenterY(ludo[g[1].a[2].curr].c_y);
                    }
                    else if((i==1)&&(j==3)){
                        red3.setCenterX(ludo[g[1].a[3].curr].c_x);
                        red3.setCenterY(ludo[g[1].a[3].curr].c_y);
                    }
                    else if((i==1)&&(j==4)){
                        red4.setCenterX(ludo[g[1].a[4].curr].c_x);
                        red4.setCenterY(ludo[g[1].a[4].curr].c_y);
                    }
                    else if((i==2)&&(j==1)){
                        green1.setCenterX(ludo[g[2].a[1].curr].c_x);
                        green1.setCenterY(ludo[g[2].a[1].curr].c_y);
                    }
                    else if((i==2)&&(j==2)){
                        green2.setCenterX(ludo[g[2].a[2].curr].c_x);
                        green2.setCenterY(ludo[g[2].a[2].curr].c_y);
                    }
                    else if((i==2)&&(j==3)){
                        green3.setCenterX(ludo[g[2].a[3].curr].c_x);
                        green3.setCenterY(ludo[g[2].a[3].curr].c_y);
                    }
                    else if((i==2)&&(j==4)){
                        green4.setCenterX(ludo[g[2].a[4].curr].c_x);
                        green4.setCenterY(ludo[g[2].a[4].curr].c_y);
                    }
                    else if((i==3)&&(j==1)){
                        blue1.setCenterX(ludo[g[3].a[1].curr].c_x);
                        blue1.setCenterY(ludo[g[3].a[1].curr].c_y);
                    }
                    else if((i==3)&&(j==2)){
                        blue2.setCenterX(ludo[g[3].a[2].curr].c_x);
                        blue2.setCenterY(ludo[g[3].a[2].curr].c_y);
                    }
                    else if((i==3)&&(j==3)){
                        blue3.setCenterX(ludo[g[3].a[3].curr].c_x);
                        blue3.setCenterY(ludo[g[3].a[3].curr].c_y);
                    }
                    else if((i==3)&&(j==4)){
                        blue4.setCenterX(ludo[g[3].a[4].curr].c_x);
                        blue4.setCenterY(ludo[g[3].a[4].curr].c_y);
                    }
                    else if((i==4)&&(j==1)){
                        yellow1.setCenterX(ludo[g[4].a[1].curr].c_x);
                        yellow1.setCenterY(ludo[g[4].a[1].curr].c_y);
                    }
                    else if((i==4)&&(j==2)){
                        yellow2.setCenterX(ludo[g[4].a[2].curr].c_x);
                        yellow2.setCenterY(ludo[g[4].a[2].curr].c_y);
                    }
                    else if((i==4)&&(j==3)){
                        yellow3.setCenterX(ludo[g[4].a[3].curr].c_x);
                        yellow3.setCenterY(ludo[g[4].a[3].curr].c_y);
                    }
                    else if((i==4)&&(j==4)){
                        yellow4.setCenterX(ludo[g[4].a[4].curr].c_x);
                        yellow4.setCenterY(ludo[g[4].a[4].curr].c_y);
                    }
                    flag=0;
                    break;
                }
            }
            if(flag==0) break;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
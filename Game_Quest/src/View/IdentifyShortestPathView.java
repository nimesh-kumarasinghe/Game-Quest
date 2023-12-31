/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;
import game_quest.MainMenu;

import Controller.IdentifyShortestPathController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
/**
 *
 * @author Haritha Pahansith
 */
public class IdentifyShortestPathView extends javax.swing.JFrame {

    /**
     * Creates new form IdentifyShortestPathView
     */
    IdentifyShortestPathController cnt;
    public ArrayList<JLabel> city_from_to = new ArrayList<>();
    public ArrayList<JTextPane> input_city_from_to = new ArrayList<>();
    
    public IdentifyShortestPathView() {
        initComponents();
        
        System.out.println(fire_station.getLocation());
        
        city_from_to.add(fromto1);city_from_to.add(fromto2);city_from_to.add(fromto3);city_from_to.add(fromto4);city_from_to.add(fromto5);city_from_to.add(fromto6);
        city_from_to.add(fromto7);city_from_to.add(fromto8);city_from_to.add(fromto9);
        
        input_city_from_to.add(input_fromto_1);input_city_from_to.add(input_fromto2);input_city_from_to.add(input_fromto3);input_city_from_to.add(input_fromto4);
        input_city_from_to.add(input_fromto5);input_city_from_to.add(input_fromto6);input_city_from_to.add(input_fromto7);input_city_from_to.add(input_fromto8);
        input_city_from_to.add(input_fromto9);
    }
    
    // draw the lines
    private float connector_width = 6f;
    public void connect(int startx,int starty,int endx,int endy,Color cus_color,String distance){ 
        Graphics2D gg = (Graphics2D)mainboard.getGraphics();
        gg.setColor(cus_color);
        Stroke stk = new BasicStroke(connector_width);
        gg.setStroke(stk);
        gg.drawLine(startx, starty, endx, endy);
        
        int text_pos_x = (startx + endx) /2;
        int text_pos_y = (starty + endy) /2;
        
        
        
        String text = distance + " KM";
        FontMetrics fm = gg.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        
        
        int box_width = textWidth + 5;
        int box_height = textHeight + 5;
        
        gg.setColor(cus_color.darker().darker());
        gg.fillRect(text_pos_x - box_width / 2, text_pos_y - box_height / 2, box_width, box_height);
        
        gg.setColor(Color.WHITE);
        gg.drawString(text, text_pos_x - textWidth / 2, text_pos_y + textHeight / 2);
        
    }
    // draw the lines
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainboard = new javax.swing.JPanel();
        casino = new javax.swing.JLabel();
        fire_station = new javax.swing.JLabel();
        game_shop = new javax.swing.JLabel();
        hospital = new javax.swing.JLabel();
        office1 = new javax.swing.JLabel();
        office2 = new javax.swing.JLabel();
        office3 = new javax.swing.JLabel();
        police = new javax.swing.JLabel();
        theater = new javax.swing.JLabel();
        venue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_start_play = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        input_fromto9 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        user_name = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        input_fromto2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        input_fromto3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        input_fromto4 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        input_fromto5 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        input_fromto6 = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        input_fromto7 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        input_fromto8 = new javax.swing.JTextPane();
        txt_1 = new javax.swing.JLabel();
        btn_check = new javax.swing.JButton();
        fromto9 = new javax.swing.JLabel();
        user_name_txt = new javax.swing.JLabel();
        fromto2 = new javax.swing.JLabel();
        fromto3 = new javax.swing.JLabel();
        fromto4 = new javax.swing.JLabel();
        fromto5 = new javax.swing.JLabel();
        fromto6 = new javax.swing.JLabel();
        fromto7 = new javax.swing.JLabel();
        fromto8 = new javax.swing.JLabel();
        txt_ran_sele_city = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        input_fromto_1 = new javax.swing.JTextPane();
        fromto1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainboard.setBackground(new java.awt.Color(255, 255, 255));
        mainboard.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mainboardComponentShown(evt);
            }
        });
        mainboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        casino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/casino.png"))); // NOI18N
        mainboard.add(casino, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        fire_station.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/fire station.png"))); // NOI18N
        mainboard.add(fire_station, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        game_shop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/game shop.png"))); // NOI18N
        mainboard.add(game_shop, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        hospital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/hospital.png"))); // NOI18N
        mainboard.add(hospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, -1, -1));

        office1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/office 1.png"))); // NOI18N
        mainboard.add(office1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        office2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/office 2.png"))); // NOI18N
        mainboard.add(office2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 740, -1, -1));

        office3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/office 3.png"))); // NOI18N
        mainboard.add(office3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, -1, -1));

        police.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/police station.png"))); // NOI18N
        mainboard.add(police, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 350, -1, -1));

        theater.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/theater.png"))); // NOI18N
        mainboard.add(theater, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, -1, -1));

        venue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/venue.png"))); // NOI18N
        mainboard.add(venue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 610, -1, -1));

        jLabel1.setText("theater");
        mainboard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, -1, -1));

        jLabel2.setText("Casino");
        mainboard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel3.setText("Gameshop");
        mainboard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel4.setText("Firestation");
        mainboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel5.setText("office3");
        mainboard.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));

        jLabel6.setText("office1");
        jLabel6.setToolTipText("");
        mainboard.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, -1));

        jLabel8.setText("hospital");
        mainboard.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, -1));

        jLabel9.setText("office2");
        mainboard.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 720, -1, -1));

        jLabel10.setText("venue");
        mainboard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 590, -1, -1));

        jLabel11.setText("police");
        mainboard.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 320, -1, -1));

        getContentPane().add(mainboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 1080));

        jPanel1.setBackground(new java.awt.Color(44, 36, 75));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_start_play.setBackground(new java.awt.Color(147, 174, 16));
        btn_start_play.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_start_play.setForeground(new java.awt.Color(255, 255, 255));
        btn_start_play.setText("Play");
        btn_start_play.setToolTipText("");
        btn_start_play.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_start_play.setBorderPainted(false);
        btn_start_play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_start_play.setFocusPainted(false);
        btn_start_play.setFocusable(false);
        btn_start_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_start_playActionPerformed(evt);
            }
        });
        jPanel1.add(btn_start_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, -1));

        input_fromto9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(input_fromto9);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 140, -1));

        user_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        user_name.setToolTipText("");
        jScrollPane2.setViewportView(user_name);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, -1));

        input_fromto2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(input_fromto2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 140, -1));

        input_fromto3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(input_fromto3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 140, -1));

        input_fromto4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(input_fromto4);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 140, -1));

        input_fromto5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane6.setViewportView(input_fromto5);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 140, -1));

        input_fromto6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane7.setViewportView(input_fromto6);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 140, -1));

        input_fromto7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane8.setViewportView(input_fromto7);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 140, -1));

        input_fromto8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane9.setViewportView(input_fromto8);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 140, -1));

        txt_1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_1.setForeground(new java.awt.Color(255, 255, 255));
        txt_1.setText("Selected City : ");
        jPanel1.add(txt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        btn_check.setBackground(new java.awt.Color(252, 52, 25));
        btn_check.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_check.setForeground(new java.awt.Color(255, 255, 255));
        btn_check.setText("Check");
        btn_check.setToolTipText("");
        btn_check.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_check.setBorderPainted(false);
        btn_check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_check.setFocusPainted(false);
        btn_check.setFocusable(false);
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });
        jPanel1.add(btn_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 290, -1));

        fromto9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto9.setForeground(new java.awt.Color(255, 255, 255));
        fromto9.setText("City X - City X");
        jPanel1.add(fromto9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        user_name_txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        user_name_txt.setForeground(new java.awt.Color(255, 255, 255));
        user_name_txt.setText("Name");
        jPanel1.add(user_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        fromto2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto2.setForeground(new java.awt.Color(255, 255, 255));
        fromto2.setText("City X - City X");
        jPanel1.add(fromto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        fromto3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto3.setForeground(new java.awt.Color(255, 255, 255));
        fromto3.setText("City X - City X");
        jPanel1.add(fromto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        fromto4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto4.setForeground(new java.awt.Color(255, 255, 255));
        fromto4.setText("City X - City X");
        jPanel1.add(fromto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        fromto5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto5.setForeground(new java.awt.Color(255, 255, 255));
        fromto5.setText("City X - City X");
        jPanel1.add(fromto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        fromto6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto6.setForeground(new java.awt.Color(255, 255, 255));
        fromto6.setText("City X - City X");
        jPanel1.add(fromto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        fromto7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto7.setForeground(new java.awt.Color(255, 255, 255));
        fromto7.setText("City X - City X");
        jPanel1.add(fromto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        fromto8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto8.setForeground(new java.awt.Color(255, 255, 255));
        fromto8.setText("City X - City X");
        jPanel1.add(fromto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        txt_ran_sele_city.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_ran_sele_city.setForeground(new java.awt.Color(255, 255, 255));
        txt_ran_sele_city.setText("-");
        jPanel1.add(txt_ran_sele_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        input_fromto_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane10.setViewportView(input_fromto_1);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 140, -1));

        fromto1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromto1.setForeground(new java.awt.Color(255, 255, 255));
        fromto1.setText("City X - City X");
        jPanel1.add(fromto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/cities/close-button-png-30225.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 0, 330, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainboardComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainboardComponentShown

    }//GEN-LAST:event_mainboardComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    public void drawLines(String str_city_1,String str_city_2,Color cus_color,String distance){
        JLabel city_1 = null;
        JLabel city_2 = null;
        
        //mapping str -> obj
        String[] str_cities = {"casino", "gameshop", "firestation", "office1", "office2", "office3", "hospital", "theater", "venue", "police"};
        JLabel[] cities = {casino, game_shop, fire_station, office1, office2, office3, hospital, theater, venue, police};
        
        int count = 0;
        for(String city : str_cities){
            if(city == str_city_1){
                city_1 = cities[count];
            }
            if(city == str_city_2){
                city_2 = cities[count];
            }
            count++;
        }
        
        
        Point city_1_loc_point = city_1.getLocation();
        int city_1_width = city_1.getWidth();
        int city_1_height = city_1.getHeight();
        
        Point city_2_loc_point = city_2.getLocation();
        int city_2_width = city_2.getWidth();
        int city_2_height = city_2.getHeight();
        
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        
        if((city_1_height+city_1_loc_point.y) < (city_2_height+city_2_loc_point.y)){ // bulding height comapre to findout bulding in top / bottom
            bottom = true;
        }
        else{
            top = true;
        }
        
        if((city_1_loc_point.x+city_1_width) < (city_2_loc_point.x+city_2_width)){ // check for side
            right = true;
        }
        else{
            left = true;
        }
        
        // compare
        if(left == true && top == true){
            System.out.println("TOP LEFT");
            // city 2 need to be bottom right
            
            int start_x = city_1_loc_point.x + 25;
            int start_y = city_1_loc_point.y + city_1_height - (city_1_height / 3) - 12;
            
            int end_x = city_2_loc_point.x + city_2_width - 25;
            int end_y = city_2_loc_point.y + city_2_height - 25;
            
            connect(start_x, start_y, end_x, end_y,cus_color,distance);
        }
        if(right == true && top == true){
            System.out.println("TOP RIGHT");
            
            int start_x = city_1_loc_point.x + city_1_width - 15;
            int start_y = city_1_loc_point.y + city_1_height - 50;
            
            int end_x = city_2_loc_point.x + 50;
            int end_y = city_2_loc_point.y + city_2_height;
            
            connect(start_x, start_y, end_x, end_y,cus_color,distance);
        }
        if(left == true && bottom == true){
            System.out.println("BOTTOM LEFT");
            
            int start_x = city_1_loc_point.x + 50;
            int start_y = city_1_height + city_1_loc_point.y;
            
            int end_x = city_2_loc_point.x + city_2_width - 15;
            int end_y = city_2_loc_point.y + (city_1_height / 2) + 25;
            
            connect(start_x, start_y, end_x, end_y,cus_color,distance);
        }
        if(right == true && bottom == true){
            System.out.println("BOTTOM RIGHT");
            
            int start_x = (city_1_width + city_1_loc_point.x) - 25;
            int start_y = (city_1_height + city_1_loc_point.y) - 25;
            
            int end_x = city_2_loc_point.x + 20;
            int end_y = city_2_loc_point.y + ((city_2_height*2)/5) + 25;
            
            connect(start_x, start_y, end_x, end_y,cus_color,distance);
        }
    }
    
    private void btn_start_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_start_playActionPerformed
        
        if(user_name.getText().equals("")){
            System.err.println("not null");
            
            JOptionPane.showMessageDialog(this, "Please enter the player name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            cnt = new IdentifyShortestPathController();
            cnt.giveDistance(this,this.city_from_to,this.input_city_from_to,this.txt_ran_sele_city);
        }
    }//GEN-LAST:event_btn_start_playActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        // TODO add your handling code here:
        
        boolean valid = true;
        //check for null inputs / not valid inputs
        
        
        for(JTextPane p : this.input_city_from_to){
            
            String inputText = p.getText().trim();
            System.err.println(p.getText());
            if(inputText.isEmpty()){
                valid=false;
                break;
            }
            else{
                try {
                    int intValue = Integer.parseInt(inputText);
                } catch (NumberFormatException e) {
                    valid = false;
                    break;
                }
            }
        }
        
        if(valid){
            boolean win = cnt.checkResults(this.input_city_from_to,this.user_name);
            if(win == true){
                JOptionPane.showMessageDialog(this, "You won the game !! ", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "You lost the game. Please try again !!", "Game Over", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please ensure that all required inputs are numbers and provided before proceeding with the check...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_checkActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IdentifyShortestPathView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentifyShortestPathView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentifyShortestPathView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentifyShortestPathView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdentifyShortestPathView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_start_play;
    private javax.swing.JLabel casino;
    private javax.swing.JLabel fire_station;
    private javax.swing.JLabel fromto1;
    private javax.swing.JLabel fromto2;
    private javax.swing.JLabel fromto3;
    private javax.swing.JLabel fromto4;
    private javax.swing.JLabel fromto5;
    private javax.swing.JLabel fromto6;
    private javax.swing.JLabel fromto7;
    private javax.swing.JLabel fromto8;
    private javax.swing.JLabel fromto9;
    private javax.swing.JLabel game_shop;
    private javax.swing.JLabel hospital;
    private javax.swing.JTextPane input_fromto2;
    private javax.swing.JTextPane input_fromto3;
    private javax.swing.JTextPane input_fromto4;
    private javax.swing.JTextPane input_fromto5;
    private javax.swing.JTextPane input_fromto6;
    private javax.swing.JTextPane input_fromto7;
    private javax.swing.JTextPane input_fromto8;
    private javax.swing.JTextPane input_fromto9;
    private javax.swing.JTextPane input_fromto_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel mainboard;
    private javax.swing.JLabel office1;
    private javax.swing.JLabel office2;
    private javax.swing.JLabel office3;
    private javax.swing.JLabel police;
    private javax.swing.JLabel theater;
    private javax.swing.JLabel txt_1;
    private javax.swing.JLabel txt_ran_sele_city;
    private javax.swing.JTextPane user_name;
    private javax.swing.JLabel user_name_txt;
    private javax.swing.JLabel venue;
    // End of variables declaration//GEN-END:variables
}

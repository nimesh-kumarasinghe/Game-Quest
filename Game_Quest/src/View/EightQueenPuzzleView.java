
package View;

import Controller.EightQueenPuzzleController;
import game_quest.MainMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.nio.file.Files.size;
import javax.imageio.ImageIO;

/**
 *
 * @author Nisal
 */
public class EightQueenPuzzleView extends javax.swing.JFrame {
    private JButton[][] squares;
    private EightQueenPuzzleController controller;
    
    //Create Chessboard
    
    public EightQueenPuzzleView(int size) {
        initComponents();
               // setTitle("Eight queens’ puzzle");
                JPanel chessboardPanel = new JPanel(new GridLayout(size, size));
                squares = new JButton[size][size];

                initializeChessboard(size, chessboardPanel);
                
                
                try {
                      /*  BufferedImage queenImg = ImageIO.read(getClass().getResource("/Images/images.png"));
                        ImageIcon queenIcon = new ImageIcon(queenImg.getScaledInstance(750, 780, Image.SCALE_SMOOTH));
                       // lbl_background.setIcon(closedIcon);*/
            
                    
                        BufferedImage closeImage = ImageIO.read(getClass().getResource("/Images/images.png"));
                        ImageIcon closedIcon = new ImageIcon(closeImage.getScaledInstance(750, 780, Image.SCALE_SMOOTH));
                        lbl_background.setIcon(closedIcon);
            
            
                        BufferedImage profileImage = ImageIO.read(getClass().getResource("/Images/profileImg.png"));
                        ImageIcon proImage = new ImageIcon(profileImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH));
                        lbl_profile.setIcon(proImage);
                        
                        BufferedImage homeIcon = ImageIO.read(getClass().getResource("/Images/home.png"));
                        ImageIcon homeImg = new ImageIcon(homeIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                        lbl_homeIcon.setIcon(homeImg);
                        
                        BufferedImage resetIcon = ImageIO.read(getClass().getResource("/Images/reset.png"));
                        ImageIcon resetImg = new ImageIcon(resetIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                        lbl_resetIcon.setIcon(resetImg);

                     } 
                catch (IOException e) 
                {
                    
                }
                
                }
    
    
    public void setController(EightQueenPuzzleController controller) 
    {
        this.controller = controller;
    }
    
    private void initializeChessboard(int size, JPanel chessboardPanel) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.setBackground((row + col) % 2 == 0 ? new Color(139, 69, 19) : new Color(255, 222, 173));

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        int rowClicked = -1, colClicked = -1;

                        for (int r = 0; r < size; r++) {
                            for (int c = 0; c < size; c++) {
                                if (squares[r][c] == clickedButton) {
                                    rowClicked = r;
                                    colClicked = c;
                                    break;
                                }
                            }
                        }

                        controller.handleSquareClick(rowClicked, colClicked);
                    }
                });

                squares[row][col] = button;
                chessboardPanel.add(button);
            }
        }
        panel_chessboard.setLayout(new BorderLayout());
        panel_chessboard.add(chessboardPanel, BorderLayout.CENTER);
    }
    
     public void updateSquare(int row, int col, ImageIcon icon) 
     {
        squares[row][col].setIcon(icon);
     }
     
     public void showMessage(String message) 
     {
        JOptionPane.showMessageDialog(this, message, "Game Message", JOptionPane.INFORMATION_MESSAGE);
     }
     
     public void updateScore(String scoreText) 
     {
        jLabel2.setText(scoreText);
     }
     
     public JLabel setPlayerNameLabel(String playerName) 
     {
        lbl_plyerName.setText("Player Name: " + playerName);
        return lbl_plyerName;
     }
     
     public void showTryMessage(String message) 
     {
        JOptionPane.showMessageDialog(this, message, "Game Message", JOptionPane.INFORMATION_MESSAGE);
     }

              
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_chessboard = new javax.swing.JPanel();
        lbl_background = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_plyerName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_reset = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        lbl_profile = new javax.swing.JLabel();
        lbl_homeIcon = new javax.swing.JLabel();
        lbl_resetIcon = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_chessboard.setBackground(new java.awt.Color(204, 102, 0));
        panel_chessboard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 51), null, null));
        panel_chessboard.setForeground(new java.awt.Color(153, 102, 0));
        panel_chessboard.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panel_chessboardLayout = new javax.swing.GroupLayout(panel_chessboard);
        panel_chessboard.setLayout(panel_chessboardLayout);
        panel_chessboardLayout.setHorizontalGroup(
            panel_chessboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        panel_chessboardLayout.setVerticalGroup(
            panel_chessboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        getContentPane().add(panel_chessboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 630, 660));
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -130, 790, 1040));
        lbl_background.getAccessibleContext().setAccessibleName("lbl_Score");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        lbl_plyerName.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        lbl_plyerName.setText("jLabel3");
        lbl_plyerName.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        lbl_reset.setBackground(new java.awt.Color(255, 102, 0));
        lbl_reset.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        lbl_reset.setForeground(new java.awt.Color(255, 255, 255));
        lbl_reset.setText("Reset");
        lbl_reset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_resetActionPerformed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(153, 51, 0));
        btn_home.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setText("Home");
        btn_home.setToolTipText("");
        btn_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(lbl_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(lbl_resetIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                        .addComponent(lbl_plyerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lbl_homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(lbl_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_plyerName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_resetIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, -70, 620, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_resetActionPerformed
        
        controller.resetChessboard();
    }//GEN-LAST:event_lbl_resetActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       MainMenu menu =  new MainMenu();
        menu.setVisible(true);
        this.setVisible(false);      }//GEN-LAST:event_btn_homeActionPerformed

    /**
     * @param args the command line arguments
     */
  /*  public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChessboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChessboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChessboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChessboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChessboardView().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_homeIcon;
    private javax.swing.JLabel lbl_plyerName;
    private javax.swing.JLabel lbl_profile;
    private javax.swing.JButton lbl_reset;
    private javax.swing.JLabel lbl_resetIcon;
    private javax.swing.JPanel panel_chessboard;
    // End of variables declaration//GEN-END:variables
}


/**
 * Write a description of class BattleViewer here.
 *
 * @author Dean Thomas
 * @version 2015.11.20
 */
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class BattleViewer extends JFrame
{
    private Battle battle;
    private javax.swing.JLabel creaturesRemainingLeft;
    private javax.swing.JLabel creaturesRemainingRight;
    private javax.swing.JLabel hpLeft;
    private javax.swing.JLabel hpRight;
    private javax.swing.JLabel onePic;
    private javax.swing.JLabel sideOneLabel;
    private javax.swing.JLabel sideTwoLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel twoPic;
    private javax.swing.JLabel titleText;
    private javax.swing.JLabel winText;

    /**
     * Constructor for objects of class BattleViewer
     */
    public BattleViewer(Battle battle)
    {
       this.battle = battle;
       createWindow();
    }


    public void createWindow() {
        onePic = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        twoPic = new javax.swing.JLabel();
        creaturesRemainingLeft = new javax.swing.JLabel();
        creaturesRemainingRight = new javax.swing.JLabel();
        sideOneLabel = new javax.swing.JLabel();
        sideTwoLabel = new javax.swing.JLabel();
        hpLeft = new javax.swing.JLabel();
        hpRight = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        onePic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        titleLabel.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Creature War");

        twoPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        creaturesRemainingLeft.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        creaturesRemainingLeft.setText("Creatures Remaining:");

        creaturesRemainingRight.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        creaturesRemainingRight.setText("Creatures Remaining:");

        sideOneLabel.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        sideOneLabel.setText("Side One");

        sideTwoLabel.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        sideTwoLabel.setText("Side Two");

        hpLeft.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        hpLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpLeft.setText("HP: ");

        hpRight.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        hpRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hpRight.setText("HP: ");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(232, 232, 232))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(sideOneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sideTwoLabel)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onePic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creaturesRemainingLeft)
                    .addComponent(hpLeft))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(twoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creaturesRemainingRight)
                    .addComponent(hpRight))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sideOneLabel)
                    .addComponent(sideTwoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creaturesRemainingLeft)
                    .addComponent(creaturesRemainingRight))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onePic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoPic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hpLeft)
                    .addComponent(hpRight, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);

    }

    public void refresh() {
        creaturesRemainingLeft.setText("Creatures Remaining: " + battle.getOneRemainingText());
        creaturesRemainingRight.setText("Creatures Remaining: " + battle.getTwoRemainingText());
        hpLeft.setText("HP: " + battle.getOneCurrent().getHealthText());
        hpRight.setText("HP: " + battle.getTwoCurrent().getHealthText());
        if(battle.getTwoCurrent().getImage() != null){
            twoPic.setIcon(battle.getTwoCurrent().getImage());
        }
         if(battle.getOneCurrent().getImage() != null){
            onePic.setIcon(battle.getOneCurrent().getImage());
        }

        revalidate();
        repaint();
    }

    public void win(String side) {
        
        String winText = side + " Wins!";
        JOptionPane.showMessageDialog(this, winText, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        
        /*Component[] components = getContentPane().getComponents();
        for (Component component: components) {
            component.setVisible(false);
        }
        titleLabel.setVisible(true);   
        revalidate();
        setVisible(true); */
        
    }

}

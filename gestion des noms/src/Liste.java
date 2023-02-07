import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public  class Liste extends JFrame implements ActionListener {

int index;
//differents zone de texte
private JTextField PrenomT;
private JTextField nomT;
private JTextField numeroT;
//differents zone de texte
String Nom;
String Prenom;
String menu;
String numeroTel;
//differents affichage de texte de linterface.

JLabel nom;
JLabel prenom;
JLabel tel;
JLabel liste_amis;
JLabel liste_noire;
JLabel liste_archive;
JLabel avertissement;
//differents boutton  present sur linterface
JButton ok;
JButton ajouter;
JButton supprimer;
JButton bloquer;
JButton debloquer;
JButton archiver;
//Differents panel de linterface
JPanel Okay;
JPanel Nom_panel;
JPanel Button_panel;
JPanel panel_Liste_AMIS;
JPanel panel_liste_NOIRE;
JPanel panel_liste_ARCHIVER;
//differentes listes  
JList <String> liste_AMIS;
JList <String> liste_NOIRE;
JList <String> liste_ARCHIVE;

DefaultListModel<String> Aliste_Amis ;
DefaultListModel<String> Aliste_Noire ;
DefaultListModel<String> Aliste_Archiver ;

  public Liste(){


this.setTitle("LISTE-CONTACTS");// titre de la fenetre
this.setSize(800,800);// taille de la fenetre 

// pannel comportant les titres et les zones de texte
Nom_panel=new JPanel();
Nom_panel.setBounds(0,20,800,60);
//different zone de texte et titres du panel 
this.nom= new JLabel("nom:");
this.nomT=new JTextField(10);
this.prenom= new JLabel("Prenom:");
this.PrenomT= new JTextField(10);
this.tel= new JLabel("Tel:");
this.numeroT=new JTextField(10);

//creation des differentes listes
Aliste_Amis=new DefaultListModel<>();
Aliste_Archiver=new DefaultListModel<>();
Aliste_Noire=new DefaultListModel<>();

Nom_panel.add(this.prenom);
Nom_panel.add(this.PrenomT);
Nom_panel.add(this.nom);
Nom_panel.add(this.nomT);
Nom_panel.add(this.tel);
Nom_panel.add(this.numeroT);
// panel du button ok present en bas de la fenetre
this.Okay=new JPanel();
Okay.setBounds(1, 730, 700, 30);
this.ok=new JButton("Ok");
Okay.add(this.ok);

// pannel comportant les bouttons cliquable
this.Button_panel=new JPanel();
this.Button_panel.setBounds(0,80,800,60);
// different bouttons present dans le panel 
this.ajouter= new JButton("Ajouter");
this.Button_panel.add(this.ajouter);
this.ajouter.addActionListener(this);

this.supprimer= new JButton("supprimer");
this.Button_panel.add(this.supprimer);
this.supprimer.addActionListener(this);

this.bloquer= new JButton("Bloquer");
this.Button_panel.add(this.bloquer);
this.bloquer.addActionListener(this);

this.debloquer= new JButton("Debloquer");
this.Button_panel.add(this.debloquer);
this.debloquer.addActionListener(this);

this.archiver= new JButton("Archiver");
this.Button_panel.add(this.archiver);
this.archiver.addActionListener(this);

// panel de la liste des amis
this.panel_Liste_AMIS= new JPanel();
this.panel_Liste_AMIS.setBounds(10,140,100,30);
this.liste_amis= new JLabel("liste d'amis");
this.panel_Liste_AMIS.add(liste_amis);
//panel de la liste noire
this.panel_liste_NOIRE= new JPanel();
this.panel_liste_NOIRE.setBounds(350,140,100,30);
this.liste_noire= new JLabel("liste noire");
this.panel_liste_NOIRE.add(liste_noire);

//panel de la liste des archives

this.panel_liste_ARCHIVER= new JPanel();
this.panel_liste_ARCHIVER.setBounds(550,140,100,30);
this.liste_archive= new JLabel("liste archive");
this.panel_liste_ARCHIVER.add(liste_archive);
// differentes liste crées 
liste_AMIS= new JList <> (Aliste_Amis);
this.liste_AMIS.setBounds(1, 159, 233, 500);

liste_NOIRE= new JList<>(Aliste_Noire);
liste_NOIRE.setBounds(250, 159, 233, 500);

liste_ARCHIVE= new JList <> (Aliste_Archiver);
this.liste_ARCHIVE.setBounds(510, 159, 233, 500);

// ajout des differentes panel et liste dans la fenetre
this.add(this.Nom_panel);
this.add(this.Button_panel);
this.add(this.panel_Liste_AMIS);
this.add(this.panel_liste_NOIRE);
this.add(this.panel_liste_ARCHIVER);
this.add(this.liste_AMIS);
this.add(this.liste_NOIRE);
this.add(this.liste_ARCHIVE);
this.add(this.Okay);

this.setLayout((LayoutManager)null);
this.setVisible(true);
this.setDefaultCloseOperation(2);

// message d'erreur ou de success qui sffiche . 
avertissement = new JLabel();
this.avertissement.setBounds(100, 680, 800, 30);
this.add(avertissement);



  }

// traitement des differents actions de l'interface

  @Override
  public void actionPerformed(ActionEvent e) {
 
	  // condition du boutton Ajouter
    if (e.getSource() == this.ajouter) {
    	avertissement.setText("");
  
    	if (!this.PrenomT.getText().isEmpty() && !this.nomT.getText().isEmpty() && !this.numeroT.getText().isEmpty()) {
          this.Prenom = this.PrenomT.getText();
          this.Nom = this.nomT.getText();
          this.numeroTel = this.numeroT.getText().toString();
          this.Aliste_Amis.addElement(this.Prenom + "   " + this.Nom + "   " + this.numeroTel );
          this.PrenomT.setText(" ");
          this.nomT.setText(" ");
          this.numeroT.setText(" ");
          
          avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
          avertissement.setForeground(Color.green);
    	  avertissement.setText("Donnees enregistre dans le systeme avec succes" );

        
      } 
        else {
          avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
          avertissement.setForeground(Color.RED);
          avertissement.setText("Veuillez remplir les zones de texte svp" );
          }
        if (!NumberOnly(numeroT))	 {
  		
            avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
            avertissement.setForeground(Color.RED);
            avertissement.setText("Veuillez rentrer un numero de telephone valide");
            }
          }
    
    
 // condition du boutton Supprimer
    
    if (e.getSource() == this.supprimer) {
    	avertissement.setText("");
      if (this.liste_AMIS.getSelectedValue() != null) {
          this.index = this.liste_AMIS.getSelectedIndex();
          this.Aliste_Amis.remove(this.index);
     
      avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
          avertissement.setForeground(Color.green);
    	  avertissement.setText("Donnees supprime avec succes" );
      }
      
       else {
    	  avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
    	  avertissement.setForeground(Color.RED);
    	  avertissement.setText("Veuillez selectionner la donnee a supprimer" );
      }
    }
    
    // condition du boutton Bloquer
        if (e.getSource() == this.bloquer) {
	  avertissement.setText("");
   
        if (this.liste_AMIS.getSelectedValue() != null) {
          this.menu = (String)this.liste_AMIS.getSelectedValue();
          this.Aliste_Noire.addElement(this.menu);
          this.index = this.liste_AMIS.getSelectedIndex();
          this.Aliste_Amis.remove(this.index);
          
          avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
          avertissement.setForeground(Color.green);
    	  avertissement.setText("Donnees bloquees avec succes" );
      } 
      else {

    	  avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
    	  avertissement.setForeground(Color.RED);
          avertissement.setText("Veuillez selectionner le nom a bloquer" );
      }
      
      // condition du boutton DeBloquer
      
  } 
   if (e.getSource() == this.debloquer) {
     
	  avertissement.setText("");
      if (this.liste_NOIRE.getSelectedValue() != null) {
          this.menu = (String)this.liste_NOIRE.getSelectedValue();
          this.Aliste_Amis.addElement(this.menu);
          this.index = this.liste_NOIRE.getSelectedIndex();
          this.Aliste_Noire.remove(this.index);
          
          avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
          avertissement.setForeground(Color.green);
    	  avertissement.setText("Donnees debloquees avec succes" );
      } 
      else {
    	 
    	  avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
    	  avertissement.setForeground(Color.RED);
    	  avertissement.setText("Veuillez selectionner le nom a debloquer" );
      }
      
      // condition du boutton Archiver
  } 
   if (e.getSource() == this.archiver) {
	  avertissement.setText("");
     
	  if (this.liste_NOIRE.getSelectedValue() != null) {
          this.menu = (String)this.liste_NOIRE.getSelectedValue();
          this.Aliste_Archiver.addElement(this.menu);
          this.index = this.liste_NOIRE.getSelectedIndex();
          this.Aliste_Noire.remove(this.index);
          
          avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
          avertissement.setForeground(Color.green);
    	  avertissement.setText("Donnees Archivees avec succes" );
          
      }
	  else {

		  avertissement.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		  avertissement.setForeground(Color.RED);
		  avertissement.setText("Veuillez selectionner le nom a archiver dans la liste noire" );
      }
  }
  }


// si la zone de tel: ne comporte pas un numero valide(type int)  

    public boolean NumberOnly(JTextField txtField){
      boolean isnotNumber;
      isnotNumber = txtField.getText().toString().chars().allMatch( x -> Character.isDigit(x));
      return isnotNumber;
  }
  } 



 

  



   
  



  

    


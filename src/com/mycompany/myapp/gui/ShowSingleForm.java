/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.company.myapp.entities.Produit;

/**
 *
 * @author Raef
 */
public class ShowSingleForm extends Form{
    Resources theme;

    ShowSingleForm(Produit p,Form previous) {
        theme = UIManager.initFirstTheme("/theme");
      setTitle("Détails du produit");
        setLayout(new FlowLayout(CENTER,BRB_CONSTANT_ASCENT));
        Container cont=new Container(BoxLayout.y());
        String urll = "http://localhost/PiSymfony/web/public/uploads/" + p.getPhoto_P();
            EncodedImage enc = EncodedImage.createFromImage(theme.getImage("loading.png").scaled(250, 250), false);
            URLImage urlimg = URLImage.createToStorage(enc, p.getNom_P(), urll);
            ImageViewer image = new ImageViewer(urlimg);
            Image imgg = image.getImage();
            
            Label lbprix=new Label("Prix : "+p.getPrix_P()+" DT");
            Label lbNom=new Label("Nom : "+p.getNom_P());
            Label lbcat=new Label("Catégorie : "+p.getCategorie_P());
            Label lbmarque=new Label("Marque : "+p.getMarque_P());
            Label lbcoul=new Label("Couleur : "+p.getCouleur_P());
           Label lbtel=new Label("Téléphone : "+p.getTel());
       
        cont.add(imgg);
        cont.add(lbprix);
        
        cont.add(lbNom);
        cont.add(lbcat);
        cont.add(lbmarque);
        cont.add(lbcoul);
        cont.add(lbtel);
        add(cont);
        
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
    
}

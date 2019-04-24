/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.InterfaceDAO;
import DAO.SerieDAO;
import Util.Util;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Serie;

/**
 * FXML Controller class
 *
 * @author ComputaDor
 */
public class IncluirController implements Initializable {
    
    InterfaceDAO dao = new SerieDAO();

    @FXML
    private TextField txtSerie;
    @FXML
    private TextField txtTemporadas;
    @FXML
    private TextField txtEmissora;
    @FXML
    private TextField txtClassificacao;
    @FXML
    private TextField txtEpisodios;
    @FXML
    private Button btnGravar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gravar(ActionEvent event) {
        try {
            String serie = txtSerie.getText();
            int temporadas = Integer.parseInt(txtTemporadas.getText());
            String emissora = txtEmissora.getText();
            Float classificacao = Float.parseFloat(txtClassificacao.getText());
            int episodios = Integer.parseInt(txtEpisodios.getText());
            //String imagem = imgg;
            Serie c = new Serie(serie, temporadas, emissora, episodios, classificacao );
            c.setStatus(false);
            c.setImg("aa");
            //c.setImg(imgg);
            
            
            System.out.println("oloco");
            dao.incluir(c);
            //apagarCamposGravacao();
            Util.fecharTela(btnGravar);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }//adicionar tudo 
    }
    
    
}

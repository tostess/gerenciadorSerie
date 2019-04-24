/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.InterfaceDAO;
import DAO.SerieDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Serie;

/**
 * FXML Controller class
 *
 * @author ComputaDor
 */
public class MenuController implements Initializable {

    @FXML
    private TableColumn<Serie, String> serieCItem;
    @FXML
    private TableColumn<Serie, Integer> temporadasCItem;
    @FXML
    private TableColumn<Serie, String> emissoraCItem;
    @FXML
    private TableColumn<Serie, Integer> episodiosCItem;
    @FXML
    private TableColumn<Serie, Float> classificacaoCItem;
    @FXML
    private TableColumn<Serie, Boolean> statusCItem;
    @FXML
    private TableColumn<Serie, Integer> idCItem;
    @FXML
    private TableView<Object> tableView;
    
    
    
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnExluir;
    @FXML
    private Button btnEditar;
    @FXML
    private ImageView imgView;
    
    InterfaceDAO dao = new SerieDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {

            
            serieCItem.setCellValueFactory(new PropertyValueFactory<>("Serie"));
            temporadasCItem.setCellValueFactory(new PropertyValueFactory<>("Temporadas"));
            emissoraCItem.setCellValueFactory(new PropertyValueFactory<>("Emissora"));
            episodiosCItem.setCellValueFactory(new PropertyValueFactory<>("Episodios"));
            classificacaoCItem.setCellValueFactory(new PropertyValueFactory<>("Classificacao"));
            statusCItem.setCellValueFactory(new PropertyValueFactory<>("Status"));
            idCItem.setCellValueFactory(new PropertyValueFactory<>("Id"));
            
            
             //System.out.println(dao.listar());
            update();
        } catch (Exception ex) {
             System.out.println("deu ruim table");
        }
        // TODO
    }  
    private void update(){
        try {
            tableView.getItems().setAll(dao.listar());
           
            //Image imageObject = new Image("/img/20180403121621_816.png");
        
            //imgView.setImage(imageObject);
        } catch (Exception ex) {
            Logger.getLogger("erro");
        }
    }

    @FXML
    private void incluir(ActionEvent event) {
        System.out.println("aaaaaa");
        chamarTela("/view/Incluir.fxml");
        
    }
    public void chamarTela(String arquivo) {
        try {
            FXMLLoader loader
                    = new FXMLLoader(getClass().getResource(arquivo));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }
    
}

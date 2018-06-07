
package apptarea2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.apptarea2.Controller.LoginController;
import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.AnchorPane;


public class AppTarea2 extends Application {
           
   private Stage escenarioPrincipal;
   private final String PaqueteVista = "/com/apptarea2/View/";
   @Override
   
   public void start(Stage escenarioPrincipal){
       
       this.escenarioPrincipal = escenarioPrincipal;
       this.escenarioPrincipal.setTitle("Tarea 1.0");
       
       mostrarLogin();
       this.escenarioPrincipal.show();
       
   }
   
   public void mostrarLogin(){
       
       try {
           LoginController login =(LoginController)cambiarEscena("LoginView.fxml",600,400);
       } catch (Exception e) {
           e.printStackTrace();
       }
       
   }
    
   public Initializable cambiarEscena(String fxml, int ancho, int alto) throws IOException{
       
       Initializable resultado = null;
       
       FXMLLoader cargadorFXML = new FXMLLoader();
       
       InputStream archivo = AppTarea2.class.getResourceAsStream(PaqueteVista+fxml);
       
       cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
       
       cargadorFXML.setLocation(AppTarea2.class.getResource(PaqueteVista+fxml));
       
       Scene escena = new Scene ((AnchorPane)cargadorFXML.load(archivo), ancho,alto);
       
       this.escenarioPrincipal.setScene(escena);
       
       this.escenarioPrincipal.sizeToScene();
       
       resultado = (Initializable)cargadorFXML.getController();
       return resultado;
       
       
   }
   
   public static void main(String args[]){
       
       launch(args);
   }
}

package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Product;
import model.services.ProductService;

public class ProductListController implements Initializable, DataChangeListener {
	
	private ProductService service;
	
	@FXML
	private TableView<Product> tableViewProduct;

	@FXML
	private TableColumn<Product, String> tableColumnCod;
	
	@FXML
	private TableColumn<Product, String> tableColumnDesc;
	
	@FXML
	private TableColumn<Product, String> tableColumnTipo;
	
	@FXML
	private TableColumn<Product, String> tableColumnDescest;
	
	@FXML
	private Button btNew;
	
	@FXML
	private TableColumn<Product, Product> tableColumnEDIT;

	@FXML
	private TableColumn<Product, Product> tableColumnREMOVE;
	
	private ObservableList<Product> obsList;
	
	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Product obj = new Product();
		createDialogForm(obj,"/gui/ProductForm.fxml",parentStage,1);
	}
	
	public void setProductService(ProductService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializenodes();
		
	}

	private void initializenodes() {
		tableColumnCod.setCellValueFactory(new PropertyValueFactory<>("cod"));
		tableColumnDesc.setCellValueFactory(new PropertyValueFactory<>("descr") );
		tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tableColumnDescest.setCellValueFactory(new PropertyValueFactory<>("descest"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewProduct.prefHeightProperty().bind(stage.heightProperty());
		initEditButtons();
		initRemoveButtons();
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service esta nulo");
			
		}
		
		List<Product> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewProduct.setItems(obsList);
		
	}
	
	private void createDialogForm(Product obj,String absoluteName,Stage parentStage, int operation) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			ProductFormController controller = loader.getController();
			controller.setProduct(obj);
			controller.setOperation(operation);
			controller.setProductService(new ProductService());
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com o produto novo");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		} catch (IOException e) {
				Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@Override
	public void onDataChanged() {
		updateTableView();
	}
	
	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Product, Product>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Product obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/ProductForm.fxml", Utils.currentStage(event),2));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Product, Product>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Product obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(Product obj) {
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you sure to delete?");

		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("Service was null");
			}
			try {
				service.remove(obj);
				updateTableView();
			}
			catch (DbIntegrityException e) {
				Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
			}
		}
	}
		
}

package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Product;
import model.exceptions.ValidationException;
import model.services.ProductService;



public class ProductFormController implements Initializable {

	private Product entity;
	private ProductService service;
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	private int operation;
	@FXML
	private TextField txtCod;
	@FXML
	private TextField txtDescr;
	@FXML
	private TextField txtTipo;
	@FXML
	private TextField txtDescest;
	
	@FXML
	private Label labelErrorName;
		
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;
	
	public void setProduct(Product entity) {
		this.entity = entity;
	}
	
	public void setProductService(ProductService service) {
		this.service = service;
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	public void updateFormData() {
		
		if (entity ==null) {
			throw new IllegalStateException("Entidade esta nula");
		}
		txtCod.setText(entity.getCod());
		txtDescr.setText(entity.getDescr());
		txtTipo.setText(entity.getTipo());
		txtDescest.setText(entity.getDescest());
		
	}
	
	@FXML
	public void onBtSalvarAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entidade vazia");
		}
		if(service == null) {
			throw new IllegalStateException("Servico vazia");
		}
		
		try {
		entity = getFormData();
		service.saveOrUpdate(entity,this.operation);
		notifyDataChangeListeners();
		Utils.currentStage(event).close();
		
		}
		catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		}
		catch (DbException e) {
			Alerts.showAlert("Erro ao Salvar o Objeto", null,e.getMessage(), AlertType.ERROR);
		}
		
	}
	
	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}
	
	private Product getFormData() {
		Product obj = new Product();
		
		ValidationException exception = new ValidationException("Validação de exceção");
		
		if(txtCod.getText() == null || txtCod.getText().trim().equals("")) {
			exception.addError("cod", "Cmapo não pode ser vazio");
		}
		
		obj.setDescr(txtDescr.getText());
		obj.setTipo(txtTipo.getText());
		obj.setDescest(txtDescest.getText());
		
		if(exception.getErrors().size() > 0) {
			throw exception;
		}
		
		return obj;
	}

	@FXML
	public void onBtCancelarAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	private void initializableNodes() {
		Constraints.setTextFieldMaxLength(txtCod,20);
		Constraints.setTextFieldMaxLength(txtTipo,2);
				
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializableNodes();
		
	}


	private void setErrorMessages(Map<String,String> errors) {
		Set<String> fields = errors.keySet();
		
		if(fields.contains("cod")) {
			labelErrorName.setText(errors.get("cod"));
		}
	}
	

}

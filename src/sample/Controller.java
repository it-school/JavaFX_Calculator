package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.classes.Operation;

public class Controller {
   @FXML
   TextField display;

   @FXML
   Label lblMemory;

   boolean isOperationPressed = false;
   boolean isCalculatePressed = false;

   public void btnOperationClick(ActionEvent actionEvent) {
      try {
         Main.calculator.setNumber1(Double.parseDouble(display.getText()));

         switch (((Button) actionEvent.getSource()).getText()) {
            case "+":
               Main.calculator.setOperation(Operation.plus);
               break;
            case "-":
               Main.calculator.setOperation(Operation.minus);
               break;
            case "*":
               Main.calculator.setOperation(Operation.multiply);
               break;
            case "/":
               Main.calculator.setOperation(Operation.divide);
               break;
            case "√":
               Main.calculator.setOperation(Operation.sqrt);
               Main.calculator.calculate();
               display.setText(Main.calculator.getResult());
               break;
         }
         isOperationPressed = true;
      } catch (Exception exception) {

      }
      isCalculatePressed = false;

   }

   public void numberBtnClick(ActionEvent actionEvent) {
      if (isOperationPressed) {
         display.setText("0");
         isOperationPressed = false;
      }

      getValueFromDisplay(actionEvent);
      isCalculatePressed = false;

   }

   private void getValueFromDisplay(ActionEvent actionEvent) {
      String displayText = display.getText();
      double number = 0;
      try {
         number = Double.parseDouble(displayText);
         if (number == 0)
            display.setText(((Button) actionEvent.getSource()).getText());
         else
            display.setText(display.getText() + ((Button) actionEvent.getSource()).getText());
      } catch (Exception exception) {

      }
   }

   public void btnClearClick(ActionEvent actionEvent) {
      display.setText("0");
      Main.calculator.clearAll();
      isCalculatePressed = false;
   }

   public void btnMemoryPlusClick(ActionEvent actionEvent) {
      Main.calculator.setMemory(Main.calculator.getMemory() + Double.parseDouble(display.getText()));
      displayMemoryState();
   }

   public void btnMemoryMinusClick(ActionEvent actionEvent) {
      Main.calculator.setMemory(Main.calculator.getMemory() - Double.parseDouble(display.getText()));
      displayMemoryState();
   }

   public void btnMemoryStoreClick(ActionEvent actionEvent) {
      Main.calculator.setMemory(Double.parseDouble(display.getText()));
      displayMemoryState();
   }

   public void btnMemoryReadClick(ActionEvent actionEvent) {
      display.setText(Main.calculator.getMemory() + "");
      displayMemoryState();
   }

   public void btnMemoryClearClick(ActionEvent actionEvent) {
      Main.calculator.setMemory(0);
      displayMemoryState();
   }

   public void displayMemoryState()
   {
      lblMemory.setVisible(Main.calculator.getMemory() != 0 ? true : false);
   }

   public void btnCalculateClick(ActionEvent actionEvent) {
      if (!isCalculatePressed)
         Main.calculator.setNumber2(Double.parseDouble(display.getText()));

      Main.calculator.calculate();
      display.setText(Main.calculator.getResult());

      try {
         Main.calculator.setNumber1(Double.parseDouble(display.getText()));
      } catch (Exception exception) {

      }
      isCalculatePressed = true;
   }
}

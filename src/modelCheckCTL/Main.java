package modelCheckCTL;

import modelCheckCTL.controller.ModelCheckerController;
import modelCheckCTL.view.ModelCheckerView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ModelCheckerView view = new ModelCheckerView();
            new ModelCheckerController(view);
        });
    }
}

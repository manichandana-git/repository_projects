package modelCheckCTL;

import modelCheckCTL.controller.ModelCheckerController;
import modelCheckCTL.view.ModelCheckerView;
import android.util.Log;  // Import the Log class


public class Main {
    public static void main(String[] args) {
        Log.e("MAIN", "NewCommit Testing");
        javax.swing.SwingUtilities.invokeLater(() -> {
            ModelCheckerView view = new ModelCheckerView();
            new ModelCheckerController(view);
        });
    }
}

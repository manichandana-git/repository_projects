package modelCheckCTL.model;

import java.util.regex.Pattern;

public class CtlFormula {
    private String formula;

    public CtlFormula(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

    public boolean isValidSyntax() {
        String ctlPattern = "^(EX|AX|EF|AF|EG|AG|E\\[.* U .+\\]|A\\[.* U .+\\]|not|and|or|->|[a-zA-Z]+)+$";
        return Pattern.matches(ctlPattern, formula);
    }
}

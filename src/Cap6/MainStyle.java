package Cap6;

import java.util.EnumSet;

public class MainStyle {

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}


package Cap6;
import java.util.EnumSet;
import java.util.Set;

public class Text {

    public enum Font {
        ARIAL, TIMES_NEW_ROMAN, CALIBRI, COMIC_SANS, COURIER_NEW;
    }

    public enum Style {
        BOLD(0), ITALIC(1), UNDERLINE(0), STRIKETHROUGH(1);
        private final int bit;

        Style(int bit) {
            this.bit = bit;
        }

        public int getBit() {
            return bit;
        }
    }

    public void applyStyles(Set<Style> styles, Set<Font> fonts) {
        for (Style style : styles) {
            System.out.println(style + " - " + style.bit + " - " + fonts);
        }
    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC, Style.STRIKETHROUGH, Style.UNDERLINE), EnumSet.of(Font.ARIAL, Font.CALIBRI, Font.COURIER_NEW));
    }

}

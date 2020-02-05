import java.util.EnumSet;

public enum TextFieldFilterFlags {
    ALPHABETIC, DIGIT, SPECIAL;

    public static final EnumSet<TextFieldFilterFlags> ALL = EnumSet.allOf(TextFieldFilterFlags.class);


}

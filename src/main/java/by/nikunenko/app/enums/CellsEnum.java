package by.nikunenko.app.enums;

import java.util.Comparator;

public enum CellsEnum {

    NUMBER( 1, (x, y) -> Double.compare(Double.parseDouble((String) x), Double.parseDouble((String) y))),
    STRING( 2, (x, y) -> ((String) x).compareTo((String) y));
//    String.CASE_INSENSITIVE_ORDER.compare((String) x, (String) y)
//    ((String) x).compareTo((String) y)

    private int sequence;
    private Comparator comparator;

    CellsEnum(int sequence, Comparator comparator) {
        this.sequence = sequence;
        this.comparator = comparator;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public static CellsEnum getType(String str){
        try{
            Double.parseDouble(str.trim());
            return NUMBER;
        } catch (NumberFormatException e1){
            return STRING;
        }
    }

    public int compare(CellsEnum type){
        return Integer.compare(this.getSequence(), type.getSequence());
    }

}


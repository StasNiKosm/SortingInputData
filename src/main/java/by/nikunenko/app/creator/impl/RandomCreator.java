package by.nikunenko.app.creator.impl;

import by.nikunenko.app.enums.SeparatorsEnum;

public class RandomCreator extends AbstractCreator<String[]> {

    private int beginInt;
    private int endInt;
    private char beginChar;
    private char endChar;
    private int countChar;

    public RandomCreator(int columnCount, int linesCount) {
        super(columnCount, linesCount);
        this.beginInt = 0;
        this.endInt = 1001;
        this.beginChar = 'a';
        this.endChar = 'z'+1;
        this.countChar = 6;
    }

    public RandomCreator(int columnCount, int linesCount, int beginInt, int endInt, char beginChar, char endChar, int countChar) {
        super(columnCount, linesCount);
        this.beginInt = beginInt;
        this.endInt = endInt;
        this.beginChar = beginChar;
        this.endChar = endChar;
        this.countChar = countChar;
    }

    @Override
    public String[] create() {
        String[] lines = new String[this.linesCount];
        for (int i = 0; i < linesCount; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < columnCount; j++) {
                append(stringBuilder, j);
            }
            lines[i] = stringBuilder.toString();
        }
        return lines;
    }

    private void append(StringBuilder stringBuilder, int maxLineSize){
        int numberOrString = randomInt(0, 2);
        if(numberOrString == 0){
            stringBuilder.append(this.randomInt());
        } else {
            stringBuilder.append(this.randomString());
        }
        if(maxLineSize != columnCount-1){
            stringBuilder.append(SeparatorsEnum.COLUMN_SEPARATOR.getSeparator());
        }
    }

    private int randomInt(){
        return (int) ( Math.random() * (this.endInt - this.beginInt) ) + this.beginInt;
    }

    private int randomInt(int beginInt, int endInt){
        return (int) ( Math.random() * (endInt - beginInt) ) + beginInt;
    }

    private String randomString(){
        StringBuilder stringBuilder = new StringBuilder();
        int size = randomInt(0, this.countChar);
        for (int i = 0; i < size; i++) {
            stringBuilder.append(this.randomCharacter());
        }
        return stringBuilder.toString();
    }

    private char randomCharacter(){
        return (char) this.randomInt(beginChar, endChar);
    }

    public int getBeginInt() {
        return beginInt;
    }

    public void setBeginInt(int beginInt) {
        this.beginInt = beginInt;
    }

    public int getEndInt() {
        return endInt;
    }

    public void setEndInt(int endInt) {
        this.endInt = endInt;
    }

    public char getBeginChar() {
        return beginChar;
    }

    public void setBeginChar(char beginChar) {
        this.beginChar = beginChar;
    }

    public char getEndChar() {
        return endChar;
    }

    public void setEndChar(char endChar) {
        this.endChar = endChar;
    }

    public int getCountChar() {
        return countChar;
    }

    public void setCountChar(int countChar) {
        this.countChar = countChar;
    }
}

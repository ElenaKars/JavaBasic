package homework_31;


public enum Seasons {
    WINTER(new int[]{16, 15, 16}),
    SPRING(new int[]{18, 20, 24}),
    SUMMER(new int[]{28, 31, 31}),
    AUTUMN(new int[]{28, 23, 19});

//    private String month;
    private int [] temps;

    Seasons(int[] temps) {
        this.temps = temps;
    }

    public double averageTemp() {
        double sum = 0;
        for(int temp : temps){
            sum += temp;
        }
        return sum/temps.length;
    }
}






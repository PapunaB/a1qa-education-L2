package configurations;

public class Timer {

    public static String getTimeFormat (String time){
        String[] timeData = time.split(":");
        return timeData[0] + ":" + timeData[1];
    }
}

package Werewolf;

public class Timer {
    private long startTime;
    private long duration;

    public Timer(long duration) {
        this.duration = duration;
    }

    public void start() {
        startTime = System.currentTimeMillis(); // get the current system time in milliseconds
    }

    public boolean isExpired() {
        long elapsedTime = System.currentTimeMillis() - startTime; // calculate the elapsed time since start
        return elapsedTime >= duration; // return true if elapsed time is greater than or equal to the duration
    }
}

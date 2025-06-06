public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this(0, 0, 0);
    }

    public MyTime(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }


    public void setTime(int hour, int minute, int second) {
        if (isValid(hour, minute, second)) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            System.out.println("Yaroqsiz!");
        }
    }


    private boolean isValid(int hour, int minute, int second) {
        return (hour >= 0 && hour <= 23) &&
                (minute >= 0 && minute <= 59) &&
                (second >= 0 && second <= 59);
    }


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }


    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            System.out.println("Yaroqsiz soat!");
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            System.out.println("Yaroqsiz daqiqa!");
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            System.out.println("Yaroqsiz soniya!");
        }
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }


    public MyTime nextSecond() {
        second++;
        if (second > 59) {
            second = 0;
            nextMinute();
        }
        return this;
    }

    public MyTime nextMinute() {
        minute++;
        if (minute > 59) {
            minute = 0;
            nextHour();
        }
        return this;
    }

    public MyTime nextHour() {
        hour++;
        if (hour > 23) {
            hour = 0;
        }
        return this;
    }

    public MyTime previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            previousMinute();
        }
        return this;
    }

    public MyTime previousMinute() {
        minute--;
        if (minute < 0) {
            minute = 59;
            previousHour();
        }
        return this;
    }

    public MyTime previousHour() {
        hour--;
        if (hour < 0) {
            hour = 23;
        }
        return this;
    }
}
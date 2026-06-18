class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12)
        hour=0;
        double minuteAngle=minutes*6;
        double hourAngle=hour*30+minutes*0.5;
        double difference=Math.abs(hourAngle-minuteAngle);
        return Math.min(difference,360-difference);
    }
}

class Solution {
    int maxPeopleDefeated(int p) {
        int count = 0;
        int i = 1;

        while ((long)i * i <= p) {
            p -= i * i;
            count++;
            i++;
        }

        return count;
    }
}

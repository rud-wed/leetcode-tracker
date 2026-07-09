// Last updated: 7/9/2026, 10:23:57 AM
import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        Set<Integer> players = new HashSet<>();

        // Step 1: process matches
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            players.add(winner);
            players.add(loser);

            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        // Step 2: separate players
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : players) {
            int losses = lossCount.getOrDefault(player, 0);
            if (losses == 0) {
                zeroLoss.add(player);
            } else if (losses == 1) {
                oneLoss.add(player);
            }
        }

        // Step 3: sort results
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(zeroLoss);
        answer.add(oneLoss);

        return answer;
    }
}

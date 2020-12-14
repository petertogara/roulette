package com.playsafe.roullette.controller.core.context;

import static java.util.stream.Collectors.toMap;

@Component
public class GameResultClaculator {

        private static final double LOSING_MULTIPLIER = 0;

        private final Map<BetType, BetStrategy> betStrategyMap;

        public GameResultClaculator(List<BetStrategy> betStrategies) {
            this.betStrategyMap = betStrategies.stream()
                    .collect(toMap(BetStrategy::getType, identity()));
        }

        public List<PlayerResult> calculate(int number, Collection<PlayerBet> playerBets) {
            return playerBets.stream()
                    .map(bet -> calculateBet(number, bet))
                    .collect(toList());
        }

        private PlayerResult calculateBet(int number, PlayerBet playerBet) {
            String bet = playerBet.getBet();
            BetType betType = BetType.lookup(bet);
            Outcome outcome = getBetStrategy(betType).getOutcome(number, bet);
            double bettingSum = playerBet.getSum();
            double winnings = calculateWinnings(outcome, betType, bettingSum);
            return PlayerResult.builder()
                    .player(playerBet.getPlayer())
                    .bet(bet)
                    .winnings(winnings)
                    .outcome(outcome)
                    .bettingSum(bettingSum)
                    .build();
        }

        private double calculateWinnings(final Outcome outcome, final BetType betType, final double sum) {
            double multiplier = outcome == WIN ? betType.getMultiplier() : LOSING_MULTIPLIER;
            return multiplier * sum;
        }

        private BetStrategy getBetStrategy(BetType betType) {
            return ofNullable(betStrategyMap.get(betType)).orElseThrow(() ->
                    new IllegalArgumentException(format("Type[%s] is not supported.", betType)));
        }

    }

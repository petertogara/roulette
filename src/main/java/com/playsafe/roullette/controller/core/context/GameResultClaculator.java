package com.playsafe.roullette.controller.core.context;

import com.playsafe.roullette.controller.core.context.strategy.Strategy;
import com.playsafe.roullette.entity.BetType;
import com.playsafe.roullette.entity.PlayerBet;
import com.playsafe.roullette.entity.PlayerResult;
import com.playsafe.roullette.entity.Result;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.playsafe.roullette.entity.Result.WIN;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Component
public class GameResultClaculator {

        private static final double LOSING_MULTIPLIER = 0;

        private final Map<BetType, Strategy> strategyMap;

        public GameResultClaculator(List<Strategy> strategies) {
            this.strategyMap = strategies.stream()
                    .collect(toMap(Strategy::getType, identity()));
        }

        public List<PlayerResult> calculate(int number, Collection<PlayerBet> playerBets) {
            return playerBets.stream()
                    .map(bet -> calculateBet(number, bet))
                    .collect(toList());
        }

        private PlayerResult calculateBet(int number, PlayerBet playerBet) {
            String bet = playerBet.getBet();
            BetType betType = BetType.lookup(bet);
            Result result = getBetStrategy(betType).getResult(number, bet);
            double bettingSum = playerBet.getSum();
            double winnings = calculateWinnings(result, betType, bettingSum);
            return PlayerResult.builder
                    .player(playerBet.getPlayer())
                    .bet(bet)
                    .winnings(winnings)
                    .outcome(result)
                    .bettingSum(bettingSum)
                    .build();
        }

        private double calculateWinnings(final Result result, final BetType betType, final double sum) {
            double multiplier = result == WIN ? betType.getMultiplier() : LOSING_MULTIPLIER;
            return multiplier * sum;
        }

        private Strategy getBetStrategy(BetType betType) {
            return ofNullable(strategyMap.get(betType)).orElseThrow(() ->
                    new IllegalArgumentException(format("Type[%s] is not supported.", betType)));
        }

    }

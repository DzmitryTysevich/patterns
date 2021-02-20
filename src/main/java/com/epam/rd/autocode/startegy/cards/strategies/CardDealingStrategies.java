package com.epam.rd.autocode.startegy.cards.strategies;

import com.epam.rd.autocode.startegy.cards.CardDealingStrategy;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasHoldemCardDealingStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ClassicPokerCardDealingStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return new BridgeCardDealingStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        return new FoolCardDealingStrategy();
    }
}
package com.epam.rd.autocode.startegy.cards.strategies;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.CardDealingStrategy;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.*;

public class BridgeCardDealingStrategy implements CardDealingStrategy {
    private final String string = "Player ";
    private Map<String, List<Card>> stack;
    private final int playerAmountCard = 13;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        stack = new TreeMap<>();
        addPlayerWithCards(deck, players);
        return stack;
    }

    private void addPlayerWithCards(Deck deck, int players) {
        List<Card> cards = getCardsForPlayers(deck, players);
        for (int playerIndex = 0, mapIndex = 1; playerIndex < players; playerIndex++, mapIndex++) {
            List<Card> playerCards = getPlayerCards(cards, playerIndex, players);
            stack.put(string + mapIndex, playerCards);
        }
    }

    private List<Card> getPlayerCards(List<Card> cards, int playerIndex, int players) {
        List<Card> playerCards = new ArrayList<>();
        for (int cardIndex = playerIndex, index = 0; cardIndex < cards.size(); cardIndex += players, index++)
            playerCards.add(cards.get(playerIndex + players * index));
        return playerCards;
    }

    private List<Card> getCardsForPlayers(Deck deck, int players) {
        List<Card> cards = new LinkedList<>();
        for (int i = 0; i < players * playerAmountCard; i++) cards.add(deck.dealCard());
        return cards;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
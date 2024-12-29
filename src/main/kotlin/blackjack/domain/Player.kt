package blackjack.domain

import blackjack.domain.type.TrumpCard

class Player(val name: String, val cards: ArrayList<TrumpCard> = ArrayList(), val score: Score = Score()) {

    fun canReceiveCard(): Boolean {
        return this.score.canReceiveCard()
    }

    fun receiveCard(card: TrumpCard) {
        this.cards.add(card)
        card.plusBaseValue(score)
    }

    fun getTotalScore(): Score {
        return TrumpCard.getTotalScore(this.cards, this.score)
    }

    fun getCardNames(): List<String> {
        return this.cards.stream()
            .map { card -> card.getFullName() }
            .toList()
    }
}

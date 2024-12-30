package blackjack.domain

const val SCORE_LIMIT: Int = 16

class Dealer(name: String = "딜러") : Member(name, ArrayList(), Score.from(0)) {
    override fun canReceiveCard(): Boolean {
        return this.score.canReceiveCard(SCORE_LIMIT) && this.cards.size <= CARD_LIMIT;
    }

    override fun isDealer(): Boolean {
        return true
    }

    companion object {
        private const val CARD_LIMIT : Int = 3
    }
}

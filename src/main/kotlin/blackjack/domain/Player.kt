package blackjack.domain

class Player(name: String) : Member(name, ArrayList(), Score.from(0)) {
    override fun canReceiveCard(): Boolean {
        return this.score.canReceiveCard(SCORE_LIMIT)
    }

    override fun isDealer(): Boolean {
        return false
    }

    companion object {
        private const val SCORE_LIMIT: Int = 21
    }
}

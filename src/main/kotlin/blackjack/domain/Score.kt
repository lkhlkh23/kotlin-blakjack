package blackjack.domain

class Score constructor(var score: Int) {
    companion object {
        @JvmStatic
        private val SCORE_LIMIT: Int = 21
    }

    fun canReceiveCard(): Boolean {
        return this.score < SCORE_LIMIT
    }

    fun plusScore(score: Int) {
        this.score += score
    }

    fun plusScoreIfLessLimit(score: Int) {
        if (this.score + score <= SCORE_LIMIT) {
            this.score += score
        }
    }
}

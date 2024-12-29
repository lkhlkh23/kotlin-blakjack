package blackjack.domain

class Score (score: Int = 0) {
    var score: Int = score
        private set

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

    companion object {
        private const val SCORE_LIMIT: Int = 21
    }
}

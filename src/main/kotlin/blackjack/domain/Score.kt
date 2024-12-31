package blackjack.domain

class Score private constructor(val score: Int = 0) {
    fun canReceiveCard(limit: Int): Boolean {
        return this.score < limit
    }

    fun plusScore(score: Int): Score {
        return Score(this.score + score)
    }

    fun plusScoreIfLessLimit(score: Int): Score {
        if (this.score + score <= SCORE_LIMIT) {
            return Score(this.score + score)
        }

        return this
    }

    fun isExceedLimit(): Boolean {
        return this.score > SCORE_LIMIT
    }

    fun isCloserLimit(score: Score) : Boolean {
        return SCORE_LIMIT - this.score < SCORE_LIMIT - score.score
    }

    companion object {
        private const val SCORE_LIMIT: Int = 21

        fun from(score: Int = 0): Score {
            return Score(score)
        }
    }
}

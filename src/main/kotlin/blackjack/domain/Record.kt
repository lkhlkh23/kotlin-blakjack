package blackjack.domain

class Record(val win: Int = 0, val loss: Int = 0, val draw: Int = 0) {
    fun calculate(
        origin: Score,
        comparison: Score,
    ): Record {
        if (origin.isExceedLimit() && comparison.isExceedLimit()) {
            return Record(this.win, this.loss, this.draw + 1)
        }

        if (origin.isExceedLimit() && !comparison.isExceedLimit()) {
            return Record(this.win, this.loss + 1, this.draw)
        }

        if (!origin.isExceedLimit() && comparison.isExceedLimit()) {
            return Record(this.win + 1, this.loss, this.draw)
        }

        if (origin == comparison) {
            return Record(this.win, this.loss, this.draw + 1)
        }

        if (origin.isCloserLimit(comparison)) {
            return Record(this.win + 1, this.loss, this.draw)
        }

        return Record(this.win, this.loss + 1, this.draw)
    }

    fun getRecord(): String {
        val sb = StringBuilder()
        if (this.win != 0) {
            sb.append("${this.win}승 ")
        }

        if (this.draw != 0) {
            sb.append("${this.draw}무 ")
        }

        if (this.loss != 0) {
            sb.append("${this.loss}패")
        }

        return sb.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Record

        if (win != other.win) return false
        if (loss != other.loss) return false
        if (draw != other.draw) return false

        return true
    }
}

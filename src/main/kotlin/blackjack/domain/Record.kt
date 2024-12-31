package blackjack.domain

class Record(val win:Int = 0, val loss:Int = 0, val draw:Int = 0) {

    fun calculate(origin: Score, comparison: Score) : Record {
        if (origin.isExceedLimit() && comparison.isExceedLimit()) {
            return Record(this.win, this.loss, this.draw + 1)
        }

        if (origin.isExceedLimit() && !origin.isExceedLimit()) {
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

    fun getRecord() : String {
        return "${this.win}승 ${this.draw}무 ${this.loss}패"
    }

}
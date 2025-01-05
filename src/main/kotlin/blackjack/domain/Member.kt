package blackjack.domain

import blackjack.domain.type.MemberType
import blackjack.domain.type.TrumpCard

class Member(
    val name: String,
    val type: MemberType,
    val cards: Cards = Cards(),
    score: Score =
        Score.from(
            0,
        ),
) {
    var score: Score = score
        private set

    fun canReceiveCard(): Boolean {
        return this.score.canReceiveCard(type.drawableLimit)
    }

    fun isDealer(): Boolean {
        return type == MemberType.DEALER
    }

    fun receiveCard(card: TrumpCard) {
        this.cards.add(card)
        this.score = card.plusBaseValue(score)
    }

    fun getTotalScore(): Score {
        return this.cards.getTotalScore(this.score)
    }

    fun getCardNames(): List<String> {
        return this.cards.getCardNames()
    }

    fun getCardNames(count: Int): List<String> {
        return getCardNames().subList(0, count)
    }

    fun getRecord(members: List<Member>): String {
        var record = Record()
        for (member in members) {
            if (member.type == this.type) {
                continue
            }

            record = record.calculate(this.getTotalScore(), member.getTotalScore())
        }

        return record.getRecord()
    }
}

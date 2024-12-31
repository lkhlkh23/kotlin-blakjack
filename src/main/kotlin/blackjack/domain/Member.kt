package blackjack.domain

import blackjack.domain.type.MemberType
import blackjack.domain.type.TrumpCard

class Member(val name : String, val type: MemberType, private val cards : MutableList<TrumpCard> = ArrayList(), score : Score = Score.from(0)) {

    var score: Score = score
        private set

    fun canReceiveCard(): Boolean {
        return this.score.canReceiveCard(type.drawable)
    }

    fun isDealer(): Boolean {
        return type == MemberType.DEALER;
    }

    fun receiveCard(card: TrumpCard) {
        this.cards.add(card)
        this.score = card.plusBaseValue(score)
    }

    fun getTotalScore(): Score {
        return TrumpCard.getTotalScore(this.cards, this.score)
    }

    fun getCardNames(): List<String> {
        return this.cards.stream()
            .map { card -> card.getFullName() }
            .toList()
    }

    fun getCardNames(count: Int): List<String> {
        return getCardNames().subList(0, count);
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

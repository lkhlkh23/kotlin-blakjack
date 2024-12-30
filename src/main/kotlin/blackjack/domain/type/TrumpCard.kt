package blackjack.domain.type

import blackjack.domain.Score

enum class TrumpCard constructor(private val shape: String, private val letter: String, private val number: Int, private val bonus: Int) {
    HEART_2("하트", "2", 2, 0),
    HEART_3("하트", "3", 3, 0),
    HEART_4("하트", "4", 4, 0),
    HEART_5("하트", "5", 5, 0),
    HEART_6("하트", "6", 6, 0),
    HEART_7("하트", "7", 7, 0),
    HEART_8("하트", "8", 8, 0),
    HEART_9("하트", "9", 9, 0),
    HEART_10("하트", "10", 10, 0),
    HEART_ACE("하트", "A", 1, 10),
    HEART_QUEEN("하트", "Q", 10, 0),
    HEART_JACK("하트", "J", 10, 0),
    HEART_KING("하트", "K", 10, 0),
    DIAMOND_2("다이아몬드", "2", 2, 0),
    DIAMOND_3("다이아몬드", "3", 3, 0),
    DIAMOND_4("다이아몬드", "4", 4, 0),
    DIAMOND_5("다이아몬드", "5", 5, 0),
    DIAMOND_6("다이아몬드", "6", 6, 0),
    DIAMOND_7("다이아몬드", "7", 7, 0),
    DIAMOND_8("다이아몬드", "8", 8, 0),
    DIAMOND_9("다이아몬드", "9", 9, 0),
    DIAMOND_10("다이아몬드", "10", 10, 0),
    DIAMOND_ACE("다이아몬드", "A", 1, 10),
    DIAMOND_QUEEN("다이아몬드", "Q", 10, 0),
    DIAMOND_JACK("다이아몬드", "J", 10, 0),
    DIAMOND_KING("다이아몬드", "K", 10, 0),
    SPADE_2("스페이드", "2", 2, 0),
    SPADE_3("스페이드", "3", 3, 0),
    SPADE_4("스페이드", "4", 4, 0),
    SPADE_5("스페이드", "5", 5, 0),
    SPADE_6("스페이드", "6", 6, 0),
    SPADE_7("스페이드", "7", 7, 0),
    SPADE_8("스페이드", "8", 8, 0),
    SPADE_9("스페이드", "9", 9, 0),
    SPADE_10("스페이드", "10", 10, 0),
    SPADE_ACE("스페이드", "A", 1, 10),
    SPADE_QUEEN("스페이드", "Q", 10, 0),
    SPADE_JACK("스페이드", "J", 10, 0),
    SPADE_KING("스페이드", "K", 10, 0),
    CLUB_2("클로바", "2", 2, 0),
    CLUB_3("클로바", "3", 3, 0),
    CLUB_4("클로바", "4", 4, 0),
    CLUB_5("클로바", "5", 5, 0),
    CLUB_6("클로바", "6", 6, 0),
    CLUB_7("클로바", "7", 7, 0),
    CLUB_8("클로바", "8", 8, 0),
    CLUB_9("클로바", "9", 9, 0),
    CLUB_10("클로바", "10", 10, 0),
    CLUB_ACE("클로바", "A", 1, 10),
    CLUB_QUEEN("클로바", "Q", 10, 0),
    CLUB_JACK("클로바", "J", 10, 0),
    CLUB_KING("클로바", "K", 10, 0),
    ;

    fun plusBaseValue(score: Score): Score {
        return score.plusScore(this.number)
    }

    fun getFullName(): String {
        return this.letter + this.shape
    }

    companion object {
        fun getTotalScore(
            cards: List<TrumpCard>,
            score: Score,
        ): Score {
            return cards.fold(score) { acc, card -> acc.plusScoreIfLessLimit(card.bonus) }
        }
    }
}

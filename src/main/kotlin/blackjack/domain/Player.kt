package blackjack.domain

import blackjack.domain.type.TrumpCard

class Player constructor(val name: String, val cards: List<TrumpCard>, val score: Int)

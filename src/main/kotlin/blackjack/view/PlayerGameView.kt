package blackjack.view

import blackjack.domain.Deck
import blackjack.domain.Member

object PlayerGameView {
    fun play(
        members: List<Member>,
        deck: Deck,
    ) {
        for (member in members) {
            playTurns(member, deck)
        }
    }

    private fun playTurns(member: Member,
                          deck: Deck) {
        while (isPlay(member)) {
            playTurn(member, deck)
        }
    }

    private fun isPlay(member: Member): Boolean {
        val canReceive = member.canReceiveCard()
        if (!canReceive) {
            return false
        }

        println("${member.name} 는 한장의 카드를 더 받겠습니까? (예 : y, 아니오 : n)")
        val choice: String = readlnOrNull() ?: ""
        return choice == "y"
    }

    private fun playTurn(
        player: Member,
        deck: Deck,
    ): Boolean {
        player.receiveCard(deck.draw())
        val cards = player.getCardNames().joinToString(",")
        println("${player.name} : $cards")

        return true
    }
}

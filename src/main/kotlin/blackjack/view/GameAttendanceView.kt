package blackjack.view

import blackjack.domain.Player
import blackjack.domain.Score

class GameAttendanceView {
    companion object {
        @JvmStatic
        fun getPlayers(): List<Player> {
            println("게임에 참여할 사람의 이름을 입력하세요. (쉼표, 기준으로 분리)")
            val inputs: String = readLine() ?: ""

            return inputs.split(",")
                .stream()
                .map { input -> Player(input, ArrayList(), Score(0)) }
                .toList()
        }
    }
}

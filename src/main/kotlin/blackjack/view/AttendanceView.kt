package blackjack.view

import blackjack.domain.Member
import blackjack.domain.type.MemberType

fun getPlayers(): List<Member> {
    println("게임에 참여할 사람의 이름을 입력하세요. (쉼표, 기준으로 분리)")
    val inputs: String = readLine() ?: ""

    return inputs.split(",")
        .stream()
        .map { input -> Member(input, MemberType.PLAYER) }
        .toList()
}

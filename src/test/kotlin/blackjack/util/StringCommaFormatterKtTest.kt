package blackjack.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCommaFormatterKtTest {
    @Test
    fun `test_format_빈리스트일경우 예외 발생`() {
        assertThrows<IllegalArgumentException> { format(listOf()) }
    }

    @Test
    fun `test_format_빈리스트가 아닐경우, 문자열 콤마로 연결`() {
        assertThat(format(listOf("1", "2"))).isEqualTo("1,2")
    }
}

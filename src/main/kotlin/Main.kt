import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val dateTime = LocalDateTime.parse(
        "4714-11-24 00:00:00 BC",
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss G", java.util.Locale.ROOT)
    )

    print(dateTime.toString())
}
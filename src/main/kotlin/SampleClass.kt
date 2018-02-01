import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable


@Serializable
data class SomeDataClass(
        val x: String? = "Test",

        @Optional
        val y: String? = "Class"
)

import kotlinx.serialization.Serializable


@Serializable
abstract class AbstractConstantField {

    abstract val type: String
    var superVariable = "super text"
}

@Serializable
class ConstantField : AbstractConstantField() {

    override val type: String = "Constant"
    var variable: String? = "some text"
}

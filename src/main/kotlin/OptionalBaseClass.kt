import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable


@Serializable
abstract class OptionalBaseClass {

    @Optional
    var optional: String? = null
}

@Serializable
class OptionalDerivedClass : OptionalBaseClass() {

}

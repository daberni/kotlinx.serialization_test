import kotlinx.serialization.Serializable

@Serializable
abstract class Base {

    var nullable: String? = null
}

@Serializable
class Derived : Base() {

    var property: String = "Property Value"
}

import kotlinx.serialization.Serializable

@Serializable
class WrongPropertyListOrderClass {

    var someList: List<String> = emptyList()
    val someProperty = "Value"
}


@Serializable
class CorrectPropertyListOrderClass {

    val someProperty = "Value"
    var someList: List<String> = emptyList()
}


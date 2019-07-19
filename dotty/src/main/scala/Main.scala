object Main {

  def main(args: Array[String]): Unit = {

    import vo._
    val у1 = Утверждение(None, Map(Вопрос("где") -> Some(Ответ("низ"))))
    val у2 = Утверждение(None, Map(Вопрос("кто") -> Some(Ответ("собака"))))
    val у3 = Утверждение(None, Map(Вопрос("когда") -> Some(Ответ("ночь"))))
    val у4 = Утверждение(None, Map(Вопрос("зачем") -> None))
    val у = Утверждение(Some(Действие("лаять")))
    
    println(у)
    println(у + у1 + у2 + у3)
    println(у + у1 + у2 + у4)
    println(у + у1 + у2 - у1)
    println(у - у)
    println(у1 - (у + у1 + у2))

  }
}

package vo

case class Description(
  question: Option[Question] = None,
  answer: Option[Answer] = None,
  descriptions: List[Description] = List.empty
) {
  def +(otherDescription: Description): Description = otherDescription match {
    // both empty
    case Description(None, None, Nil) 
      if question == None && answer == None && descriptions == Nil 
        => this
    // other empty, this non-empty
    case Description(None, None, Nil) 
      if question != None || answer != None || descriptions != Nil 
        => this
    // other non-empty, this empty
    case Description(Some(_) | None, Some(_) | None, List(_) | Nil) 
      if question == None && answer == None && descriptions == Nil 
        => otherDescription
    // both non-empty, same content
    case Description(Some(otherQuestion), Some(otherAnswer), otherDescription) 
      if question == otherQuestion && answer == otherAnswer && descriptions == otherDescription
        => this
    // both non-empty, same question and answer, different descriptions
    case Description(Some(otherQuestion), Some(otherAnswer), otherDescriptions)
      if question == otherQuestion && answer == otherAnswer && descriptions != otherDescriptions
        => Description(
          question,
          answer,
          otherDescriptions ::: descriptions
        )
    case _ => this
  }
}

case class Question(words: String) {

}

case class Answer(words: String) {

}


//
//class Предложение {
//  val подлежащие: List[Подлежащее] = List()
//  val сказуемые: List[Сказуемое] = List()
//
//  def map(f: ЧленПредложения => ЧленПредложения): Предложение = {
//    подлежащие.map(f)
//    сказуемые.map(f)
//    this
//  }
//}
//
//trait ЧленПредложения {
//
//}
//
//class Подлежащее extends ЧленПредложения {
//  def map(f: ЧленПредложения => ЧленПредложения): Предложение = {
//    подлежащие.map(f)
//    сказуемые.map(f)
//    this
//  }
//}
//
//class Сказуемое extends ЧленПредложения {
//  def map(f: ЧленПредложения => ЧленПредложения): Предложение = {
//    подлежащие.map(f)
//    сказуемые.map(f)
//    this
//  }
//}
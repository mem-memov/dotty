object Main {

  def main(args: Array[String]): Unit = {

    import vo._

    val empty = Description()
    val consist = Description(Some(Question("what do")), Some(Answer("consist")));    
    val map = Description(Some(Question("what")), Some(Answer("map")));

    val sentence =  empty + map

    println(sentence)
  }
}

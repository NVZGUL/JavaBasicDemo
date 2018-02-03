object SuperHeroes {
  def main(args: Array[String]): Unit = {
    // immutable
    val numbers = for(i <- 1 to 10) yield i *2
    println(numbers)
    println("Hello world")

    val superman = new SuperHero("Superman", "Clark Kent", "Krypton", 'M')

    val superheroes = Array("Spiderman", "Green Arrow", "Batman")
    superheroes.foreach(println)

  }
}

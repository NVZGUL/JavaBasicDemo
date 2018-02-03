class SuperHero(val name: String, val nickname: String, val birthPlace: String,
                val gender: Char) {
  printf("A new hero was created %s", name)

  def this(name: String) {
    this(name, "","", ' ')
  }

  def this(name: String, birthPlace: String){
    this(name,"", birthPlace,' ')
  }



  def details() = {
    printf("%s was born in %s", name, birthPlace)
  }

  var heroAge = 0

  def age = heroAge
  def age_=(newAge: Int): Unit = {
    if (newAge > heroAge)
      heroAge = newAge
    else
      heroAge
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[SuperHero]

  override def equals(other: Any): Boolean = other match {
    case that: SuperHero =>
      (that canEqual this) &&
        name == that.name &&
        nickname == that.nickname &&
        birthPlace == that.birthPlace &&
        gender == that.gender
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, nickname, birthPlace, gender)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

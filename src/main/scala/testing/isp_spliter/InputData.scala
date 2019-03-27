package testing.isp_spliter

case class InputData(ip: String,
                     date: String,
                     city: String,
                     country: String,
                     url: String,
                     dob: String,
                     zip: String,
                     address2: String,
                     lastName: String,
                     gender: String,
                     firstName: String,
                     address1: String,
                     email: String,
                     createDate: String,
                     importDate: String) {
  lazy val isp: Isp = Isp.getIsp(email.split('@').last)

  def toCsv: List[String] = this.productIterator.map(_.toString).toList

  def toOutputData: OutputData = OutputData(
    email, country, ip, "", gender, firstName, lastName, address1, address2, city, zip, dob, "", "", url, date)
}

object InputData {
  def fromStrList(strs: List[String]): Option[InputData] =
    Some(strs).filter(_.size == 15).map(list => InputData(list(0), list(1), list(2), list(3), list(4), list(5),
      list(6), list(7), list(8), list(9), list(10), list(11), list(12).replace("\\", ""), list(13), list(14)))
}
package testing.isp_spliter

  case class OutputData(email: String,
                        country: String,
                        optIp: String,
                        providerName: String,
                        gender: String,
                        firstName: String,
                        lastName: String,
                        address1: String,
                        address2: String,
                        state: String,
                        postalCode: String,
                        dateOfBirth: String,
                        mobilePhone: String,
                        homePhone: String,
                        optSourceUrl: String,
                        optDateTime: String){
    def toCsv: List[String] = this.productIterator.map(_.toString).toList
  }
package testing.isp_spliter

sealed trait Isp

object Isp {
  case object Google extends Isp
  case object Internal extends Isp
  case object Yahoo extends Isp
  case object Hotmail extends Isp
  case object Cables extends Isp
  case object Aol extends Isp
  case object Other extends Isp

  val gmailDomains = List("googlemail.com", "gmail.com")
  val internalDomains = List("mailportal.us")
  val yahooDomains = List("yahoo.com", "yahoo.ca", "yahoo.fr", "y7mail.com", "yahoo.co.in", "yahoo.es", "ymail.com", "yahoo.in", "rocketmail.com", "yahoo.co.uk", "sky.com", "yahoo.cl", "yahoo.co.jp", "yahoo.co.th", "yahoo.com.co", "yahoo.com.my", "yahoo.com.tr", "yahoo.com.ve", "yahoo.com.vn", "yahoo.nl", "yahoo.no", "yahoo.pl", "yahoo.ro", "yahoo.com.br", "yahoo.com.ar", "yahoo.com.cn", "yahoo.com.mx", "yahoo.co.kr", "yahoo.co.nz", "yahoo.com.hk", "yahoo.com.sg", "yahoo.gr", "yahoo.de", "yahoo.com.ph", "yahoo.com.tw", "yahoo.dk", "yahoo.ie", "yahoo.it", "yahoo.se", "yahoo.com.au", "yahoo.co._id", "", "bakuoilservices.com", "bbh-systems.com", "book-tokyo.com", "madselectronics.com", "nl.rogers.com", "odosupo.com", "rogers.com", "tracygirdler.com", "ybb.ne.jp")
  val hotmailDomains = List("outlook.com", "live.co.uk", "live.com", "hotmail.fr", "hotmail.co.uk", "hotmail.de", "hotmail.es", "live.ca", "msn.com", "hotmail.com", "hotmail.it", "windowslive.com", "live.fr", "live.it", "hotmail.co.jp", "live.com.mx", "live.nl", "live.de", "live.cn", "live.ru", "live.com.ar", "hotmail.co.th", "live.com.au", "live.jp", "live.se", "live.cl", "live.com.pt", "live.be", "live.dk", "hotmail.com.tr", "livemail.tw", "live.no", "hotmail.se", "hotmail.com.tw", "live.co.kr", "hotmail.co.nz", "live.at", "live.in", "hotmail.gr", "hotmail.be", "live.hk", "live.ie", "msn.cn", "hotmail.co.kr", "hotmail.no", "hotmail.ch", "live.co.za", "hotmail.com.hk", "live.com.my", "live.com.sg", "hotmail.fi", "hotmail.my", "hotmail.co._id", "hotmail.sg", "hotmail.com.au", "hotmail.co.za", "hotmail.dk", "hotmail.rs", "live.com.ph", "hotmail.ph", "hotmail.com.vn", "hotmail.cz")
  val cablesDomains = List("mgw.rr.com", "bizlaredo.rr.com", "mi.rr.com", "southeast.rr.com", "bizmaa.rr.com", "btopenworld.com", "btinternet.com", "nvbell.net", "tampabay.rr.com", "wans.net", "swfla.rr.com", "bizec.rr.com", "bizla.rr.com", "ipmt.rr.com", "icloud.com", "wfbiz.rr.com", "elp.rr.com", "stx.rr.com", "tx.rr.com", "ma.rr.com", "central.rr.com", "netzero.net", "ntlworld.com", "pacbell.net", "mass.rr.com", "newbc.rr.com", "cox.net", "centurylink.net", "austin.rr.com", "bizrgv.rr.com", "bizwi.rr.com", "nyc.rr.com", "facebook.com", "bizsw.rr.com", "ohiordc.rr.com", "carolina.rr.com", "woh.rr.com", "hvc.rr.com", "comcast.net", "nc.rr.com", "verizon.net", "maine.rr.com", "indy.biz.rr.com", "eufaula.rr.com", "texas.rr.com", "games.com", "columbus.rr.com", "nycap.rr.com", "wow.com", "bizcinci.rr.com", "sbcglobal.net", "virginmedia.com", "ipcontrol-b.rr.com", "kc.rr.com", "biz.rr.com", "socal.rr.com", "optimum.net", "charter.net", "ec.rr.com", "suddenlink.net", "tampflrdc.rr.com", "mac.com", "san.rr.com", "triadbiz.rr.com", "ops.rr.com", "rgv.rr.com", "juno.com", "sc.rr.com", "adelphia.net", "twc.com", "coxmail.com", "triad.rr.com", "cfl.rr.com", "libertybiz.rr.com", "nss.rr.com", "ameritech.net", "we.rr.com", "bizbak.rr.com", "ygm.com", "love.com", "indy.rr.com", "neb.rr.com", "mail.rr.com", "wi.rr.com", "neo.rr.com", "twmi.rr.com", "nj.rr.com", "bizse.rr.com", "sw.rr.com", "rdc-nyc.rr.com", "oh.rr.com", "panhandle.rr.com", "ca.rr.com", "att.net", "roadrunner.com", "nebbiz.rr.com", "earthlink.net", "snet.net", "biztwmi.rr.com", "netzero.com", "ne.rr.com", "talk21.com", "bellsouth.net", "new.rr.com", "hot.rr.com", "gt.rr.com", "dc.rr.com", "blueyonder.co.uk", "stny.rr.com", "me.com", "twcny.rr.com", "bizstx.rr.com", "gte.net", "bak.rr.com", "swbell.net", "bizsatx.rr.com", "elmore.rr.com", "cinci.rr.com", "flash.net", "bellatlantic.net", "satx.rr.com", "btconnect.com", "berkshire.rr.com", "nyroc.rr.com", "bizwoh.rr.com", "virgin.net", "prodigy.net", "ipcontrol.rr.com", "rochester.rr.com", "houston.rr.com", "insight.rr.com", "hvcbiz.rr.com", "si.rr.com", "bizaustin.rr.com", "hawaii.rr.com", "centexbiz.rr.com", "pa.rr.com", "bham.rr.com", "q.com", "ameritrade.com", "windstream.net", "embarqmail.com", "centurylink.com", "optonline.net", "mail.com", "icould.com", "runbox.com", "cox.com")
  val aolDomains = List("aim.com", "aol.com", "netscape.net", "cs.com", "aol.co.uk", "netscape.com", "wmconnect.com", "icqmail.com")

  val isps = List(Google, Internal, Yahoo, Hotmail, Cables, Aol, Other)

  def getIsp(domain: String): Isp = domain match {
    case _ if gmailDomains.contains(domain) => Google
    case _ if internalDomains.contains(domain) => Internal
    case _ if yahooDomains.contains(domain) => Yahoo
    case _ if hotmailDomains.contains(domain) => Hotmail
    case _ if cablesDomains.contains(domain) => Cables
    case _ if aolDomains.contains(domain) => Aol
    case _ => Other
  }
}


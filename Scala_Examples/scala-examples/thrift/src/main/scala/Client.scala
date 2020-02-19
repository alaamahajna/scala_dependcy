import org.apache.thrift._
import org.apache.thrift.protocol._
import org.apache.thrift.server._
import org.apache.thrift.transport._

object Client {
  def main(args: Array[String]): Unit = {
    val transport = new TSocket("localhost", 8080)
    val protocol = new TBinaryProtocol(transport)
    // サーバに接続
    transport.open()
    val foo = new Foo.Client(protocol)

    try {
      println("[Client] call foo.bar()")
      // サービス呼び出し
      val res = foo.bar("Hello Thrift")
      println("[Client] result: %s".format(res))
    } catch {
      case e:FooException => {
        e.printStackTrace
      }
    }
  }
}

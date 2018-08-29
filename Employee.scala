import scala.io.Source
import java.io.File
import java.io.PrintWriter

object Employee{

  def main(args: Array[String]) = {
   val employeeName = args(0)
   val employeePay = args(1)
   val leftJoinResult = args(2)

   var value : Map[String, String] = Map()

   // Reading EmployeePay file and storing it in Map
   for (line <- Source.fromFile(employeePay).getLines) {
       val data = line.split(",",2)
       value += (data(0) -> data(1))
   }

   //Creating the output files

   val resultFile = new PrintWriter(new File(leftJoinResult))

   //Read employeeName file, match it with id and write the result into the output file
   for (line <- Source.fromFile(employeeName) .getLines) {
       val data = line.split(",",2)
       if( value.contains( data(0) )) {
         resultFile.write(line + "," + value(data(0))+ "\n")
       }
       else{
         resultFile.write(line + ",," + "\n")
       }
   }
   resultFile.close()
 }
}

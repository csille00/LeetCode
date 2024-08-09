package array_string

fun main(){
    println(convert("A", 1))
}
//PAHNAPLSIIGYIR

fun convert(s: String, numRows: Int): String {
    val cycle = 2 * numRows - 2
    val result = StringBuilder()
    var row = 0
    while(result.length < s.length){
        var counter = row
        if(row == 0 || row == numRows - 1) {
            while (counter < s.length) {
                result.append(s[counter])
                counter += cycle
            }
        } else {
            var offset = cycle - row
            while(counter < s.length){
                result.append(s[counter])
                if(offset < s.length) result.append(s[offset])
                counter += cycle
                offset += cycle
            }
        }
        row++
    }
    return result.toString()
}
import Foundation

print("Write a day (1 - 31) : ")
var dayStr = readLine()!

let lastFullMoon: Int = 27
let step: Int = 29
let monthSize = 31
var nextFullMoon: Int = (lastFullMoon + step) - monthSize


let day = Int.init(dayStr)!
print("Nearest full moon is ")
if ( abs(day - nextFullMoon) > day + (monthSize - lastFullMoon) ) {
    print(lastFullMoon, "august!")
} else {
    print(nextFullMoon, "september!")
}

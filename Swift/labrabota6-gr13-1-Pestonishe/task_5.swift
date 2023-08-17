import Foundation

let str = readLine()!
let strings = str.components(separatedBy: " ")
var g = strings.count
var mas = [String]()
for i in 0...g-1 {
    if strings[i] != "" {
        mas.append(strings[i])
    }
}
print(mas[mas.count-2])

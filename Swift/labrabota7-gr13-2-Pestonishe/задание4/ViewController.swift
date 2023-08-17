import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    
    @IBOutlet weak var button: UIButton!
  
    @IBOutlet weak var second: UITextField!
    
    @IBOutlet weak var minute: UITextField!
    
    @IBOutlet weak var hour: UITextField!
    
    @IBOutlet weak var month: UITextField!
    
    @IBOutlet weak var answerSec: UILabel!
    
    @IBOutlet weak var year: UITextField!
    
    @IBOutlet weak var day: UITextField!
    
    @IBOutlet weak var answerDay: UILabel!
    
    @IBOutlet weak var answerMin: UILabel!
    
    @IBOutlet weak var checkData: UILabel!
    
    @IBAction func buttonTapped(_ sender: UIButton) {
        let sec = Int(second.text ?? "0")!
        let min = Int(minute.text ?? "0")!
        let h = Int(hour.text ?? "0")!
        let mon = Int(month.text ?? "0")!
        _ = Int(year.text ?? "0")!
        let d = Int(day.text ?? "0")!
        if sec <= 60 && sec >= 0 && min <= 60 && min >= 0 && h <= 24 && h >= 0 &&
            mon <= 12 && mon >= 1 && d <= 31 && d >= 1
        {
            let secAnswer = (min * 60 + sec)
            let minAnswer = (h * 60 + min)
            let dayF = DateComponents(month: 1, day: 1, hour: h )
            let dayS = DateComponents(month: mon, day: d, hour: h)
            let dayFirst = Calendar.current.date(from: dayF)
            let daySecond = Calendar.current.date(from: dayS)
            let dayAnswer = (daySecond?.timeIntervalSince(dayFirst!))!/60/60/24
            answerDay.text = String(Int(dayAnswer))
            answerMin.text = String(minAnswer)
            answerSec.text = String(secAnswer)
            checkData.text = ""
        }
        else
        {
            checkData.text = "Данные не верны!"
        }
        
    }
    

}


import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var ageTextField: UITextField!
    @IBOutlet weak var heightTextField: UITextField!
    @IBOutlet weak var weightTextField: UITextField!
    @IBOutlet weak var sexSegmentControl: UISegmentedControl!
    @IBOutlet weak var activitySegmentControl: UISegmentedControl!
    @IBOutlet weak var resultLabel: UILabel!
    
    @IBAction func calculateTapped(_ sender: Any) {
        var a: Double, b: Double, c: Double, d: Double
    
        switch sexSegmentControl.selectedSegmentIndex {
            case 0:
                a = 88.36
                b = 13.4
                c = 4.8
                d = 5.7
            case 1:
                a = 447.6
                b = 9.2
                c = 3.1
                d = 4.3
            default:
                a = 88.36
                b = 13.4
                c = 4.8
                d = 5.7
        }
        
        var weight = Double.init(weightTextField.text!)!
        var height = Double.init(heightTextField.text!)!
        var age = Double.init(ageTextField.text!)!
        var BMR = a + b * weight + c * height + d * age
        
        switch activitySegmentControl.selectedSegmentIndex {
            case 0:
                BMR *= 1.2
            case 1:
                BMR *= 1.375
            case 2:
                BMR *= 1.55
            case 3:
                BMR *= 1.725
            default:
                BMR *= 1
        }
        
        resultLabel.text = "Appropriate amount of calories for you is " + String.init(BMR)
            
        
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
}


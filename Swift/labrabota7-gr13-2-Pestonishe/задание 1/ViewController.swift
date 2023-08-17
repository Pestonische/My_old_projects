import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        switchIndicator.textColor = UIColor.white
        switchIndicator.text = "BUDA"
        view.backgroundColor = UIColor(patternImage: UIImage(named: "bg1")!)
    }

    @IBOutlet weak var backgroundSwitch: UISwitch!
    
    @IBOutlet weak var switchIndicator: UILabel!
    
    @IBAction func backgroundSwitchTapped(_ sender: Any) {
        if backgroundSwitch.isOn {
             switchIndicator.text = "BUDA"
             view.backgroundColor = UIColor(patternImage: UIImage(named: "bg1")!)
         } else {
             switchIndicator.text = "SHIMMER"
             view.backgroundColor = UIColor(patternImage: UIImage(named: "bg2")!)
         }
    }
}


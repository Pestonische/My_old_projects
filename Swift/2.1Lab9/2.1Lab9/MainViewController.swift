//
//  MainViewController.swift
//  2.1Lab9
//
//  Created by Ivan on 14.05.2020.
//  Copyright © 2020 Ivan. All rights reserved.
//

import Foundation
import UIKit

class MainViewController : UIViewController{
    
override func viewDidLoad() {
       super.viewDidLoad()
        RegView.isHidden=true;
       // Do any additional setup after loading the view.
       
       
   }
   @IBAction func LoginInputField(_ sender: Any) {
   }
   
@IBAction func ButtonLoginCLicked(_ sender: Any) {
    if(UserDefaults.standard.object(forKey: logAuth.text!) != nil && UserDefaults.standard.object(forKey: logAuth.text!) as! String == passAuth.text)
    {
              performSegue(withIdentifier: "FromStartToMain", sender: self);
    }
}

   @IBAction func StetSwitch(_ sender: Any) {
       if(LOginRegSwitch.selectedSegmentIndex==1){
           RegView.isHidden=false;
       }
       else{
           RegView.isHidden=true;
       }
       
   }
   @IBOutlet weak var logInput: UITextField!
   @IBAction func RegConfButton(_ sender: Any) {
    UserDefaults.standard.set(log.text!,forKey: pass.text!)

       performSegue(withIdentifier: "FromStartToMain", sender: self);
   }
   @IBOutlet weak var reg: UIView!
   @IBOutlet weak var passwordInputField: UITextField!
   @IBOutlet weak var log: UITextField!
     @IBOutlet weak var logAuth: UITextField!
     @IBOutlet weak var passAuth: UITextField!
   
   @IBOutlet weak var pass: UITextField!
   @IBOutlet weak var email: UITextField!
   @IBOutlet weak var passReg: UITextField!
   @IBOutlet weak var logSwitch: UISegmentedControl!
    
    
}

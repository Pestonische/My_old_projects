//
//  ViewController.swift
//  2.1Lab9
//
//  Created by Ivan on 13.05.2020.
//  Copyright © 2020 Ivan. All rights reserved.
//

import UIKit

class ViewController: UIViewController,UICollectionViewDataSource,UICollectionViewDelegate {

    var InfoList = NSDictionary();
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        InfoList.count;
    }
    
    @IBOutlet weak var ViewCollection: UICollectionView!
    
    
     func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        
        let courses = (InfoList.object(forKey: ((InfoList.allKeys ) [indexPath.row]))) as! NSDictionary;
        
        DescriptionField.text=NSLocalizedString(courses.object(forKey: "Description") as! String, comment: "Some comment");
        
        
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView
            .dequeueReusableCell(withReuseIdentifier: "MyCell", for: indexPath) as! CourseCell;
        
        // Configure the cell
        
        let courseInfo = (InfoList.object(forKey: ((InfoList.allKeys ) [indexPath.row]))) as! NSDictionary;
        
        cell.Name.text=(InfoList.allKeys ) [indexPath.row] as? String;
        
        cell.Photo.image=UIImage(named: courseInfo.object(forKey: "Icon") as! String);
        
        return cell
    }
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let fileP = Bundle.main.path(forResource: "CourseInfo", ofType: "plist")
        
        InfoList = NSDictionary(contentsOfFile:fileP!)!
        
        

    }

    @IBOutlet weak var DescriptionField: UITextView!
    
    

}


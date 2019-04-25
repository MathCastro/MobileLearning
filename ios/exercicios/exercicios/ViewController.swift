//
//  ViewController.swift
//  exercicios
//
//  Created by mcastro on 17/04/2019.
//  Copyright © 2019 mcastro. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var userRepository = UserRepository()
    @IBOutlet weak var email: UITextField!
    @IBOutlet weak var password: UITextField!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBAction func login(_ sender: Any) {
        
        if email.text != "" && password.text != "" {
            let user = UserBO(email: email.text!, password: password.text!)
            userRepository.insertUser(user: user)
        }
        
    }
    
}


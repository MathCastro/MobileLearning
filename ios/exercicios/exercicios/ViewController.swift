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
        if(userRepository.findUserByEmail(userEmail: "matheusfk74@gmail.com") == nil) {
            let user = UserBO(email: "matheusfk74@gmail.com", password: "130697")
            userRepository.insertUser(user: user)
        }
    }

    @IBAction func login(_ sender: Any) {
        
        if email.text != "" && password.text != "" {
            if(userRepository.login(userEmail: email.text!, userPassword: password.text!)) {
                print("Pode logar")
                let listView = self.storyboard?.instantiateViewController(withIdentifier: "TableViewController") as! TableViewController
                self.navigationController?.pushViewController(listView, animated: true)
            } else {
                print("Não pode logar")
            }
        }
        
    }
    
}

